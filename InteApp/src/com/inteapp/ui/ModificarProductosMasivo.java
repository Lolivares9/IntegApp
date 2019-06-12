package com.inteapp.ui;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import mappers.MapperPreferencias;
import negocio.Marca;
import services.TableCellRendererColor;
import views.ProductoView;
import controller.ControladorMarcas;
import controller.ControladorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.Toolkit;
import java.io.File;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ModificarProductosMasivo extends javax.swing.JFrame{
	private JComboBox<String> comboBoxMarca;
	private JLabel lblMarca;
	private JScrollPane scrollPane;
	private JButton btnCancelar;
	private JButton btnActualizar;
	private DefaultTableModel model;
	private String pathActualCodBarra;
	private JTable table;
	
	public ModificarProductosMasivo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarProductosMasivo.class.getResource("/Images/IconoVentana.png")));
		setTitle("Actualizar Productos");
		setResizable(false);
		getContentPane().setLayout(null);
		this.setSize(763, 518);
		
		obtenerDirectorios();
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(22, 26, 72, 22);
		getContentPane().add(lblMarca);
		
		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getRowCount() > 0){
					blanquearTabla (model);
				}
				List <ProductoView> productos = ControladorProductos.getInstance().buscarProductosPorMarca(comboBoxMarca.getSelectedItem().toString().trim());
				if (productos != null){
					for (ProductoView prodView : productos){
						model.insertRow(model.getRowCount(),(new Object[]{prodView.getCodigo() , prodView.getDescripcion(), Float.toString(prodView.getPrecio()),Float.toString(prodView.getCosto()),prodView.getStock(),"0"}));
					}
				}

			}
		});
		comboBoxMarca.setBounds(65, 26, 140, 22);
		getContentPane().add(comboBoxMarca);
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 59, 735, 347);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.inactiveCaption);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod. Producto", "Descripcion", "Precio", "Costo", "Stock Actual", "Stock Ingresado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setPreferredWidth(98);
		table.setDefaultRenderer(Object.class, new TableCellRendererColor());
		
		model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ModificarProductosMasivo.class.getResource("/Images/Cancel.png")));
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCancelar.doClick();
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(370, 420, 170, 50);
		getContentPane().add(btnCancelar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(ModificarProductosMasivo.class.getResource("/Images/ZapatoModificar.png")));
		btnActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				boolean productosModificados = true;
				if (camposValidos()){
					for (int i=0; i<model.getRowCount();i++){
						
						String codBarra = model.getValueAt(i, 0).toString().trim();
						Marca m = new Marca (comboBoxMarca.getSelectedItem().toString().trim());
						String descripcion = model.getValueAt(i, 1).toString().trim();
						Float precio = Float.parseFloat(model.getValueAt(i, 2).toString());
						Float costo = Float.parseFloat(model.getValueAt(i, 3).toString());
						int stockIngresado = Integer.parseInt( model.getValueAt(i, 5).toString());
											
						ProductoView prodView = new ProductoView (codBarra,m,descripcion,precio,costo,stockIngresado);
						//GUARDO LOS VALORES ACTUALES POR SI HAY QUE MODIFICAR LA IMAGEN.
						ProductoView p = ControladorProductos.getInstance().buscarProducto(codBarra);
						String marcaActual = p.getMarca().getNombre();
						String descripcionActual = p.getDescripcion();
						//MODIFICO PRODUCTO
						productosModificados = productosModificados && ControladorProductos.getInstance().modificarProducto(prodView);
						if (productosModificados){
							if (!descripcionActual.equals(descripcion)){
								File archModif = new File(pathActualCodBarra+ "\\"+ marcaActual + " - " + descripcionActual +".jpg");
								archModif.renameTo(new File(pathActualCodBarra+ "\\" + m.getNombre() + " - " + descripcion +".jpg"));
							}	
						}
						else{
							if (i > 0){
								String ultimoModificado = m.getNombre() + " - " + model.getValueAt(i-1, 1).toString().trim();
								JOptionPane.showMessageDialog(getContentPane(), "Ocurrió un inconveniento al modificar los productos.\nUltimo producto modificado: " + ultimoModificado,"Ocurrió un inconveniento",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (ModificarProductosMasivo.class.getResource("/Images/nok.png")));	
							}
							break;
						}
					}
					ActualizarColumnasStock();
					JOptionPane.showMessageDialog(getContentPane(), "Productos modificados!","Productos modificados",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (ModificarProductosMasivo.class.getResource("/Images/ok.png")));
				}
			}
		});
		btnActualizar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnActualizar.doClick();
				}
			}
		});

		btnActualizar.setBounds(169, 420, 170, 50);
		getContentPane().add(btnActualizar);
		
		ControladorMarcas.getInstance().cargarComboBoxMarca(comboBoxMarca);		
	}
	private boolean camposValidos() {
		boolean camposCorrectos = true;
		String errores = "";
		for (int i=0; i<model.getRowCount();i++){
			String textDescripcion = model.getValueAt(i, 1).toString().trim();
			String textPrecio = model.getValueAt(i, 2).toString();
			String textCosto = model.getValueAt(i, 3).toString();
			String textStockIngresado = model.getValueAt(i, 5).toString();
			
			if (textStockIngresado.contains("-")){
				int pos = textStockIngresado.indexOf("-");
				model.setValueAt(textStockIngresado.substring(pos), i, 5);
			}
			
			if (!textDescripcion.equals("") && (!textPrecio.equals("")  &&  (textPrecio.matches("[0-9]*+[.]+[0-9]*")|| textPrecio.matches("[0-9]*"))) && (
					!textCosto.equals("")	 && (textCosto.matches("[0-9]*+[.]+[0-9]*") || textCosto.matches("[0-9]*"))) && (!textStockIngresado.equals("") && (textStockIngresado.matches("[0-9]*")|| textStockIngresado.contains("-")))){
				camposCorrectos = camposCorrectos && true;
			}
			else{
				if (textDescripcion.equals("")){
					if (!errores.contains("descripcion")){
						errores = errores + "Debe completar la descripcion del producto.\n";
						camposCorrectos = camposCorrectos && false;
					}
				}
				if (textPrecio.equals("")  ||  !(textPrecio.matches("[0-9]*+[.]+[0-9]*")|| textPrecio.matches("[0-9]*"))){
					if (!errores.contains("precio")){
						errores = errores + "El precio debe estar completado, separando los centavos por un punto.\n";
						camposCorrectos = camposCorrectos && false;
					}
				}
				if (textCosto.equals("") || !(textCosto.matches("[0-9]*+[.]+[0-9]*") || textCosto.matches("[0-9]*"))){
					if (!errores.contains("costo")){
						errores = errores + "El costo debe estar completado, separando los centavos por un punto.\n";
						camposCorrectos = camposCorrectos && false;
					}
				}
				if (textStockIngresado.equals("")	|| !(textStockIngresado.matches("[0-9]*") || textStockIngresado.contains("-"))){
					if (!errores.contains("stock")){
						errores = errores +  "El stock ingresado debe estar completado unicamente con caracteres numéricos.\n";
						camposCorrectos = camposCorrectos && false;
					}
				}
			}
		}
		if (!camposCorrectos){
			JOptionPane.showMessageDialog(getContentPane(), errores ,"datos incorrectos",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (ModificarProductosMasivo.class.getResource("/Images/information.png")));
		}
		return camposCorrectos;
	}
	private void obtenerDirectorios() {
		//SETEO LOS DIRECTORIOS ACTUALES
		pathActualCodBarra = MapperPreferencias.selectValuePreferencia("Codigos de Barra");
	}
	
	public void validarComboBox() {
		if (comboBoxMarca.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(getContentPane(), "No se encontraron marcas existentes.\nPrimero debe crear una Marca para los productos.","Marcas inexistentes", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (ModificarProductosMasivo.class.getResource("/Images/nok.png")));
			dispose();
		}
	}
	private void blanquearTabla(DefaultTableModel model) {
		int i = model.getRowCount();
		while (i>1){
			model.removeRow(0);
			i--;
		}
	}
	private void ActualizarColumnasStock() {
		for (int i=0; i<model.getRowCount();i++){
			int stockActual = Integer.parseInt(model.getValueAt(i, 4).toString());
			int stockIngresado = Integer.parseInt(model.getValueAt(i, 5).toString());
			int nuevoStock = stockActual + stockIngresado;
			model.setValueAt(nuevoStock, i, 4);
			model.setValueAt("0", i, 5);
		}
	}
}

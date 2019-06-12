package com.inteapp.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import views.ProductoView;
import negocio.ItemVenta;
import negocio.Producto;
import controller.ControladorProductos;
import controller.ControladorVentas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class NuevaVenta extends javax.swing.JFrame{
	private static final long serialVersionUID = 7337044116767570123L;
	private JTextField txtNroVenta;
	private JTextField txtTotal;
	private JTextField txtEstado;
	private JTextField txtFecha;
	private JLabel lblNroVenta;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JLabel lblTotal;
	private JLabel lblHora;
	private JButton btnAgregarItems;
	private JButton btnCancelar;	
	private JScrollPane scrollPane;	
	private JTable table;
	private DefaultTableModel model;
	private AgregarItemVenta ventanaAgregarItem;
	private JButton btnCrearVenta;
	private JTextField txtHora;

	public NuevaVenta(final MonitoreoDeVentas monitoreoVentas) {
		setTitle("Nueva Venta");
		//propiedades de las ventanas
		setResizable(false);
		this.setSize(637, 473);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(35, 86, 78, 14);
		lblTotal = new JLabel("Total");
		lblTotal.setBounds(461, 339, 63, 14);
		lblNroVenta = new JLabel("Nro. Venta");
		lblNroVenta.setBounds(35, 42, 78, 14);
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(330, 45, 78, 14);
		getContentPane().add(lblFecha);
		txtNroVenta = new JTextField();
		txtNroVenta.setBounds(123, 39, 160, 20);
		txtNroVenta.setColumns(10);
		txtTotal = new JTextField();
		txtTotal.setBounds(522, 336, 78, 20);
		txtTotal.setColumns(10);
		txtEstado = new JTextField();
		txtEstado.setBounds(123, 83, 160, 20);
		txtEstado.setColumns(10);
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(418, 42, 160, 20);
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(418, 83, 160, 20);
		
		btnAgregarItems = new JButton("Agregar Productos");
		btnAgregarItems.setIcon(new ImageIcon(NuevaVenta.class.getResource("/Images/ZapatoNuevo.png")));
		btnAgregarItems.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnAgregarItems.doClick();
				}
			}
		});
		btnAgregarItems.setBounds(231, 374, 170, 50);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(NuevaVenta.class.getResource("/Images/Cancel.png")));
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
		btnCancelar.setBounds(430, 374, 170, 50);
		//scrollpane
		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 137, 565, 188);
		//table
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Producto", "Precio Unit.", "Cantidad", "Subtotal"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setEnabled(false);
		table.setShowHorizontalLines(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		//accion que realiza el boton agregar items
		btnAgregarItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCrearVenta.requestFocus();
				ventanaAgregarItem = new AgregarItemVenta(model, txtTotal);
				ventanaAgregarItem.setVisible(true);
				ventanaAgregarItem.setLocationRelativeTo(getContentPane());
			}
		});
		//posicion de los componentes en la ventana
		getContentPane().setLayout(null);
		getContentPane().add(lblNroVenta);
		getContentPane().add(lblTotal);
		getContentPane().add(lblEstado);
		getContentPane().add(txtNroVenta);
		getContentPane().add(txtTotal);
		getContentPane().add(txtEstado);
		getContentPane().add(scrollPane);
		getContentPane().add(btnAgregarItems);
		getContentPane().add(btnCancelar);
		getContentPane().add(txtFecha);
		getContentPane().add(txtHora);
		
		btnCrearVenta = new JButton("Crear Venta");
		btnCrearVenta.setIcon(new ImageIcon(NuevaVenta.class.getResource("/Images/VentaNueva2.png")));
		btnCrearVenta.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCrearVenta.doClick();
				}
			}
		});
		btnCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getRowCount() > 0 && !txtTotal.getText().equals("")){
					List<ItemVenta> itemsVenta = cargarItemsVenta();
					boolean ventaCreada = ControladorVentas.getInstance().nuevaVenta(itemsVenta, Float.parseFloat(txtTotal.getText()) , txtFecha.getText(), txtEstado.getText(),txtHora.getText());
					if (ventaCreada){
						for (ItemVenta it: itemsVenta){
							Producto p = it.getProd();
							ProductoView prodView = new ProductoView(p.getCodigo(), p.getMarca(),  p.getDescripcion(),p.getPrecio(), p.getCosto(), p.getStock());
							ControladorProductos.getInstance().actualizarStockProducto(prodView, - it.getCantidad());
						}
						monitoreoVentas.cargarNuevaVenta(txtNroVenta.getText(),txtHora.getText().substring(0, 5), itemsVenta);
						JOptionPane.showMessageDialog(getContentPane(), "Venta creada correctamente!","Venta Creada",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (NuevaVenta.class.getResource("/Images/ok.png")));
					}
					dispose();
				}
				else if (model.getRowCount() <= 0){
					JOptionPane.showMessageDialog(getContentPane(), "La venta debe contener productos","Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnCrearVenta.setBounds(35, 374, 170, 50);
		getContentPane().add(btnCrearVenta);
		btnCrearVenta.requestFocus();
		String codigo = Long.toString(ControladorVentas.getInstance().getCodigoVenta() + 1);
		txtNroVenta.setText(codigo);
		txtNroVenta.setEditable(false);
		
		String fechaCompleta = obtenerFechaActual();
		txtFecha.setText(fechaCompleta.substring(0,10));
		txtFecha.setEditable(false);
		txtHora.setText(fechaCompleta.substring(11, 19));
		txtHora.setEditable(false);
		
		txtEstado.setText("VENDIDO");
		txtEstado.setEditable(false);
		txtTotal.setEditable(false);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(330, 86, 46, 14);
		getContentPane().add(lblHora);		
	}
	protected String obtenerFechaActual() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fecha = dateformat.format(cal.getTime());
		return fecha;
	}
	private List<ItemVenta> cargarItemsVenta() {
		List<ItemVenta> items = new ArrayList<ItemVenta>();
		for (int i=0; i<model.getRowCount();i++){
			String codigoProd = model.getValueAt(i, 0).toString();
			int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
			ProductoView prodView = ControladorProductos.getInstance().buscarProducto (codigoProd);
			prodView.setStock(cantidad);
			Producto prod = new Producto (prodView.getCodigo(),prodView.getMarca(), prodView.getDescripcion(), prodView.getPrecio(), prodView.getCosto(), prodView.getStock());
			ItemVenta it = new ItemVenta (prod, cantidad);
			items.add(it);
		}
		return items;
	}
	public void AgregarItem() {
		btnAgregarItems.doClick();
	}
}


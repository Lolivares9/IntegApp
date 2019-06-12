package com.inteapp.ui;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import negocio.ItemVenta;
import negocio.Producto;
import services.CodeBarGenerator;
import views.ProductoView;
import controller.ControladorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

public class AgregarItemVenta extends javax.swing.JFrame{
	private static final long serialVersionUID = 7337044116767570123L;
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JLabel lblCantidad;
	private JLabel lblMarca;
	private JLabel pnlCodigo;
	private JTextField txtCodigoBarra;
	private JTextField txtDescripcion;
	private JTextField txtCant;
	private JTextField txtMarca;
	private JButton btnCerrar;
	private JButton btnAgregar;
	private JLayeredPane layeredPane;
	public ItemVenta item;
	
	public AgregarItemVenta(final DefaultTableModel model, final JTextField txtTotal) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarItemVenta.class.getResource("/Images/IconoVentana.png")));
		setResizable(false);
		//PROPIEDADES DE LA VENTANA
		setTitle("Agregar Productos");
		this.setSize(460, 264);
		getContentPane().setLayout(null);
		//INICIALIZACION DE LAS VARIABLES
		//LABELS
		lblCodigo = new JLabel("");
		lblCodigo.setIcon(new ImageIcon(AgregarItemVenta.class.getResource("/Images/barcode3.png")));
		lblCodigo.setBounds(10, 26, 55, 20);
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 115, 79, 14);
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 54, 55, 14);
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 84, 79, 14);
		//TEXTFIELDS
		txtCodigoBarra = new JTextField();
		txtCodigoBarra.setText("");
		txtCodigoBarra.setBounds(86, 26, 118, 20);
		txtCodigoBarra.setColumns(10);
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(86, 54, 118, 20);
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(86, 84, 118, 20);
		txtCant = new JTextField();
		txtCant.setColumns(10);
		txtCant.setBounds(86, 115, 60, 20);
		//BUTTON
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(AgregarItemVenta.class.getResource("/Images/ZapatoNuevo.png")));
		btnAgregar.setBounds(80, 165, 124, 48);
		btnAgregar.setEnabled(false);
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(AgregarItemVenta.class.getResource("/Images/Cancel.png")));
		btnCerrar.setBounds(225, 165, 124, 48);
		//PANEL
		pnlCodigo = new JLabel();
		pnlCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCodigo.setBounds(10, 11, 184, 76);
		pnlCodigo.setBackground(Color.WHITE);
		//LAYEREDPANE
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setForeground(Color.WHITE);
		layeredPane.setToolTipText("");
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBounds(225, 23, 204, 97);
		layeredPane.add(pnlCodigo);
		//ACTION ENTER TEXTFIELD CODIGO DE BARRAS
		txtCodigoBarra.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					ProductoView p = ControladorProductos.getInstance().buscarProducto(txtCodigoBarra.getText());
					if (p != null){
						p.setStock(actualizarStockDisponible(txtCodigoBarra.getText(), p.getStock()));
						if (p.getStock() < 1){
							if (JOptionPane.showConfirmDialog(getContentPane(), "<html><p align=\"center\">El producto no cuenta con stock disponible para la venta.<br><p align=\"center\">¿Desea ingresar stock del mismo?</p></html>", "Stock no disponible",
					                JOptionPane.YES_NO_OPTION,
					                JOptionPane.INFORMATION_MESSAGE, 
					                new ImageIcon (AgregarItemVenta.class.getResource ("/Images/warning.png"))) == JOptionPane.YES_OPTION){
								IngresarStock ingresarStock = new IngresarStock();
								ingresarStock.setLocationRelativeTo(getContentPane());
								ingresarStock.setVisible(true);
								ingresarStock.cargarCodigoDelProducto(txtCodigoBarra.getText());
							}
							else{
								blanquearCampos();
							}
						}
						else{
							txtCodigoBarra.setEditable(false);
							txtMarca.setText(p.getMarca().getNombre());
							txtMarca.setEditable(false);
							txtDescripcion.setText(p.getDescripcion());
							txtDescripcion.setEditable(false);
							txtCant.setText("1");
							txtCant.requestFocus();
							txtCant.selectAll();
							traerCodigo();
							btnAgregar.setEnabled(true);
						}
					}
					else{
						JOptionPane.showMessageDialog(getContentPane(), "Producto no encontrado.","Error", JOptionPane.ERROR_MESSAGE);
						txtCodigoBarra.requestFocus();
					}
				}
			}
			private int actualizarStockDisponible(String codProd, int stockProd) {
				for (int i=0; i < model.getRowCount(); i++){
					if (model.getValueAt(i, 0).toString().equals(codProd)){
						stockProd = stockProd - Integer.parseInt(model.getValueAt(i, 3).toString());
					}
				}
				return stockProd;
			}
		});
		//ACTION BUTTON AGREGAR
		btnAgregar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnAgregar.doClick();
				}
			}
		});
		//ACCION BOTON AGREGAR
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtCodigoBarra.getText().isEmpty()) {
					ProductoView p = ControladorProductos.getInstance().buscarProducto(txtCodigoBarra.getText());
					if (p != null){
						if ((p.getStock() - Integer.parseInt(txtCant.getText())) < 0){
							if (JOptionPane.showConfirmDialog(getContentPane(), "<html><p align=\"center\">El producto no cuenta con el stock suficiente para satisfacer la compra.<br>Actualmente se encuentran " + Integer.toString(p.getStock()) + " Pares disponibles para la venta.<br><p align=\"center\">¿Desea ingresar stock del mismo?</p></html>", "Stock insuficiente",
					                JOptionPane.YES_NO_OPTION,
					                JOptionPane.INFORMATION_MESSAGE, 
					                new ImageIcon (AgregarItemVenta.class.getResource ("/Images/warning.png"))) == JOptionPane.YES_OPTION){
								IngresarStock ingresarStock = new IngresarStock();
								ingresarStock.setLocationRelativeTo(getContentPane());
								ingresarStock.setVisible(true);
								ingresarStock.cargarCodigoDelProducto(txtCodigoBarra.getText());
							}
							else{
								blanquearCampos();
							}
						}
						else{
							Producto prod = new Producto (p.getCodigo(), p.getMarca(), p.getDescripcion(), p.getPrecio(), p.getCosto(), p.getStock());
							item = new ItemVenta(prod, Integer.parseInt(txtCant.getText()));
							model.insertRow(model.getRowCount(),(new Object[]{prod.getCodigo() ,prod.getMarca().getNombre() + " - " + prod.getDescripcion(), Float.toString(prod.getPrecio()),Integer.toString(item.getCantidad()),Float.toString(item.subTotal())}));
							blanquearCampos();
							calcularTotal(model, txtTotal);
							dispose();
						}
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "Producto no encontrado.","Error", JOptionPane.ERROR_MESSAGE,new ImageIcon (AgregarItemVenta.class.getResource ("/Images/warning.png")));;
						txtCodigoBarra.requestFocus();
						txtCodigoBarra.selectAll();
					}
				}
			}
		});
		//ACTION BUTTON CERRAR
		btnCerrar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCerrar.doClick();
				}
			}
		});
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//ACTION ENTER TEXTFIELD CANTIDAD
		txtCant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnAgregar.doClick();
				}
			}
		});
		//AGREGO COMPONENTES EN LA VENTANA
		getContentPane().add(txtMarca);
		getContentPane().add(lblCodigo);
		getContentPane().add(txtCodigoBarra);
		getContentPane().add(lblMarca);
		getContentPane().add(layeredPane);
		getContentPane().add(lblCantidad);
		getContentPane().add(txtCant);
		getContentPane().add(btnAgregar);
		getContentPane().add(txtDescripcion);
		getContentPane().add(lblDescripcion);
		getContentPane().add(btnCerrar);
		
	}
	/**GENERA EL CODIGO DE BARRA CON EL NUMERO QUE CONTIENE EL TEXTFIELD CODIGO DE BARRAS**/
	private void traerCodigo(){
		CodeBarGenerator cbg = new CodeBarGenerator();
		BufferedImage im = cbg.generarCodigo(txtCodigoBarra.getText());
		ImageIcon img = new ImageIcon(im);
		pnlCodigo.setIcon(img);
	}
	/**BLANQUEA LOS CAMPOS LUEGO DE AGREGAR UN ITEM A LA VENTA, PERMITIENDO INGRESAR UN NUEVO PRODUCTO**/
	private void blanquearCampos() {
		pnlCodigo.setIcon(null);
		txtCodigoBarra.setText("");
		txtCodigoBarra.setEditable(true);
		txtMarca.setText("");
		txtMarca.setEditable(true);
		txtDescripcion.setText("");
		txtDescripcion.setEditable(true);
		txtCant.setText("");
		txtCodigoBarra.requestFocus();
	}
	/**LUEGO DE AGREGAR CADA ITEM, ACTUALIZA EL TOTAL DE LA VENTA**/
	protected void calcularTotal(DefaultTableModel model, JTextField txtTotal) {
		float total = 0;
		for (int i=0; i<model.getRowCount();i++){
			float subtotal = 0;
			subtotal = Float.parseFloat(model.getValueAt(i, 4).toString());
			total = total + subtotal;
		}
		txtTotal.setText(Float.toString(total));
	}
}

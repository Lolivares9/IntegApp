package com.inteapp.ui;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import negocio.ItemVenta;
import controller.ControladorVentas;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MonitoreoDeVentas extends javax.swing.JFrame{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;	
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtFecha;
	private JTextField txtTotal;
	private JTextField txtCantVendida;
	private JLabel lblVentas;
	private JTextField txtVentas;
	private JLabel lblFecha;
	private JLabel lblTotal;
	private JLabel lblCantidadVendida;
	
	public MonitoreoDeVentas(){
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		setTitle("Ventas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MonitoreoDeVentas.class.getResource("/Images/IconoVentana.png")));
		//ACTION AL CERRAR LA VENTANA
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(getContentPane(), 
		                "¿Desea ocultar el monitoreo de las ventas?", "Cerrar", 
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        		setVisible(false);
		            }
		    }
		});
		//JTEXTFIELD
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(85, 485, 86, 22);
		
		txtVentas = new JTextField();
		txtVentas.setColumns(10);
		txtVentas.setBounds(269, 485, 55, 22);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(642, 485, 60, 22);
		
		txtCantVendida = new JTextField();
		txtCantVendida.setColumns(10);
		txtCantVendida.setBounds(475, 485, 55, 22);
		
		//LABELS
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setIcon(new ImageIcon(MonitoreoDeVentas.class.getResource("/Images/calendar.png")));
		lblFecha.setBounds(20, 485, 80, 20);
		
		lblTotal = new JLabel("Total  $");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setIcon(new ImageIcon(MonitoreoDeVentas.class.getResource("/Images/Money.png")));
		lblTotal.setBounds(575, 485, 70, 20);
		
		lblCantidadVendida = new JLabel("Cant. Vendida");
		lblCantidadVendida.setForeground(Color.WHITE);
		lblCantidadVendida.setIcon(new ImageIcon(MonitoreoDeVentas.class.getResource("/Images/Zapato.png")));
		lblCantidadVendida.setBounds(355, 485, 108, 20);
		
		lblVentas = new JLabel("Ventas");
		lblVentas.setForeground(Color.WHITE);
		lblVentas.setIcon(new ImageIcon(MonitoreoDeVentas.class.getResource("/Images/VentaNueva2.png")));
		lblVentas.setBounds(197, 485, 80, 20);
		//JTABLE
		table = new JTable(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Cod. Venta","Hora", "Producto", "Precio Unit.", "Cantidad", "Subtotal"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		//MODEL
		model = (DefaultTableModel) table.getModel();
		//SCROLLPANE
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 727, 470);
		scrollPane.setViewportView(table);
		
		//ADD COMPONENT ON GETCONTENTPANE()
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane); 
		getContentPane().add(lblFecha);
		getContentPane().add(txtFecha);
		getContentPane().add(txtVentas);
		getContentPane().add(lblVentas);		
		getContentPane().add(txtCantVendida);
		getContentPane().add(lblCantidadVendida);
		getContentPane().add(txtTotal);
		getContentPane().add(lblTotal);
		
		//CARGO FECHA ACTUAL
		txtFecha.setText(obtenerFechaActual());
		txtFecha.setEditable(false);
		//CARGO LA TABLA CON LAS VENTAS EXISTENTES.
		cargarVentasExistentes();
		
		setSize (732,560);
	}
	private void cargarVentasExistentes() {
		ControladorVentas.getInstance().obtenerVentasDelDia(model, txtFecha.getText(), txtVentas);
		txtVentas.setEditable(false);
		txtCantVendida.setText(Integer.toString(obtenerCantidadVendida()));
		txtCantVendida.setEditable(false);
		txtTotal.setText(Float.toString(calcularTotal()));
		txtTotal.setEditable(false);
	}
	private float calcularTotal() {
		float total=0;
		for (int i=0; i< model.getRowCount(); i++){
			total = total + Float.parseFloat(model.getValueAt(i, 5).toString());
		}
		return total;
	}
	private int obtenerCantidadVendida() {
		int cantVendida=0;
		for (int i=0; i< model.getRowCount(); i++){
			cantVendida = cantVendida + Integer.parseInt(model.getValueAt(i, 4).toString());
		}
		return cantVendida;
	}
	protected String obtenerFechaActual() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = dateformat.format(cal.getTime());
		return fecha;
	}
	public void cargarNuevaVenta(String nroVenta, String hora, List<ItemVenta> itemsVenta) {
		for (ItemVenta item: itemsVenta){
			model.insertRow(model.getRowCount(),(new Object[]{nroVenta,hora, item.getProd().getMarca().getNombre() + " - " + item.getProd().getDescripcion(), item.getProd().getPrecio(),Integer.toString(item.getCantidad()),Float.toString(item.subTotal())}));
		}
		txtVentas.setText(Integer.toString(Integer.parseInt(txtVentas.getText()) + 1));
		txtCantVendida.setText(Integer.toString(obtenerCantidadVendida()));
		txtTotal.setText(Float.toString(calcularTotal()));
	}
	public void quitarProductos(int codVenta) {
		for (int i=0 ; i<model.getRowCount(); i++){
			if (model.getValueAt(i, 0).equals(Integer.toString(codVenta))){
				model.removeRow(i);
			}
		}
		txtVentas.setText(Integer.toString(Integer.parseInt(txtVentas.getText()) - 1));
		txtCantVendida.setText(Integer.toString(obtenerCantidadVendida()));
		txtTotal.setText(Float.toString(calcularTotal()));
	}	
}

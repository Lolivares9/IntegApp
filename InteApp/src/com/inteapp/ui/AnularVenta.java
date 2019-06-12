package com.inteapp.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControladorProductos;
import controller.ControladorVentas;

import javax.swing.JComboBox;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import views.ProductoView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
public class AnularVenta extends javax.swing.JFrame{
	private static final long serialVersionUID = 5693320261495882599L;
	private UtilDateModel modelDate;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JLabel lblListVent;
	private JLabel lblListProd;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JFormattedTextField txtFecha;
	private JButton btnDate;
	private JButton btnCancelar;
	private JButton btnAnularVenta;
	private JComboBox<String> cboListVentas;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;	

	public AnularVenta(final MonitoreoDeVentas monitoreoVentas) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnularVenta.class.getResource("/Images/IconoVentana.png")));
		//PROPIEDADES DE LA VENTANA
		setTitle("Anular Venta");
		setResizable(false);
		this.setSize(637, 475);
		getContentPane().setLayout(null);
		//INICIALIZACION DE LAS VARIABLES
		modelDate = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Hoy");
		p.put("text.month", "Mes");
		p.put("text.year", "Año");
		//DATEPANEL
		datePanel = new JDatePanelImpl(modelDate, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setDoubleClickAction(true);
		datePicker.setMaximumSize(new Dimension(52, 25));
		datePicker.setBounds(123, 37, 160, 25);
		//LABELS
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(35, 83, 78, 14);	
		lblCodigo = new JLabel("");
		lblCodigo.setIcon(new ImageIcon(AnularVenta.class.getResource("/Images/barcode3.png")));
		lblCodigo.setBounds(375, 32, 34, 30);
		lblFecha = new JLabel("Fecha Venta");
		lblFecha.setBounds(35, 40, 78, 14);
		lblListProd = new JLabel("Listado de productos");
		lblListProd.setBounds(35, 168, 120, 14);
		lblListVent = new JLabel("Listado de ventas");
		lblListVent.setBounds(35, 122, 109, 14);
		//TEXTFIELDS
		txtFecha = datePicker.getJFormattedTextField();
		txtFecha.setPreferredSize(new Dimension(10, 20));
		txtCodigo = new JTextField();
		txtCodigo.setBounds(415, 37, 160, 20);
		txtCodigo.setColumns(10);
		txtCodigo.requestFocus();
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(123, 80, 452, 20);
		txtDescripcion.setColumns(10);
		txtDescripcion.setEditable(false);
		//BUTTON
		btnDate = (JButton) datePicker.getComponents()[1];
		btnDate.setText(null);
		btnDate.setPreferredSize(new Dimension(20, 20));
		btnDate.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/calendar.png")));
		btnDate.setBorder(null);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(AnularVenta.class.getResource("/Images/Cancel.png")));
		btnCancelar.setBounds(459, 384, 141, 30);
		btnAnularVenta = new JButton("Anular Venta");
		btnAnularVenta.setSelectedIcon(null);
		btnAnularVenta.setIcon(new ImageIcon(AnularVenta.class.getResource("/Images/VentaAnular.png")));
	    btnAnularVenta.setBounds(35, 384, 141, 30);
	    btnAnularVenta.setEnabled(false);
		//COMBOBOX
		cboListVentas = new JComboBox<String>();
		cboListVentas.setBounds(35, 137, 565, 20);
		cboListVentas.setEnabled(false);
		cboListVentas.setSelectedItem(null);
		//TABLE
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Producto", "Precio Unit.", "Cantidad", "Subtotal"
			}
		));
		table.setShowHorizontalLines(false);
		table.setColumnSelectionAllowed(true);
		table.setEnabled(false);
		table.setShowHorizontalLines(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		model = (DefaultTableModel) table.getModel();
		
		//SCROLLPANEL
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 185, 565, 188);
		scrollPane.setViewportView(table);
		
		//Acción al presionar 'Enter' en el campo de código
		txtCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					if (!txtCodigo.getText().equals("") && !txtFecha.getText().equals("")){
						ProductoView p = ControladorProductos.getInstance().buscarProducto(txtCodigo.getText().trim());
						if (p!= null){
							txtDescripcion.setText(p.getMarca().getNombre() + " - " + p.getDescripcion());
						}
						Map<Integer, String[]> s = ControladorVentas.getInstance().buscarVentas(txtCodigo.getText(), txtFecha.getText().substring(0, 10));
						if (s.isEmpty()){
							JOptionPane.showMessageDialog(getContentPane(), "No se han encontrado ventas con las caracteristicas indicadas","Venta no encontrada", JOptionPane.INFORMATION_MESSAGE,new ImageIcon (AnularVenta.class.getResource("/Images/information.png")));
							txtDescripcion.setText("");
						}
						else{
							for(int i = 1; i<=s.size();i++) {
								cboListVentas.addItem("Código Venta: "+s.get(i)[0]+" Total: "+s.get(i)[1]);
							}
							cboListVentas.setEnabled(true);
							btnAnularVenta.setEnabled(true);
							txtCodigo.setEnabled(false);
							txtCodigo.setEditable(false);
							datePicker.setEnabled(false);
							cboListVentas.requestFocus();
						}
					}else if (txtFecha.getText().equals("")){
						JOptionPane.showMessageDialog(getContentPane(), "Debe completar la fecha","Error", JOptionPane.INFORMATION_MESSAGE,new ImageIcon (AnularVenta.class.getResource("/Images/information.png")));
						txtFecha.requestFocus();
					}else if (txtCodigo.getText().equals("") ){
						JOptionPane.showMessageDialog(getContentPane(), "Debe completar el codigo","Error", JOptionPane.INFORMATION_MESSAGE,new ImageIcon (AnularVenta.class.getResource("/Images/information.png")));
						txtCodigo.requestFocus();
					}
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}); 
        //Acción del boton Anular Venta
        btnAnularVenta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
		        if (JOptionPane.showConfirmDialog(AnularVenta.this, 
		            "¿Esta seguro que desea anular la venta seleccionada?", "Anular", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE,
		            new ImageIcon (AnularVenta.class.getResource("/Images/question.png"))) == JOptionPane.YES_OPTION){
			        		boolean anulada = ControladorVentas.getInstance().anularVenta(Integer.parseInt(((String) cboListVentas.getSelectedItem()).substring(13, ((String) cboListVentas.getSelectedItem()).indexOf(" Total")).trim()));
			        		if (anulada){
			        			JOptionPane.showMessageDialog(getContentPane(), "Venta anulada correctamente!","Venta Anulada",JOptionPane.INFORMATION_MESSAGE, new ImageIcon (AnularVenta.class.getResource("/Images/deleteOK.png")));
				        		monitoreoVentas.quitarProductos(Integer.parseInt(((String) cboListVentas.getSelectedItem()).substring(13, ((String) cboListVentas.getSelectedItem()).indexOf(" Total")).trim()));
				        		if(cboListVentas.getItemCount() > 1) {
				        			cboListVentas.removeItemAt(cboListVentas.getSelectedIndex());
				        			cboListVentas.setSelectedItem(null);
				        		}else{
				        			JOptionPane.showMessageDialog(getContentPane(), "Se eliminaron todas las ventas del producto en la fecha seleccionada","Informacion", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (AnularVenta.class.getResource("/Images/information.png")));
				        			dispose();
				        		}
				        		dispose();
			        		}
		            }
        	}
        });
		cboListVentas.addItemListener(new ItemChangeListener());
		
		//AGREGO COMPONENTES EN LA VENTANA	
		getContentPane().add(datePicker);		
		getContentPane().add(lblDescripcion);
		getContentPane().add(lblCodigo);		
		getContentPane().add(lblFecha);	
		getContentPane().add(txtCodigo);
		getContentPane().add(txtDescripcion);
		getContentPane().add(cboListVentas);	
		getContentPane().add(btnCancelar);
		getContentPane().add(scrollPane);
		getContentPane().add(lblListVent);
        getContentPane().add(btnAnularVenta);
		getContentPane().add(lblListProd);
	}
	
	/**OBTENGO FECHA ACTUAL**/
	/*protected String obtenerFechaActual() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = dateformat.format(cal.getTime());
		return fecha;
	}*/
	
	/**ACCION QUE REALIZA AL SELECCIONAR UN ITEM EN EL COMBOBOX**/
	class ItemChangeListener implements ItemListener{
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	          Object item = event.getItem();
	          model.setRowCount(0);
	          String selected = (String) item;
	          String codV = selected.substring(13, selected.indexOf(" Total")).trim();
	          Map<Integer, String[]> items = ControladorVentas.getInstance().buscarItemsVenta(codV);
	          for(int i = 1; i<=items.size();i++) {
	        	  model.addRow(new Object[]{items.get(i)[0] ,items.get(i)[1], items.get(i)[2], items.get(i)[3], items.get(i)[4]});
	          }
	       }
	    }       
	}
	/**DATELABELFORMATTER PARA MOSTRAR UN CALENDARIO**/
	public class DateLabelFormatter extends AbstractFormatter {
		private static final long serialVersionUID = -9062046152735072239L;
		private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }	
	        return "";
	    }	 
	}
}

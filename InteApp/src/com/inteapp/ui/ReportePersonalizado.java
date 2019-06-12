package com.inteapp.ui;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import reports.ControladorReportes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class ReportePersonalizado extends javax.swing.JFrame{
	private static final long serialVersionUID = 1L;
	private UtilDateModel modelDate1;
	private UtilDateModel modelDate2;
	private Properties p;
	private JDatePanelImpl datePanelInicio;
	private JDatePanelImpl datePanelFin;
	private JDatePickerImpl datePickerInicio;
	private JDatePickerImpl datePickerFin;
	private JButton btnDateIni;
	private JButton btnDateFin;
	private JFormattedTextField txtFechaIni;
	private JFormattedTextField txtFechaFin;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private JButton btnGenerar;
	private JButton btnCancelar;
	
	public ReportePersonalizado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReportePersonalizado.class.getResource("/Images/IconoVentana.png")));
		setResizable(false);
		this.setSize(347, 150);
		getContentPane().setLayout(null);
		//INICIALIZACION DE LAS VARIABLES
		modelDate1 = new UtilDateModel();
		modelDate2 = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Hoy");
		p.put("text.month", "Mes");
		p.put("text.year", "Año");
		
		//DATEPANEL-INICIO
		datePanelInicio = new JDatePanelImpl(modelDate1, p);
		datePickerInicio = new JDatePickerImpl(datePanelInicio, new DateLabelFormatter());
		datePickerInicio.setDoubleClickAction(true);
		datePickerInicio.setBounds(29, 36, 120, 30);
		//Text Ini
		txtFechaIni = datePickerInicio.getJFormattedTextField();
		txtFechaIni.setPreferredSize(new Dimension(10, 20));
		//Boton Ini
		btnDateIni = (JButton) datePickerInicio.getComponents()[1];
		btnDateIni.setText(null);
		btnDateIni.setPreferredSize(new Dimension(20, 20));
		btnDateIni.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/calendar.png")));
		btnDateIni.setBorder(null);
		getContentPane().add(datePickerInicio);
		datePanelInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Date selected")){
					modelDate2.setDate(modelDate1.getYear(),modelDate1.getMonth(),modelDate1.getDay());
					btnDateFin.setEnabled(true);
					txtFechaFin.setText(txtFechaIni.getText());
				}
				
			}
		});
		
		//DATEPANEL-FIN
		datePanelFin = new JDatePanelImpl(modelDate2, p);
		datePickerFin = new JDatePickerImpl(datePanelFin, new DateLabelFormatter());
		datePickerFin.setDoubleClickAction(true);
		datePickerFin.setBounds(190, 36, 120, 30);
		//Text Fin
		txtFechaFin = datePickerFin.getJFormattedTextField();
		txtFechaFin.setPreferredSize(new Dimension(10, 20));
		//Boton Fin
		btnDateFin = (JButton) datePickerFin.getComponents()[1];
		btnDateFin.setText(null);
		btnDateFin.setPreferredSize(new Dimension(20, 20));
		btnDateFin.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/calendar.png")));
		btnDateFin.setBorder(null);
		getContentPane().add(datePickerInicio);
		getContentPane().add(datePickerFin);
		btnDateFin.setEnabled(false);
		
		lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaInicio.setBounds(29, 11, 87, 14);
		getContentPane().add(lblFechaInicio);
		
		lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaFin.setBounds(190, 11, 87, 14);
		getContentPane().add(lblFechaFin);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setIcon(new ImageIcon(ReportePersonalizado.class.getResource("/Images/Reporte.png")));
		btnGenerar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnGenerar.doClick();
				}
			}
		});
		//ACCION BOTON GENERAR
		btnGenerar.setBounds(29, 77, 120, 31);
		getContentPane().add(btnGenerar);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtFechaFin.getText().equals("") && !txtFechaIni.getText().equals("")){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date dateDesde = null;
					Date dateHasta = null;
					try {
						dateDesde = formatter.parse(txtFechaIni.getText());
						dateHasta = formatter.parse(txtFechaFin.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if((dateDesde.compareTo(dateHasta))<=0) {
						ControladorReportes.getInstance().reporteVentasPersonalizado(dateDesde,dateHasta);
						dispose();
					}else{
						JOptionPane.showMessageDialog(getContentPane(), "La fecha de inicio debe ser anterior a la fecha de fin para generar el reporte","Campos incorrectos",JOptionPane.INFORMATION_MESSAGE, new ImageIcon (ReportePersonalizado.class.getResource("/Images/information.png")));
					}	
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Debe completar todos los campos para generar el reporte","Campos incompletos",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (ReportePersonalizado.class.getResource("/Images/information.png")));	
				}
			}
		});	
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ReportePersonalizado.class.getResource("/Images/Cancel.png")));
		btnCancelar.setBounds(190, 77, 120, 31);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCancelar.doClick();
				}
			}
		});

		
		getContentPane().add(btnCancelar);
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

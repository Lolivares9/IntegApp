package com.inteapp.ui;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import reports.ControladorReportes;
import controller.ControladorMarcas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class ReportePorMarca extends javax.swing.JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JComboBox<String> comboBoxMarca;
	private JButton btnGenerarReporte;
	private JButton btnCancelar;
	private String tipoRep;
	public ReportePorMarca(String tipoReporte) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReportePorMarca.class.getResource("/Images/IconoVentana.png")));
		tipoRep = tipoReporte;
		setResizable(false);
		getContentPane().setLayout(null);
		this.setSize(309, 164);
		label = new JLabel("Marca");
		label.setBounds(36, 20, 46, 22);
		getContentPane().add(label);
		
		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.setBounds(92, 21, 181, 20);
		getContentPane().add(comboBoxMarca);
		
		btnGenerarReporte = new JButton("Generar");
		btnGenerarReporte.setIcon(new ImageIcon(ReportePorMarca.class.getResource("/Images/Reporte.png")));
		btnGenerarReporte.setBounds(36, 74, 110, 40);
		getContentPane().add(btnGenerarReporte);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ReportePorMarca.class.getResource("/Images/Cancel.png")));
		btnCancelar.setBounds(168, 74, 110, 40);
		getContentPane().add(btnCancelar);
		//CARGO EL COMBOBOX MARCA CON LAS MARCAS EXISTENTES
		ControladorMarcas.getInstance().cargarComboBoxMarca(comboBoxMarca);
		//ACTION BUTTON CANCELAR
		btnCancelar.addKeyListener(new KeyAdapter() {
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
		btnGenerarReporte.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnGenerarReporte.doClick();
				}
			}
		});
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipoRep.equals("Diario")){
				ControladorReportes.getInstance().reporteVentasDiariasPorMarca(comboBoxMarca.getSelectedItem().toString());
				}else if(tipoRep.equals("Semanal")){
					ControladorReportes.getInstance().reporteVentasSemanalesPorMarca(comboBoxMarca.getSelectedItem().toString());
				}else if(tipoRep.equals("Mensual")){
					ControladorReportes.getInstance().reporteVentasMensualesPorMarca(comboBoxMarca.getSelectedItem().toString());
				}else if(tipoRep.equals("Anual")){
					ControladorReportes.getInstance().reporteVentasAnualesPorMarca(comboBoxMarca.getSelectedItem().toString());
				}else if (tipoRep.equals("Personalizado")){
					//ControladorReportes.getInstance().reporteVentasAnualesPorMarca(comboBoxMarca.getSelectedItem().toString());
				}
			}
		});
		setVisible(true);
	}
	public void validarComboBox() {
		if (comboBoxMarca.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(getContentPane(), "No se encontraron marcas existentes","Marcas inexistentes", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (ReportePorMarca.class.getResource("/Images/nok.png")));
			dispose();
			}
	}
}

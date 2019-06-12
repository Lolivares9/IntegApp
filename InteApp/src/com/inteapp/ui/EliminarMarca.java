package com.inteapp.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControladorMarcas;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class EliminarMarca extends javax.swing.JFrame{
	private static final long serialVersionUID = 7337044116767570123L;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JLabel lblNombre;
	private JComboBox<String> comboBoxMarca;

	public EliminarMarca() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EliminarMarca.class.getResource("/Images/IconoVentana.png")));
		//PROPIEDADES DE LA VENTANA
		setTitle("Eliminar Marca");
		setResizable(false);
		this.setSize(381, 167);
		getContentPane().setLayout(null);
		//INICIALIZACION DE LAS VARIABLES
		//LABELS
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 27, 60, 14);		
		//COMBOBOX
		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.setBounds(84, 23, 251, 22);
		//PANEL
		//BUTTON
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(EliminarMarca.class.getResource("/Images/Eliminar.png")));
		btnEliminar.setBounds(39, 71, 134, 49);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(EliminarMarca.class.getResource("/Images/Cancel.png")));
		btnCancelar.setBounds(201, 71, 134, 49);
		//ACTION BUTTON ELIMINAR
		btnEliminar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				btnEliminar.doClick();
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMarca.getSelectedIndex() != -1){
					ControladorMarcas.getInstance().EliminarMarca(comboBoxMarca.getSelectedItem().toString());
					dispose();	
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "No se encontraron marcas existentes","Marcas inexistentes", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (EliminarMarca.class.getResource("/Images/information.png")));
					dispose();
				}
			}
		});
		//ACTION BUTTON CANCELAR
		btnCancelar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				btnCancelar.doClick();
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//AGREGO COMPONENTES EN LA VENTANA
		getContentPane().add(comboBoxMarca);
		getContentPane().add(btnEliminar);
		getContentPane().add(btnCancelar);
		getContentPane().add(lblNombre);
		//CARGO EL COMBOBOX MARCA CON LAS MARCAS EXISTENTES
		ControladorMarcas.getInstance().cargarComboBoxMarca(comboBoxMarca);
	}
	/**METODO UTILIZADO POR LA VENTANA CREADO DE DICHA VENTANA, CONSULTANDO SI EL COMBOBOX DE MARCAS SE ENCUENTRA VACIO**/
	public void validarComboBox() {
		if (comboBoxMarca.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(getContentPane(), "No se encontraron marcas existentes","Marcas inexistentes", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (EliminarMarca.class.getResource("/Images/nok.png")));
			dispose();
		}
	}
}

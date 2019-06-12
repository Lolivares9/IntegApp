package com.inteapp.ui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControladorMarcas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class NuevaMarca extends javax.swing.JFrame{
	private static final long serialVersionUID = 7337044116767570123L;
	private JTextField txtNombre;
	private JButton btnCrear;
	private JButton btnCancelar;
	private JLabel lblNombre;
	public NuevaMarca() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevaMarca.class.getResource("/Images/IconoVentana.png")));
		setTitle("Nueva Marca");
		setResizable(false);
		this.setSize(381, 167);
		getContentPane().setLayout(null);
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCrear.doClick();
					}
			}
		});
		txtNombre.setBounds(88, 24, 251, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.setIcon(new ImageIcon(NuevaMarca.class.getResource("/Images/MarcaNueva.png")));
		btnCrear.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				btnCrear.doClick();
			}
		});
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNombre.getText().equals("")){
					ControladorMarcas.getInstance().crearMarca(txtNombre.getText().toUpperCase());
					dispose();	
				}
				else{
					JOptionPane.showMessageDialog(getContentPane(), "Debe completar el campo Nombre para registrar una marca en el sistema.","Campo vacio", JOptionPane.INFORMATION_MESSAGE,new ImageIcon (NuevaMarca.class.getResource("/Images/information.png")));
					txtNombre.requestFocus();
				}
			}
		});
		btnCrear.setBounds(39, 71, 134, 49);
		getContentPane().add(btnCrear);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(NuevaMarca.class.getResource("/Images/Cancel.png")));
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
		btnCancelar.setBounds(201, 71, 134, 49);
		getContentPane().add(btnCancelar);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 27, 60, 14);
		getContentPane().add(lblNombre);
		

	}
}

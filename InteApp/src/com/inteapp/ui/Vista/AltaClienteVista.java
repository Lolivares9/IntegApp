package com.inteapp.ui.Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.inteapp.controller.Liquidador;
import com.inteapp.view.ClienteView;

public class AltaClienteVista {


	private JTextField CUIT;
	private JTextField razonSocial;
	private JTextField direccion;
	private JTextField localidad;
	private JPanel alta;
	private JTextField textField;
	JComboBox comboBox;
	private JTextField email;
	private JTextField telefono;
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public AltaClienteVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 441);
		alta.setLayout(null);
		
		JLabel lblCodigo = new JLabel("CUIT:");
		lblCodigo.setBounds(24, 58, 158, 14);
		alta.add(lblCodigo);
		
		CUIT = new JTextField();
		CUIT.setColumns(10);
		CUIT.setBounds(202, 58, 129, 20);
		alta.add(CUIT);
		
		JLabel lblNombre = new JLabel("Razon Social");
		lblNombre.setBounds(24, 90, 158, 14);
		alta.add(lblNombre);
		
		razonSocial = new JTextField();
		razonSocial.setColumns(10);
		razonSocial.setBounds(202, 90, 129, 20);
		alta.add(razonSocial);
		
		JLabel lblPrecio = new JLabel("Direccion:");
		lblPrecio.setBounds(24, 125, 158, 14);
		alta.add(lblPrecio);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(202, 125, 129, 20);
		alta.add(direccion);
		
		JLabel lblPeriodoVigencia = new JLabel("Localidad:");
		lblPeriodoVigencia.setBounds(24, 156, 158, 14);
		alta.add(lblPeriodoVigencia);
		
		localidad = new JTextField();
		localidad.setColumns(10);
		localidad.setBounds(202, 156, 129, 20);
		alta.add(localidad);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PersonaTipo tipo = (PersonaTipo)comboBox.getSelectedItem();
//					ab.AltaCliente(codigo.getText(), nombre.getText(), precio.getText(), vigencia.getText(), tipo);
//					codigo.setText(null);
//					nombre.setText(null);
//					precio.setText(null);
//					vigencia.setText(null);
				ClienteView c = new ClienteView(razonSocial.getText(), CUIT.getText(), direccion.getText(), localidad.getText(), email.getText(), telefono.getText(), tipo.toString(), null);
				Liquidador.getInstance().altaCliente(c);
			}
		});
		button.setBounds(197, 391, 91, 23);
		alta.add(button);
		
		JLabel lblAltaDeUsuarios = new JLabel("ALTA DE CLIENTES");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(120, 13, 198, 16);
		alta.add(lblAltaDeUsuarios);
		
		JLabel lblTipo = new JLabel("Tipo de Persona:");
		lblTipo.setBounds(24, 212, 158, 14);
		alta.add(lblTipo);
		
		comboBox = new JComboBox(PersonaTipo.values());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox.setBounds(198, 212, 133, 20);
		alta.add(comboBox);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(24, 184, 158, 14);
		alta.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(202, 184, 129, 20);
		alta.add(email);
		
		JLabel lblNewLabel = new JLabel("Telefono:");
		lblNewLabel.setBounds(24, 237, 46, 14);
		alta.add(lblNewLabel);
		
		telefono = new JTextField();
		telefono.setBounds(202, 234, 129, 20);
		alta.add(telefono);
		telefono.setColumns(10);
		
		
		
		
	}
}

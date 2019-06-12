package com.inteapp.ui.Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.inteapp.businessObject.Liquidacion;
import com.inteapp.controller.Liquidador;
import com.inteapp.view.ClienteView;

import com.inteapp.dao.ClienteDAO;
import java.awt.Font;
import javax.swing.JComboBox;

public class LiquidarSueldos {

	private JPanel alta;
	private JComboBox BoxTipo;
	
	
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public LiquidarSueldos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	  @wbp.parser.entryPoint
	 **/
	private void initialize() {
	
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 261);
		alta.setLayout(null);
		
		JLabel lblClientes = new JLabel("CLIENTES:");
		lblClientes.setBounds(24, 58, 70, 14);
		alta.add(lblClientes);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton btnLiquidar = new JButton("LIQUIDAR");
		btnLiquidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					ClienteView cliente = (ClienteView)comboBox.getSelectedItem();
					Liquidador.getInstance().liquidarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Liquidacion exitosa","Informacion",JOptionPane.OK_OPTION);
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "No se pudo Liquidar el Cliente","Informacion",JOptionPane.OK_OPTION);
				}
				
				
				
				//ClienteView c = new ClienteView(razonSocial.getText(), CUIT.getText(), direccion.getText(), localidad.getText(), email.getText(), telefono.getText(), tipo.toString(), null);
				Liquidador.getInstance().liquidarCliente(c);
			}
		});
		btnLiquidar.setBounds(120, 117, 91, 23);
		alta.add(btnLiquidar);
		
		JLabel lblAltaDeUsuarios = new JLabel("LIQUIDAR SUELDOS");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(120, 13, 198, 16);
		alta.add(lblAltaDeUsuarios);
		
		BoxTipo = new JComboBox<ClienteView>(Liquidador.getInstance().CargarClientes());
		BoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		
		BoxTipo.setBounds(106, 54, 63, 22);
		alta.add(BoxTipo);
		
		comboBox = new JComboBox<ClienteView>(abn.getClientes());
	
		
		
		
	}
}

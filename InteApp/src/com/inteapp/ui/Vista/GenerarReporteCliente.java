package com.inteapp.ui.Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class GenerarReporteCliente {
	
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
	public GenerarReporteCliente() {
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
		
		JButton btnLiquidar = new JButton("GENERAR");
		btnLiquidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		btnLiquidar.setBounds(120, 117, 91, 23);
		alta.add(btnLiquidar);
		
		JLabel lblAltaDeUsuarios = new JLabel("GENERAR REPORTE POR CLIENTE");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(24, 13, 354, 16);
		alta.add(lblAltaDeUsuarios);
		
		BoxTipo = new JComboBox();
		BoxTipo.setBounds(106, 54, 63, 22);
		alta.add(BoxTipo);
		
		
		
		
	}
}

package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Controlador.SocioController;
import Modelo.Socio;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;

public class BajaSocioVista {
	private SocioController s = SocioController.getSingletonInstance();
	private JPanel baja;
	private JTextField dni;
	
	
	/**
	 * Launch the application.
	 */

	public JPanel getBaja() {
		return baja;
	}

	/**
	 * Create the application.
	 */
	public BajaSocioVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		baja = new JPanel();
		baja.setBounds(0, 0, 431, 137);
		baja.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(64, 68, 46, 14);
		baja.add(lblDni);
		
		dni = new JTextField();
		//String text = dni.getText();
		//int result = Integer.parseInt(text);
		dni.setBounds(120, 65, 143, 20);
		baja.add(dni);
		dni.setColumns(10);
		
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.BajaSocio(dni.getText());		
			}
		});
		button.setBounds(172, 96, 91, 23);
		baja.add(button);
		
	
		
		JLabel lblAltaDeUsuarios = new JLabel("BAJA DE USUARIOS");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(120, 13, 198, 16);
		baja.add(lblAltaDeUsuarios);
	}
}

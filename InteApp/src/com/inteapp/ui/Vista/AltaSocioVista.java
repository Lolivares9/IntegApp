package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.SocioController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AltaSocioVista {


	private JTextField nombre;
	private JTextField apellido;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField mail;
	private JTextField dni;
	private SocioController s = SocioController.getSingletonInstance();
	private JPanel alta;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public AltaSocioVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 261);
		alta.setLayout(null);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(24, 58, 70, 14);
		alta.add(label);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(97, 55, 86, 20);
		alta.add(nombre);
		
		JLabel label_1 = new JLabel("Apellido:");
		label_1.setBounds(24, 90, 70, 14);
		alta.add(label_1);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(97, 87, 86, 20);
		alta.add(apellido);
		
		JLabel label_2 = new JLabel("Domicilio:");
		label_2.setBounds(24, 125, 70, 14);
		alta.add(label_2);
		
		domicilio = new JTextField();
		domicilio.setColumns(10);
		domicilio.setBounds(97, 122, 86, 20);
		alta.add(domicilio);
		
		JLabel label_3 = new JLabel("Telefono:");
		label_3.setBounds(227, 58, 70, 14);
		alta.add(label_3);
		
		JLabel label_4 = new JLabel("Mail:");
		label_4.setBounds(227, 90, 70, 14);
		alta.add(label_4);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(296, 55, 86, 20);
		alta.add(telefono);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(296, 87, 86, 20);
		alta.add(mail);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(227, 125, 46, 14);
		alta.add(lblDni);
		
		dni = new JTextField();
		dni.setBounds(296, 122, 86, 20);
		alta.add(dni);
		dni.setColumns(10);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					s.AltaSocio(nombre.getText(), apellido.getText(), domicilio.getText(), telefono.getText(), mail.getText(), dni.getText());
					nombre.setText(null);
					apellido.setText(null);
					domicilio.setText(null);
					telefono.setText(null);
					mail.setText(null);
					dni.setText(null);
			}
		});
		button.setBounds(180, 187, 91, 23);
		alta.add(button);
		
		JLabel lblAltaDeUsuarios = new JLabel("ALTA DE USUARIOS");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(120, 13, 198, 16);
		alta.add(lblAltaDeUsuarios);
		
		
		
		
	}
}

package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Controlador.ClienteController;
import Controlador.SocioController;
import Modelo.Socio;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;

public class BajaClienteVista {
	private ClienteController ab = ClienteController.getSingletonInstance();
	private JPanel baja;
	private JTextField codigo;
	
	
	/**
	 * Launch the application.
	 */

	public JPanel getBaja() {
		return baja;
	}

	/**
	 * Create the application.
	 */
	public BajaClienteVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		baja = new JPanel();
		baja.setBounds(0, 0, 431, 137);
		baja.setLayout(null);
		
		JLabel lblCodigo = new JLabel("CUIT:");
		lblCodigo.setBounds(64, 68, 46, 14);
		baja.add(lblCodigo);
		
		codigo = new JTextField();
		//String text = dni.getText();
		//int result = Integer.parseInt(text);
		codigo.setBounds(120, 65, 143, 20);
		baja.add(codigo);
		codigo.setColumns(10);
		
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ab.BajaCliente(codigo.getText());		
			}
		});
		button.setBounds(172, 96, 91, 23);
		baja.add(button);
		
	
		
		JLabel lblAltaDeClientes = new JLabel("BAJA DE CLIENTES");
		lblAltaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeClientes.setBounds(120, 13, 198, 16);
		baja.add(lblAltaDeClientes);
	}
}

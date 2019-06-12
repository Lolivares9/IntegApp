package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Controlador.AbonoController;
import Controlador.SocioController;
import Modelo.Socio;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;

public class BajaAbonoVista {
	private AbonoController ab = AbonoController.getSingletonInstance();
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
	public BajaAbonoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		baja = new JPanel();
		baja.setBounds(0, 0, 431, 137);
		baja.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
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
				ab.BajaAbono(codigo.getText());		
			}
		});
		button.setBounds(172, 96, 91, 23);
		baja.add(button);
		
	
		
		JLabel lblAltaDeAbonos = new JLabel("BAJA DE ABONOS");
		lblAltaDeAbonos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeAbonos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeAbonos.setBounds(120, 13, 198, 16);
		baja.add(lblAltaDeAbonos);
	}
}

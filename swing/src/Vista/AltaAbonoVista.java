package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.AbonoController;
import Controlador.SocioController;
import Modelo.Abono;
import Modelo.AbonoTipo;
import Modelo.Socio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class AltaAbonoVista {


	private JTextField codigo;
	private JTextField nombre;
	private JTextField precio;
	private JTextField vigencia;
	private AbonoController ab = AbonoController.getSingletonInstance();
	private JPanel alta;
	private JTextField textField;
	JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public AltaAbonoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ab = AbonoController.getSingletonInstance();
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 245);
		alta.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(24, 58, 70, 14);
		alta.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(97, 55, 86, 20);
		alta.add(codigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(24, 90, 70, 14);
		alta.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(97, 87, 86, 20);
		alta.add(nombre);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(24, 125, 53, 14);
		alta.add(lblPrecio);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(97, 122, 86, 20);
		alta.add(precio);
		
		JLabel lblPeriodoVigencia = new JLabel("Periodo Vigencia:");
		lblPeriodoVigencia.setBounds(24, 156, 133, 14);
		alta.add(lblPeriodoVigencia);
		
		vigencia = new JTextField();
		vigencia.setColumns(10);
		vigencia.setBounds(24, 179, 159, 20);
		alta.add(vigencia);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AbonoTipo tipo = (AbonoTipo)comboBox.getSelectedItem();
					ab.AltaAbono(codigo.getText(), nombre.getText(), precio.getText(), vigencia.getText(), tipo);
					codigo.setText(null);
					nombre.setText(null);
					precio.setText(null);
					vigencia.setText(null);
					
			}
		});
		button.setBounds(180, 209, 91, 23);
		alta.add(button);
		
		JLabel lblAltaDeUsuarios = new JLabel("ALTA DE ABONOS");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(120, 13, 198, 16);
		alta.add(lblAltaDeUsuarios);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(218, 58, 31, 14);
		alta.add(lblTipo);
		
		comboBox = new JComboBox(AbonoTipo.values());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox.setBounds(259, 55, 133, 20);
		alta.add(comboBox);
		
		JLabel label = new JLabel("$");
		label.setBounds(84, 125, 12, 14);
		alta.add(label);
		
		
		
		
	}
}

package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.ClienteController;
import Modelo.ClienteTipo;

public class AltaClienteVista {


	private JTextField codigo;
	private JTextField nombre;
	private JTextField precio;
	private JTextField vigencia;
	private ClienteController ab = ClienteController.getSingletonInstance();
	private JPanel alta;
	private JTextField textField;
	JComboBox comboBox;
	private JTextField textField_1;
	

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
		ab = ClienteController.getSingletonInstance();
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 441);
		alta.setLayout(null);
		
		JLabel lblCodigo = new JLabel("CUIT:");
		lblCodigo.setBounds(24, 58, 158, 14);
		alta.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(202, 58, 129, 20);
		alta.add(codigo);
		
		JLabel lblNombre = new JLabel("Razon Social");
		lblNombre.setBounds(24, 90, 158, 14);
		alta.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(202, 90, 129, 20);
		alta.add(nombre);
		
		JLabel lblPrecio = new JLabel("Direccion:");
		lblPrecio.setBounds(24, 125, 158, 14);
		alta.add(lblPrecio);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(202, 125, 129, 20);
		alta.add(precio);
		
		JLabel lblPeriodoVigencia = new JLabel("Localidad:");
		lblPeriodoVigencia.setBounds(24, 156, 158, 14);
		alta.add(lblPeriodoVigencia);
		
		vigencia = new JTextField();
		vigencia.setColumns(10);
		vigencia.setBounds(202, 156, 129, 20);
		alta.add(vigencia);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ClienteTipo tipo = (ClienteTipo)comboBox.getSelectedItem();
					ab.AltaCliente(codigo.getText(), nombre.getText(), precio.getText(), vigencia.getText(), tipo);
					codigo.setText(null);
					nombre.setText(null);
					precio.setText(null);
					vigencia.setText(null);
					
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
		
		comboBox = new JComboBox(ClienteTipo.values());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox.setBounds(198, 212, 133, 20);
		alta.add(comboBox);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(24, 184, 158, 14);
		alta.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(202, 184, 129, 20);
		alta.add(textField_1);
		
		
		
		
	}
}

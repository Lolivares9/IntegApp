package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.ClienteController;
import Modelo.ClienteTipo;
import javax.swing.JButton;

public class ModificarClienteVista {

	private JTextField codigo;
	private JTextField nombre;
	private JTextField precio;
	private JTextField vigencia;
	private ClienteController ab = ClienteController.getSingletonInstance();
	private JPanel modificacion;
	private JButton btnNewButton_1;

	JComboBox comboBox;
	private JButton btnBuscar;
	private JLabel lblLocalidad;
	private JTextField textField;

	public JPanel getModif() {
		return modificacion;
	}

	/**
	 * Create the application.
	 */

	public ModificarClienteVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modificacion = new JPanel();
		modificacion.setBounds(100, 100, 450, 300);

		ab = ClienteController.getSingletonInstance();
		modificacion.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(117, 30, 44, 16);
		modificacion.add(lblCodigo);

		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(166, 27, 116, 22);
		modificacion.add(codigo);

		JLabel lblNombre = new JLabel("Razon Social:");
		lblNombre.setBounds(7, 75, 100, 16);
		modificacion.add(lblNombre);
		lblNombre.setVisible(false);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(117, 72, 142, 22);
		modificacion.add(nombre);
		nombre.setVisible(false);

		JLabel lblPrecio = new JLabel("Email:");
		lblPrecio.setBounds(7, 160, 40, 16);
		modificacion.add(lblPrecio);
		lblPrecio.setVisible(false);

		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(117, 157, 142, 22);
		modificacion.add(precio);
		precio.setVisible(false);

		JLabel lblPeriodoVigencia = new JLabel("Direccion:");
		lblPeriodoVigencia.setBounds(7, 102, 100, 16);
		modificacion.add(lblPeriodoVigencia);
		lblPeriodoVigencia.setVisible(false);

		vigencia = new JTextField();
		vigencia.setColumns(10);
		vigencia.setBounds(117, 105, 142, 22);
		modificacion.add(vigencia);
		vigencia.setVisible(false);

		JLabel lblTipo = new JLabel("Tipo de Persona:");
		lblTipo.setBounds(7, 190, 97, 14);
		modificacion.add(lblTipo);
		lblTipo.setVisible(false);

		comboBox = new JComboBox(ClienteTipo.values());
		comboBox.setBounds(117, 186, 142, 22);
		modificacion.add(comboBox);
		comboBox.setVisible(false);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(189, 226, 97, 25);
		modificacion.add(btnBuscar);
		
		lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(7, 135, 83, 14);
		modificacion.add(lblLocalidad);
		lblLocalidad.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(117, 132, 142, 20);
		textField.setVisible(false);
		modificacion.add(textField);
		textField.setColumns(10);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Esconder el boton de buscar para hacer visible el de grabar

				btnBuscar.setVisible(false);

				btnNewButton_1 = new JButton("GRABAR");
				btnNewButton_1.setBounds(185, 247, 97, 25);
				modificacion.add(btnNewButton_1);

				// hacer visibles los Jtext que estaban invisibles antes
				precio.setVisible(true);
				nombre.setVisible(true);
				vigencia.setVisible(true);
				comboBox.setVisible(true);

				// hacer visibles los Jlabel que estaban invisibles antes
				lblNombre.setVisible(true);
				lblPrecio.setVisible(true);
				lblPeriodoVigencia.setVisible(true);
				lblTipo.setVisible(true);
				lblLocalidad.setVisible(true);
				// poblar los campos con la info correspondiente al DNI
				codigo.setText(ab.modificarCliente(codigo.getText()).getCodigo());
				nombre.setText(ab.modificarCliente(codigo.getText()).getNombre());
				precio.setText(ab.modificarCliente(codigo.getText()).getPrecio());
				vigencia.setText(ab.modificarCliente(codigo.getText()).getVigencia());
				//VER COMO MOSTRAR comboBox.(ClienteTipo)(ab.modificarCliente(codigo.getText()).getTipo();
			
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ab.modificarCliente(codigo.getText(), nombre.getText(), vigencia.getText(), precio.getText());
						nombre.setText(null);
						codigo.setText(null);
						vigencia.setText(null);
						precio.setText(null);
					}
				});
			
			
			
			
			
			}
		});
	}
}

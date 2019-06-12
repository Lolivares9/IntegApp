package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.AbonoController;
import Modelo.AbonoTipo;
import javax.swing.JButton;

public class ModificarAbonoVista {

	private JTextField codigo;
	private JTextField nombre;
	private JTextField precio;
	private JTextField vigencia;
	private AbonoController ab = AbonoController.getSingletonInstance();
	private JPanel modificacion;
	private JButton btnNewButton_1;

	JComboBox comboBox;
	private JButton btnBuscar;

	public JPanel getModif() {
		return modificacion;
	}

	/**
	 * Create the application.
	 */

	public ModificarAbonoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modificacion = new JPanel();
		modificacion.setBounds(100, 100, 450, 300);

		ab = AbonoController.getSingletonInstance();
		modificacion.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(117, 30, 44, 16);
		modificacion.add(lblCodigo);

		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(166, 27, 116, 22);
		modificacion.add(codigo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 89, 45, 16);
		modificacion.add(lblNombre);
		lblNombre.setVisible(false);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(62, 86, 116, 22);
		modificacion.add(nombre);
		nombre.setVisible(false);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(260, 140, 40, 16);
		modificacion.add(lblPrecio);
		lblPrecio.setVisible(false);

		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(312, 137, 116, 22);
		modificacion.add(precio);
		precio.setVisible(false);

		JLabel lblPeriodoVigencia = new JLabel("Periodo Vigencia:");
		lblPeriodoVigencia.setBounds(12, 137, 100, 16);
		modificacion.add(lblPeriodoVigencia);
		lblPeriodoVigencia.setVisible(false);

		vigencia = new JTextField();
		vigencia.setColumns(10);
		vigencia.setBounds(117, 134, 116, 22);
		modificacion.add(vigencia);
		vigencia.setVisible(false);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(260, 90, 31, 14);
		modificacion.add(lblTipo);
		lblTipo.setVisible(false);

		comboBox = new JComboBox(AbonoTipo.values());
		comboBox.setBounds(312, 86, 93, 22);
		modificacion.add(comboBox);
		comboBox.setVisible(false);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(189, 226, 97, 25);
		modificacion.add(btnBuscar);
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
				
				// poblar los campos con la info correspondiente al DNI
				codigo.setText(ab.modificarAbono(codigo.getText()).getCodigo());
				nombre.setText(ab.modificarAbono(codigo.getText()).getNombre());
				precio.setText(ab.modificarAbono(codigo.getText()).getPrecio());
				vigencia.setText(ab.modificarAbono(codigo.getText()).getVigencia());
				//VER COMO MOSTRAR comboBox.(AbonoTipo)(ab.modificarAbono(codigo.getText()).getTipo();
			
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ab.modificarAbono(codigo.getText(), nombre.getText(), vigencia.getText(), precio.getText());
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

package Vista;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.SocioController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarSocioVista {

	private JPanel modificacion;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField mail;
	private JTextField dni;
	private SocioController s = SocioController.getSingletonInstance();
	private JButton btnNewButton_1;
	

	/**
	 * Create the application.
	 */
	public ModificarSocioVista() {
		initialize();
	}

	public JPanel getModificacion() {
		return modificacion;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modificacion = new JPanel();
		modificacion.setBounds(100, 100, 450, 300);
		modificacion.setLayout(null);

		JLabel label = new JLabel("Nombre:");
		label.setBounds(36, 97, 50, 16);
		modificacion.add(label);
		label.setVisible(false);

		nombre = new JTextField();
		nombre.setBounds(91, 94, 116, 22);
		nombre.setColumns(10);
		modificacion.add(nombre);
		nombre.setVisible(false);

		JLabel label_1 = new JLabel("Apellido:");
		label_1.setBounds(252, 94, 50, 16);
		modificacion.add(label_1);
		label_1.setVisible(false);

		apellido = new JTextField();
		apellido.setBounds(307, 91, 116, 22);
		apellido.setColumns(10);
		modificacion.add(apellido);
		apellido.setVisible(false);

		JLabel label_2 = new JLabel("Domicilio:");
		label_2.setBounds(36, 149, 56, 16);
		modificacion.add(label_2);
		label_2.setVisible(false);

		domicilio = new JTextField();
		domicilio.setBounds(91, 146, 116, 22);
		domicilio.setColumns(10);
		modificacion.add(domicilio);
		domicilio.setVisible(false);

		JLabel label_3 = new JLabel("Telefono:");
		label_3.setBounds(241, 148, 55, 16);
		modificacion.add(label_3);
		label_3.setVisible(false);

		JLabel label_4 = new JLabel("Mail:");
		label_4.setBounds(46, 197, 28, 16);
		modificacion.add(label_4);
		label_4.setVisible(false);

		telefono = new JTextField();
		telefono.setBounds(307, 145, 116, 22);
		telefono.setColumns(10);
		modificacion.add(telefono);
		telefono.setVisible(false);

		mail = new JTextField();
		mail.setBounds(89, 194, 116, 22);
		mail.setColumns(10);
		modificacion.add(mail);
		mail.setVisible(false);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(144, 40, 25, 16);
		modificacion.add(lblDni);

		dni = new JTextField();
		dni.setBounds(174, 37, 116, 22);
		modificacion.add(dni);
		dni.setColumns(10);

		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(185, 247, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Esconder el boton de buscar para hacer visible el de grabar

				btnNewButton.setVisible(false);

				btnNewButton_1 = new JButton("GRABAR");
				btnNewButton_1.setBounds(185, 247, 97, 25);
				modificacion.add(btnNewButton_1);

				// hacer visibles los Jtext que estaban invisibles antes
				apellido.setVisible(true);
				nombre.setVisible(true);
				telefono.setVisible(true);
				mail.setVisible(true);
				dni.setVisible(true);
				domicilio.setVisible(true);

				// hacer visibles los Jlabel que estaban invisibles antes
				label.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);

				// poblar los campos con la info correspondiente al DNI
				apellido.setText(s.modificarSocio(dni.getText()).getApellido());
				nombre.setText(s.modificarSocio(dni.getText()).getNombre());
				telefono.setText(s.modificarSocio(dni.getText()).getTelefono());
				mail.setText(s.modificarSocio(dni.getText()).getMail());
				dni.setText(s.modificarSocio(dni.getText()).getDni());
				dni.setText(s.modificarSocio(dni.getText()).getDni());
				domicilio.setText(s.modificarSocio(dni.getText()).getDomicilio());

				
				//obtener los nuevos datos modificados y grabarlos en el cliente.
				
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						s.modificarSocio(nombre.getText(), apellido.getText(), domicilio.getText(), telefono.getText(),
								mail.getText(), dni.getText());
						nombre.setText(null);
						apellido.setText(null);
						domicilio.setText(null);
						telefono.setText(null);
						mail.setText(null);
						dni.setText(null);
					}
				});
			}
		});
		modificacion.add(btnNewButton);

	}
}

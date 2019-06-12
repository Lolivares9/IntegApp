package Vista;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ModificarEmpleado {

	private JPanel modificacion;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField vacaciones;
	private JTextField telefono;
	private JTextField mail;
	private JTextField cuil;
	private JComboBox BoxTipo;

	private JButton btnNewButton_1;
	private JTextField txtDireccion;
	private JTextField txtConvenio;
	private JTextField txtCategoria;
	private JTextField txtSalario;
	private JTextField txtDiasEstudio;
	

	/**
	 * Create the application.
	 */
	public ModificarEmpleado() {
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
		modificacion.setBounds(100, 100, 550, 402);
		modificacion.setLayout(null);
		
		JLabel lblCuil = new JLabel("CUIL:");
		lblCuil.setBounds(36, 40, 37, 16);
		modificacion.add(lblCuil);
		

		cuil = new JTextField();
		cuil.setBounds(105, 37, 116, 22);
		modificacion.add(cuil);
		cuil.setColumns(10);

		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(35, 79, 58, 16);
		modificacion.add(lblNombre);
		lblNombre.setVisible(false);

		nombre = new JTextField();
		nombre.setBounds(105, 76, 116, 22);
		nombre.setColumns(10);
		modificacion.add(nombre);
		nombre.setVisible(false);

		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(35, 127, 74, 16);
		modificacion.add(lblApellido);
		lblApellido.setVisible(false);

		apellido = new JTextField();
		apellido.setBounds(105, 124, 116, 22);
		apellido.setColumns(10);
		modificacion.add(apellido);
		apellido.setVisible(false);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setBounds(35, 178, 74, 16);
		modificacion.add(lblDireccion);
		lblDireccion.setVisible(false);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(121, 178, 116, 22);
		modificacion.add(txtDireccion);
		txtDireccion.setVisible(false);
		txtDireccion.setColumns(10);
		
		JLabel lblMail = new JLabel("MAIL:");
		lblMail.setBounds(35, 218, 48, 16);
		modificacion.add(lblMail);
		lblMail.setVisible(false);
		
		mail = new JTextField();
		mail.setBounds(105, 215, 116, 22);
		mail.setColumns(10);
		modificacion.add(mail);
		mail.setVisible(false);
		
		JLabel lblVacaciones = new JLabel("VACACIONES:");
		lblVacaciones.setBounds(35, 254, 88, 16);
		modificacion.add(lblVacaciones);
		lblVacaciones.setVisible(false);

		vacaciones = new JTextField();
		vacaciones.setBounds(156, 251, 116, 22);
		vacaciones.setColumns(10);
		modificacion.add(vacaciones);
		vacaciones.setVisible(false);

		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(273, 40, 81, 16);
		modificacion.add(lblTelefono);
		lblTelefono.setVisible(false);

		telefono = new JTextField();
		telefono.setBounds(366, 37, 116, 22);
		telefono.setColumns(10);
		modificacion.add(telefono);
		telefono.setVisible(false);

		JLabel lblTipoLiquidacion = new JLabel("TIPO LIQUIDACION");
		lblTipoLiquidacion.setBounds(273, 79, 137, 16);
		modificacion.add(lblTipoLiquidacion);
		lblTipoLiquidacion.setVisible(false);
		
		BoxTipo = new JComboBox();
		BoxTipo.setBounds(403, 76, 79, 22);
		modificacion.add(BoxTipo);
		BoxTipo.addItem("rojo");
		BoxTipo.addItem("vede");
		BoxTipo.setVisible(false);
		
		JLabel lblConvenioo = new JLabel("CONVENIO");
		lblConvenioo.setBounds(273, 127, 74, 16);
		modificacion.add(lblConvenioo);
		lblConvenioo.setVisible(false);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(366, 124, 116, 22);
		modificacion.add(txtConvenio);
		txtConvenio.setColumns(10);
		txtConvenio.setVisible(false);
		
		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setBounds(273, 178, 81, 16);
		modificacion.add(lblCategoria);
		lblCategoria.setVisible(false);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(366, 175, 116, 22);
		modificacion.add(txtCategoria);
		txtCategoria.setColumns(10);
		txtCategoria.setVisible(false);
		
		JLabel lblSalario = new JLabel("SALARIO");
		lblSalario.setBounds(273, 218, 56, 16);
		modificacion.add(lblSalario);
		lblSalario.setVisible(false);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(366, 215, 116, 22);
		modificacion.add(txtSalario);
		txtSalario.setColumns(10);
		txtSalario.setVisible(false);
		
		JLabel lblDiasEstudio = new JLabel("DIAS ESTUDIO");
		lblDiasEstudio.setBounds(298, 254, 91, 16);
		modificacion.add(lblDiasEstudio);
		lblDiasEstudio.setVisible(false);
		
		txtDiasEstudio = new JTextField();
		txtDiasEstudio.setBounds(403, 251, 116, 22);
		modificacion.add(txtDiasEstudio);
		txtDiasEstudio.setColumns(10);
		txtDiasEstudio.setVisible(false);

		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBounds(292, 335, 97, 25);
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
				cuil.setVisible(true);
				vacaciones.setVisible(true);
				txtDireccion.setVisible(true);
				txtCategoria.setVisible(true);
				txtSalario.setVisible(true);
				txtDiasEstudio.setVisible(true);
				txtConvenio.setVisible(true);
				
				// hacer visibles los Jlabel que estaban invisibles antes
				lblNombre.setVisible(true);
				lblApellido.setVisible(true);
				lblVacaciones.setVisible(true);
				lblTelefono.setVisible(true);
				lblMail.setVisible(true);
				lblCategoria.setVisible(true);
				lblSalario.setVisible(true);
				lblDiasEstudio.setVisible(true);
				lblConvenioo.setVisible(true);
				lblDireccion.setVisible(true);
				btnNewButton_1.setBounds(185, 347, 97, 25);
				
				// poblar los campos con la info correspondiente al DNI
				apellido.setText(s.modificarSocio(cuil.getText()).getApellido());
				nombre.setText(s.modificarSocio(cuil.getText()).getNombre());
				telefono.setText(s.modificarSocio(cuil.getText()).getTelefono());
				mail.setText(s.modificarSocio(cuil.getText()).getMail());
				cuil.setText(s.modificarSocio(cuil.getText()).getDni());
				cuil.setText(s.modificarSocio(cuil.getText()).getDni());
				vacaciones.setText(s.modificarSocio(cuil.getText()).getDomicilio());

				
				//obtener los nuevos datos modificados y grabarlos en el cliente.
				
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						s.modificarSocio(nombre.getText(), apellido.getText(), vacaciones.getText(), telefono.getText(),
								mail.getText(), cuil.getText());
						nombre.setText(null);
						apellido.setText(null);
						vacaciones.setText(null);
						telefono.setText(null);
						mail.setText(null);
						cuil.setText(null);
					}
				});
			}
		});
		modificacion.add(btnNewButton);
		
		
		
		
		
		
		
		
		
		
	
		
		

	}
}

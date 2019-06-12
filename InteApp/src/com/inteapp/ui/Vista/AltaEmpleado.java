package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class AltaEmpleado extends JFrame{

	private JPanel contentPane;
	
	private JButton btnAgregar;
	
	private JLabel lblMail;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JLabel lblCuil;
	private JLabel lblCategoria;
	private JLabel lblSalario;
	private JLabel lblVacaciones;
	private JLabel lblDiasDeEstudio;
	
	private JComboBox BoxTipo;
	
	private JTextField txtCuil;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtMail;
	private JTextField txtTelefono;
	private JTextField txtConvenio;
	private JTextField txtCategoria;
	private JTextField txtSalario;
	private JTextField txtVacaciones;
	private JTextField txtDiasEstudio;
	
	//private Liquidacion liq = Liquidacion.getInstance();
	
	public JPanel getAlta() {
		return contentPane;
	}

	/**
	 * Create the application.
	 */

	public AltaEmpleado() {
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 611, 449);
		
		setTitle("alta Empleado");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCuil = new JLabel("CUIL:");
		lblCuil.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(lblCuil);
		
		lblApellido = new JLabel("APELLIDO:");
		getContentPane().add(lblApellido);
		
		lblNombre = new JLabel("NOMBRE:");
		getContentPane().add(lblNombre);
		
		lblDireccion = new JLabel("DIRECCION:");
		getContentPane().add(lblDireccion);
		
		lblMail = new JLabel("MAIL:");
		getContentPane().add(lblMail);
		
		//seteo datos
		
		txtCuil = new JTextField();
		getContentPane().add(txtCuil);
		txtCuil.setColumns(10);
		
		txtNombre = new JTextField();
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDireccion = new JTextField();
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtMail = new JTextField();
		getContentPane().add(txtMail);
		txtMail.setColumns(10);
		
		btnAgregar = new JButton("AGREGAR");
		getContentPane().add(btnAgregar);
		
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		
		JLabel lblTipoLiquidacion = new JLabel("TIPO LIQUIDACION");
		
		JLabel lblConvenio = new JLabel("CONVENIO");
		
		txtConvenio = new JTextField();
		txtConvenio.setColumns(10);
		
		lblCategoria = new JLabel("CATEGORIA");
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		
		lblSalario = new JLabel("SALARIO");
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		
		lblVacaciones = new JLabel("VACACIONES");
		
		txtVacaciones = new JTextField();
		txtVacaciones.setColumns(10);
		
		lblDiasDeEstudio = new JLabel("DIAS DE ESTUDIO");
		
		txtDiasEstudio = new JTextField();
		txtDiasEstudio.setColumns(10);
		
		BoxTipo = new JComboBox();
		getContentPane().add(BoxTipo);
		BoxTipo.addItem("rojo");
		BoxTipo.addItem("vede");
		BoxTipo.setToolTipText("");
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCuil.getText().equals("")||txtNombre.getText().equals("")||txtApellido.getText().equals("")||txtDireccion.getText().equals("")||txtMail.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "por favor complete todos los campos","error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					/*liq.altaEmpleado(Integer.parseInt(txtCuil.getText()), txtNombre.getText(), txtApellido.getText(),txtDireccion.getText(),
							txtMail.getText(),txtTelefono.getText(),txtTipoLiquidacion.getText(),Integer.parseInt(txtVacaciones.getText()),Integer.parseInt(txtDiasEstudio.getText()));*/
					//Sistema.altaCliente(Integer.parseInt(txtCuil.getText()), txtNombre.getText(), txtApellido.getText(),txtDireccion.getText(),txtMail.getText());
					//Cliente cl= new Cliente(Integer.parseInt(txtDni.getText()), txtNombre.getText(), txtDomicilio.getText(),txtTelefono.getText(),txtMail.getText());
					//Menu.clientes.add(cl);
					JOptionPane.showMessageDialog(null, "El empleado fue dado de alta exitosamente");
					//cierra la ventana cuando toco aceptar
					setVisible(false);;
					
				}
				
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCuil)
								.addComponent(lblNombre)
								.addComponent(lblApellido))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCuil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDireccion)
								.addComponent(lblMail))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblVacaciones)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtVacaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSalario)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCategoria)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAgregar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoLiquidacion)
								.addComponent(lblConvenio)
								.addComponent(lblTelefono)
								.addComponent(lblDiasDeEstudio))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtDiasEstudio)
								.addComponent(txtTelefono)
								.addComponent(txtConvenio)
								.addComponent(txtCategoria)
								.addComponent(txtSalario)
								.addComponent(BoxTipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCuil)
						.addComponent(txtCuil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoLiquidacion)
						.addComponent(BoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(lblConvenio)
						.addComponent(txtConvenio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(lblCategoria)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMail)
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVacaciones)
								.addComponent(txtVacaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiasDeEstudio)
								.addComponent(txtDiasEstudio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(btnAgregar))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSalario)
							.addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}


}

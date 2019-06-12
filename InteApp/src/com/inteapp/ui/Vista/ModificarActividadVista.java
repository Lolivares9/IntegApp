package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.ClienteController;
import Controlador.ActividadController;
import Modelo.ClienteTipo;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class ModificarActividadVista {

	private JTextField codigo;
	private JTextField titulo;
	private JTextField descripcion;
	private ActividadController act = ActividadController.getSingletonInstance();
	private JPanel modificacion;
	private JButton btnNewButton_1;
	private JButton btnBuscar;
	private JTextPane horarios;

	public JPanel getModif() {
		return modificacion;
	}

	/**
	 * Create the application.
	 */

	public ModificarActividadVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		modificacion = new JPanel();
		modificacion.setBounds(100, 100, 450, 300);

		act = ActividadController.getSingletonInstance();
		modificacion.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(117, 30, 44, 16);
		modificacion.add(lblCodigo);

		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(166, 27, 116, 22);
		modificacion.add(codigo);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(12, 89, 45, 16);
		modificacion.add(lblTitulo);
		lblTitulo.setVisible(false);
		titulo = new JTextField();
		titulo.setColumns(10);
		titulo.setBounds(76, 86, 116, 22);
		modificacion.add(titulo);
		titulo.setVisible(false);

		JLabel lblHorarios = new JLabel("Horarios:");
		lblHorarios.setBounds(202, 89, 61, 16);
		modificacion.add(lblHorarios);
		lblHorarios.setVisible(false);
		
		horarios = new JTextPane();
		horarios.setBackground(SystemColor.text);
		horarios.setBounds(273, 89, 143, 68);
		modificacion.add(horarios);
		horarios.setVisible(false);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(12, 137, 58, 16);
		modificacion.add(lblDescripcion);
		lblDescripcion.setVisible(false);
		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(76, 137, 116, 22);
		modificacion.add(descripcion);
		descripcion.setVisible(false);
		
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
				titulo.setVisible(true);
				descripcion.setVisible(true);
				horarios.setVisible(true);

				// hacer visibles los Jlabel que estaban invisibles antes
				lblTitulo.setVisible(true);
				lblDescripcion.setVisible(true);
				lblHorarios.setVisible(true);
				
				// poblar los campos con la info correspondiente al DNI
				codigo.setText(act.modificarActividad(codigo.getText()).getCodigo());
				titulo.setText(act.modificarActividad(codigo.getText()).getTitulo());
				descripcion.setText(act.modificarActividad(codigo.getText()).getDescripcion());
				horarios.setText(act.modificarActividad(codigo.getText()).getHorarios());
				//VER COMO MOSTRAR comboBox.(ClienteTipo)(ab.modificarAbono(codigo.getText()).getTipo();
			
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						act.modificarActividad(codigo.getText(), titulo.getText(), descripcion.getText(), horarios.getText());
						titulo.setText(null);
						codigo.setText(null);
						descripcion.setText(null);
						horarios.setText(null);
					}
				});
			
			
			
			
			
			}
		});
	}
}

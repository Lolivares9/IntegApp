package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.ActividadController;
import Controlador.SocioController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class AltaActividadVista {


	private JTextField codigo;
	private JTextField titulo;
	private JTextField descripcion;
	private ActividadController a = ActividadController.getSingletonInstance();
	private JPanel alta;
	private JTextField textField;
	private JTextArea horarios;
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public AltaActividadVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 248);
		alta.setLayout(null);
		
		JLabel label = new JLabel("Codigo:");
		label.setBounds(24, 58, 70, 14);
		alta.add(label);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(97, 55, 86, 20);
		alta.add(codigo);
		
		JLabel label_1 = new JLabel("Titulo:");
		label_1.setBounds(24, 90, 70, 14);
		alta.add(label_1);
		
		titulo = new JTextField();
		titulo.setColumns(10);
		titulo.setBounds(97, 87, 86, 20);
		alta.add(titulo);
		
		JLabel label_2 = new JLabel("Descripcion:");
		label_2.setBounds(24, 125, 70, 14);
		alta.add(label_2);
		
		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(97, 122, 86, 20);
		alta.add(descripcion);
		
		JLabel label_3 = new JLabel("Horarios:");
		label_3.setBounds(208, 58, 70, 14);
		alta.add(label_3);
		
		JTextArea horarios = new JTextArea();
		horarios.setBounds(218, 85, 163, 72);
		alta.add(horarios);
		
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					a.AltaActividad(codigo.getText(), titulo.getText(), descripcion.getText(), horarios.getText());
					codigo.setText(null);
					titulo.setText(null);
					descripcion.setText(null);
					horarios.setText(null);
			}
		});
		button.setBounds(180, 187, 91, 23);
		alta.add(button);
		
		JLabel lblAltaDeUsuarios = new JLabel("ALTA DE ACTIVIDADES");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(120, 13, 198, 16);
		alta.add(lblAltaDeUsuarios);
		
		
		
		
		
		
	}
}

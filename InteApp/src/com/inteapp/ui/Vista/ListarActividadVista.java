package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Scrollbar;
import java.util.Vector;

import javax.swing.SwingConstants;

import Modelo.Actividad;
import Modelo.Socio;
import Controlador.ActividadController;
import Controlador.SocioController;

import javax.swing.JTable;
import javax.swing.SpringLayout;

public class ListarActividadVista {

	private JPanel lista;
	private JTable tabla;
	private ActividadController actividad;

	/**
	 * Create the application.
	 */
	public ListarActividadVista() {
		initialize();
	}

	public JPanel getLista() {
		return lista;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		actividad = ActividadController.getSingletonInstance();
		

		Vector<String> columnas = new Vector<String>();
		columnas.add("Codigo");
		columnas.add("Titulo");
		columnas.add("Descripcion");
		columnas.add("Horarios");

		Vector<Vector> rows = new Vector<Vector>();
		Vector<Actividad> actividades = actividad.getActividad ();
		
		for (int i=0; i < actividades.size(); i++) {
			Vector<String> x = new Vector<String>();
			x.addElement(actividades.get(i).getCodigo());
			x.addElement(actividades.get(i).getTitulo());
			x.addElement(actividades.get(i).getDescripcion());
			x.addElement(actividades.get(i).getHorarios());
			rows.add(x);
		}

		tabla = new JTable(rows,columnas);
		tabla.setBounds(0, 0, 434, 261);
		
		lista = new JPanel();
		lista.setBounds(0, 0, 434, 261);
		lista.setLayout(null);
		//lista.setLayout(null);
		
		JScrollPane scrollPane= new JScrollPane(tabla);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 37, 414, 213);
		lista.add(scrollPane);

		/*
		JLabel lblNewLabel = new JLabel("LISTA DE SOCIOS");
		lblNewLabel.setBounds(0, 0, 146, 22);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lista.add(lblNewLabel);*/
	}
}

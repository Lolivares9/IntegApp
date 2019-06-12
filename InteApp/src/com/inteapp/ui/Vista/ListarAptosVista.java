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

import Modelo.Cliente;
import Modelo.Socio;
import Controlador.ClienteController;
import Controlador.ActividadController;
import Controlador.SocioController;

import javax.swing.JTable;
import javax.swing.SpringLayout;

public class ListarAptosVista {

	private JPanel lista;
	private JTable tabla;
	private SocioController socio;
	private ClienteController Cliente;
	private ActividadController actividad;
	/**
	 * Create the application.
	 */
	public ListarAptosVista() {
		initialize();
	}

	public JPanel getLista() {
		return lista;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		socio = SocioController.getSingletonInstance();
		Cliente = ClienteController.getSingletonInstance();
		actividad = ActividadController.getSingletonInstance();

		Vector<String> columnas = new Vector<String>();
		columnas.add("Socio");
		columnas.add("Fecha");
		columnas.add("Profesional");
		columnas.add("Observaciones");
		
		Vector<Vector> rows = new Vector<Vector>();
		Vector<Socio> socios = socio.getSocios ();
		
		
		
		
		for (int i=0; i < socios.size(); i++) {
			Vector<String> x = new Vector<String>();
			x.addElement(socios.get(i).getNombre());
			x.addElement(socios.get(i).getAptos().elementAt(i).getFechaCerti());
			x.addElement(socios.get(i).getAptos().elementAt(i).getProfesional());
			x.addElement(socios.get(i).getAptos().elementAt(i).getObservaciones());
			
			rows.add(x);
		}

		tabla = new JTable(rows,columnas);
		tabla.setBounds(0, 0, 434, 261);
		
		lista = new JPanel();
		lista.setBounds(0, 0, 434, 261);
		lista.setLayout(null);
		
		JScrollPane scrollPane= new JScrollPane(tabla);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 37, 414, 213);
		lista.add(scrollPane);

		
	}
}

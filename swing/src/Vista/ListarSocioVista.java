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

import Modelo.Abono;
import Modelo.Socio;
import Controlador.AbonoController;
import Controlador.ActividadController;
import Controlador.SocioController;

import javax.swing.JTable;
import javax.swing.SpringLayout;

public class ListarSocioVista {

	private JPanel lista;
	private JTable tabla;
	private SocioController socio;
	private AbonoController abono;
	private ActividadController actividad;
	/**
	 * Create the application.
	 */
	public ListarSocioVista() {
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
		abono = AbonoController.getSingletonInstance();
		actividad = ActividadController.getSingletonInstance();

		Vector<String> columnas = new Vector<String>();
		columnas.add("Nombre");
		columnas.add("Apellido");
		columnas.add("Domicilio");
		columnas.add("Telefono");
		columnas.add("Mail");
		if(!abono.getAbonos().isEmpty()){
		columnas.add("Abono");
		}
		if(!actividad.getActividades().isEmpty()){
			columnas.add("Actividad");
		}
		Vector<Vector> rows = new Vector<Vector>();
		Vector<Socio> socios = socio.getSocios ();
		
		
		
		
		for (int i=0; i < socios.size(); i++) {
			Vector<String> x = new Vector<String>();
			x.addElement(socios.get(i).getNombre());
			x.addElement(socios.get(i).getApellido());
			x.addElement(socios.get(i).getDomicilio());
			x.addElement(socios.get(i).getTelefono());
			x.addElement(socios.get(i).getMail());
			if(!abono.getAbonos().isEmpty()){
				x.addElement(socios.get(i).getAbonosA().elementAt(0).getNombre());		
			}
			if(!actividad.getActividades().isEmpty()){
				x.addElement(socios.get(i).getActividadesA().elementAt(0).getDescripcion());
			}
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

package Vista;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.Vector;
import Modelo.Abono;
import Controlador.AbonoController;
import javax.swing.JTable;


public class ListarAbonoVista {

	private JPanel lista;
	private JTable tabla;
	private AbonoController abono;

	/**
	 * Create the application.
	 */
	public ListarAbonoVista() {
		initialize();
	}

	public JPanel getLista() {
		return lista;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		abono = AbonoController.getSingletonInstance();
		

		Vector<String> columnas = new Vector<String>();
		columnas.add("Codigo");
		columnas.add("Nombre");
		columnas.add("Precio");
		columnas.add("Vigencia");
		columnas.add("Tipo");

		Vector<Vector> rows = new Vector<Vector>();
		Vector<Abono> abonos = abono.getAbonos();
		
		for (int i=0; i < abonos.size(); i++) {
			Vector<String> x = new Vector<String>();
			x.addElement(abonos.get(i).getCodigo());
			x.addElement(abonos.get(i).getNombre());
			x.addElement(abonos.get(i).getPrecio());
			x.addElement(abonos.get(i).getVigencia());
			x.addElement(abonos.get(i).getTipo().name());
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

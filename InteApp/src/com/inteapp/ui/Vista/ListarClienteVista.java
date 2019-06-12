package Vista;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.Vector;
import Modelo.Cliente;
import Controlador.ClienteController;
import javax.swing.JTable;

import com.inteapp.controller.Liquidador;


public class ListarClienteVista {

	private JPanel lista;
	private JTable tabla;
	private ClienteController Cliente;

	/**
	 * Create the application.
	 */
	public ListarClienteVista() {
		initialize();
	}

	public JPanel getLista() {
		return lista;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Cliente = ClienteController.getSingletonInstance();
		

		Vector<String> columnas = new Vector<String>();
		columnas.add("CUIT");
		columnas.add("Nombre");
		columnas.add("Precio");
		columnas.add("Vigencia");
		columnas.add("Tipo");

		Vector<Vector> rows = new Vector<Vector>();
		Vector<Cliente> clientes = Liquidador.getInstance().;
		
		for (int i=0; i < clientes.size(); i++) {
			Vector<String> x = new Vector<String>();
			x.addElement(clientes.get(i).getCodigo());
			x.addElement(clientes.get(i).getNombre());
			x.addElement(clientes.get(i).getPrecio());
			x.addElement(clientes.get(i).getVigencia());
			x.addElement(clientes.get(i).getTipo().name());
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

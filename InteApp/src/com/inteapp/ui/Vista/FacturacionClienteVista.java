package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.ClienteController;
import Modelo.ClienteTipo;

public class FacturacionClienteVista {
	private JTextField precio;
	private ClienteController ab = ClienteController.getSingletonInstance();
	private JPanel alta;
	private JTextField textField;
	JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public FacturacionClienteVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ab = ClienteController.getSingletonInstance();
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 441);
		alta.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Cliente:");
		lblCodigo.setBounds(24, 58, 158, 14);
		alta.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Servicio:");
		lblNombre.setBounds(24, 90, 158, 14);
		alta.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Importe:");
		lblPrecio.setBounds(24, 125, 158, 14);
		alta.add(lblPrecio);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(212, 125, 119, 20);
		alta.add(precio);
		
		JLabel lblPeriodoVigencia = new JLabel("$");
		lblPeriodoVigencia.setBounds(202, 128, 37, 14);
		alta.add(lblPeriodoVigencia);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton button = new JButton("GRABAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ClienteTipo tipo = (ClienteTipo)comboBox.getSelectedItem();
					ab.AltaCliente( precio.getText(), tipo);

					precio.setText(null);
					
					
			}
		});
		button.setBounds(197, 391, 91, 23);
		alta.add(button);
		
		JLabel lblAltaDeUsuarios = new JLabel("GENERAR FACTURA");
		lblAltaDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(73, 13, 287, 16);
		alta.add(lblAltaDeUsuarios);
		
		comboBox = new JComboBox(ClienteTipo.values());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox.setBounds(198, 87, 133, 20);
		alta.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setBounds(198, 55, 133, 20);
		alta.add(comboBox_1);
		
		
		
		
	}
}

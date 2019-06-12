package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class CargarNovedades {

	private JPanel alta;
	private JComboBox BoxCliente;
	private JComboBox BoxEmpleado;
	private JComboBox BoxConcepto;
	private JTextField txtUnidades;
	
	
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public CargarNovedades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	  @wbp.parser.entryPoint
	 **/
	private void initialize() {
	
		
		alta = new JPanel();
		alta.setBounds(0, 0, 434, 261);
		alta.setLayout(null);
		
		JLabel lblClientes = new JLabel("CLIENTES:");
		lblClientes.setBounds(24, 58, 70, 14);
		alta.add(lblClientes);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		btnCargar.setBounds(119, 155, 91, 23);
		alta.add(btnCargar);
		
		JLabel lblCargarNovedades = new JLabel("CARGAR NOVEDADES");
		lblCargarNovedades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargarNovedades.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarNovedades.setBounds(24, 13, 354, 16);
		alta.add(lblCargarNovedades);
		
		BoxCliente = new JComboBox();
		BoxCliente.setBounds(106, 54, 63, 22);
		alta.add(BoxCliente);
		
		JLabel lblEmpleados = new JLabel("EMPLEADOS");
		lblEmpleados.setBounds(216, 57, 81, 16);
		alta.add(lblEmpleados);
		
		BoxEmpleado = new JComboBox();
		BoxEmpleado.setBounds(309, 54, 69, 22);
		alta.add(BoxEmpleado);
		
		JLabel lblConcepto = new JLabel("CONCEPTO");
		lblConcepto.setBounds(24, 104, 70, 16);
		alta.add(lblConcepto);
		
		BoxConcepto = new JComboBox();
		BoxConcepto.setBounds(106, 101, 63, 22);
		alta.add(BoxConcepto);
		
		JLabel lblNewLabel = new JLabel("UNIDADES");
		lblNewLabel.setBounds(216, 104, 59, 16);
		alta.add(lblNewLabel);
		
		txtUnidades = new JTextField();
		txtUnidades.setBounds(306, 101, 81, 22);
		alta.add(txtUnidades);
		txtUnidades.setColumns(10);
		
		
		
		
	}
}

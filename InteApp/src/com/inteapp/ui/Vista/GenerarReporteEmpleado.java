package Vista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.SocioController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class GenerarReporteEmpleado {
	private SocioController s = SocioController.getSingletonInstance();
	private JPanel alta;
	private JComboBox BoxTipo;
	
	
	

	/**
	 * Launch the application.
	 */

	public JPanel getAlta() {
		return alta;
	}

	/**
	 * Create the application.
	 */
	public GenerarReporteEmpleado() {
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
		
		JLabel lblEmpleado = new JLabel("EMPLEADOS:");
		lblEmpleado.setBounds(24, 58, 90, 14);
		alta.add(lblEmpleado);
		
		//int result = Integer.parseInt(dni.getText());
		
		JButton btnLiquidar = new JButton("GENERAR");
		btnLiquidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		btnLiquidar.setBounds(120, 117, 91, 23);
		alta.add(btnLiquidar);
		
		JLabel lblReporteEmpleado = new JLabel("GENERAR REPORTE POR EMPLEADO");
		lblReporteEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReporteEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteEmpleado.setBounds(24, 13, 354, 16);
		alta.add(lblReporteEmpleado);
		
		BoxTipo = new JComboBox();
		BoxTipo.setBounds(126, 54, 63, 22);
		alta.add(BoxTipo);
		
		
		
		
	}
}

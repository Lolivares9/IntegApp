package Vista;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import javax.swing.JFormattedTextField;
import com.toedter.calendar.JCalendar;

import Controlador.ClienteController;
import Controlador.ActividadController;
import Controlador.CronogramaController;
import Controlador.SocioController;
import Modelo.Cliente;
import Modelo.Actividad;
import Modelo.AptoMedico;
import Modelo.Socio;
import Modelo.Cronograma;
import com.lavantech.gui.comp.DateTimePicker;
import java.util.Vector;

public class AsociacionSocioClienteVista {
	private JCalendar calendar;
	private CronogramaController c;
	private ClienteController abn;
	private SocioController s;
	private JPanel AsociacionAbn;
	Date fec= new Date();
	Date fec2= new Date();
	JComboBox<Cliente> comboBox;
	JComboBox<Socio> comboBox_1;
	
	
	public JPanel getAso() {
		return AsociacionAbn;
	}

	/**
	 * Create the application.
	 */
	public AsociacionSocioClienteVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		AsociacionAbn = new JPanel();
		AsociacionAbn.setBounds(0, 0, 700, 496);
		AsociacionAbn.setLayout(null);

				
		JButton button = new JButton("LIQUIDAR CLIENTE");
		button.setBounds(187, 450, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						Cliente cliente = (Cliente)comboBox.getSelectedItem();
						Socio so = (Socio)comboBox_1.getSelectedItem();
						so.AddCliente(cliente);
						//abn.Asociar(Cliente,so);
						JOptionPane.showMessageDialog(null, "Liquidacion exitosa","Informacion",JOptionPane.OK_OPTION);
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "No se pudo Liquidar el Cliente","Informacion",JOptionPane.OK_OPTION);
					  //JOptionPane.showMessageDialog(null, "No se pudo Asociar el Socio con el Cliente","Informacion",JOptionPane.OK_OPTION);
					}
					
			}
		});
		AsociacionAbn.add(button);
		
		JLabel lblAltaAptoMedico = new JLabel("ASOCIAR SOCIO Cliente:");
		lblAltaAptoMedico.setBounds(54, 11, 322, 32);
		lblAltaAptoMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaAptoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AsociacionAbn.add(lblAltaAptoMedico);
		
		comboBox = new JComboBox<Cliente>(abn.getClientes());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		
		
		comboBox.setBounds(91, 49, 184, 20);
		AsociacionAbn.add(comboBox);
		
		
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(10, 52, 61, 14);
		AsociacionAbn.add(lblNewLabel);
		
		

	}
}
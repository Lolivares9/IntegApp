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

import Controlador.ActividadController;
import Controlador.CronogramaController;
import Controlador.SocioController;
import Modelo.Actividad;
import Modelo.AptoMedico;
import Modelo.Socio;
import Modelo.Cronograma;
import com.lavantech.gui.comp.DateTimePicker;
import java.util.Vector;

public class AsociacionSocioActVista {
	private JCalendar calendar;
	private CronogramaController c;
	private ActividadController act;
	private SocioController s;
	private JPanel Asociacion;
	Date fec= new Date();
	Date fec2= new Date();
	JComboBox comboBox;
	JComboBox comboBox_1;
	
	
	public JPanel getAso() {
		return Asociacion;
	}

	/**
	 * Create the application.
	 */
	public AsociacionSocioActVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		s = SocioController.getSingletonInstance();
		c = CronogramaController.getSingletonInstance();
		act = ActividadController.getSingletonInstance();
		Asociacion = new JPanel();
		Asociacion.setBounds(0, 0, 700, 496);
		Asociacion.setLayout(null);

		
		JButton button = new JButton("GRABAR");
		button.setBounds(187, 450, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						Actividad actividad = (Actividad)comboBox.getSelectedItem();
						Socio so = (Socio)comboBox_1.getSelectedItem();
						so.AddActividad(actividad);
						//act.Asociar(actividad,so);
						JOptionPane.showMessageDialog(null, "Actividad Asociada","Informacion",JOptionPane.OK_OPTION);
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Actividad Asociada","Informacion",JOptionPane.OK_OPTION);
					  //JOptionPane.showMessageDialog(null, "No se pudo Asociar al Socio con la Actividad","Informacion",JOptionPane.OK_OPTION);
					}
					
			}
		});
		Asociacion.add(button);
		
		JLabel lblAltaAptoMedico = new JLabel("CRONOGRAMA");
		lblAltaAptoMedico.setBounds(121, 11, 198, 45);
		lblAltaAptoMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaAptoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Asociacion.add(lblAltaAptoMedico);
		
		comboBox = new JComboBox<Actividad>(act.getActividad());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox_1 = new JComboBox<Socio>(s.getSocios());
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		
		comboBox.setBounds(91, 49, 184, 20);
		Asociacion.add(comboBox);
		
		comboBox_1.setBounds(91, 96, 184, 20);
		Asociacion.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Actividad:");
		lblNewLabel.setBounds(10, 52, 61, 14);
		Asociacion.add(lblNewLabel);
		
		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setBounds(10, 99, 61, 14);
		Asociacion.add(lblSocio);
		

	}
}

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

import Controlador.AbonoController;
import Controlador.ActividadController;
import Controlador.CronogramaController;
import Controlador.SocioController;
import Modelo.Abono;
import Modelo.Actividad;
import Modelo.AptoMedico;
import Modelo.Socio;
import Modelo.Cronograma;
import com.lavantech.gui.comp.DateTimePicker;
import java.util.Vector;

public class AsociacionSocioActividadVista {
	private JCalendar calendar;
	private CronogramaController c;
	private ActividadController act;
	private SocioController s;
	private JPanel AsociacionAct;
	Date fec= new Date();
	Date fec2= new Date();
	JComboBox comboBox;
	JComboBox comboBox_1;
	
	
	public JPanel getAso() {
		return AsociacionAct;
	}

	/**
	 * Create the application.
	 */
	public AsociacionSocioActividadVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		s = SocioController.getSingletonInstance();
		c = CronogramaController.getSingletonInstance();
		act = ActividadController.getSingletonInstance();
		AsociacionAct = new JPanel();
		AsociacionAct.setBounds(0, 0, 700, 496);
		AsociacionAct.setLayout(null);
		
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
					  //JOptionPane.showMessageDialog(null, "No se pudo Asociar el Socio con la Actividad","Informacion",JOptionPane.OK_OPTION);
					}
					
			}
		});
		AsociacionAct.add(button);
		
		JLabel lblAltaAptoMedico = new JLabel("ASOCIAR SOCIO ACTIVIDAD:");
		lblAltaAptoMedico.setBounds(121, 11, 322, 27);
		lblAltaAptoMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaAptoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AsociacionAct.add(lblAltaAptoMedico);
		
		comboBox = new JComboBox<Actividad>(act.getActividades());
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
		AsociacionAct.add(comboBox);
		
		comboBox_1.setBounds(91, 96, 184, 20);
		AsociacionAct.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Abono:");
		lblNewLabel.setBounds(10, 52, 61, 14);
		AsociacionAct.add(lblNewLabel);
		
		JLabel lblSocio = new JLabel("Actividad:");
		lblSocio.setBounds(10, 99, 61, 14);
		AsociacionAct.add(lblSocio);
		

	}
}
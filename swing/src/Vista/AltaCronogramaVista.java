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

public class AltaCronogramaVista {
	private JCalendar calendar;
	private CronogramaController c;
	private ActividadController act;
	private JPanel Cronograma;
	Date fec= new Date();
	Date fec2= new Date();
	JComboBox comboBox;
	
	
	public JPanel getCronograma() {
		return Cronograma;
	}

	/**
	 * Create the application.
	 */
	public AltaCronogramaVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		c = CronogramaController.getSingletonInstance();
		act = ActividadController.getSingletonInstance();
		Cronograma = new JPanel();
		Cronograma.setBounds(0, 0, 700, 496);
		Cronograma.setLayout(null);

		
				
				
		//SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
		
	
		
		
		JButton button = new JButton("GRABAR");
		button.setBounds(187, 450, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try{
						Actividad actividad = (Actividad)comboBox.getSelectedItem();
						c.AsociarActividad(actividad, fec, fec2);
						JOptionPane.showMessageDialog(null, "Actividad Asociada","Informacion",JOptionPane.OK_OPTION);
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "No se pudo Asociar laActividad","Informacion",JOptionPane.OK_OPTION);
					}
					
			}
		});
		Cronograma.add(button);
		
		JLabel lblAltaAptoMedico = new JLabel("CRONOGRAMA");
		lblAltaAptoMedico.setBounds(121, 11, 198, 45);
		lblAltaAptoMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaAptoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Cronograma.add(lblAltaAptoMedico);
		
		comboBox = new JComboBox<Actividad>(act.getActividad());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox.setBounds(91, 49, 184, 20);
		Cronograma.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Actividad:");
		lblNewLabel.setBounds(10, 52, 61, 14);
		Cronograma.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horario Inicio:");
		lblNewLabel_1.setBounds(10, 92, 73, 12);
		Cronograma.add(lblNewLabel_1);
		DateTimePicker dateTimePicker = new DateTimePicker();
		dateTimePicker.setBounds(91, 83, 127, 23);
		Cronograma.add(dateTimePicker);
		
		// Date to String Hora Inicio
		String dia = Integer.toString(dateTimePicker.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes = Integer.toString(dateTimePicker.getCalendar().get(Calendar.MONTH) + 1);
		String year = Integer.toString(dateTimePicker.getCalendar().get(Calendar.YEAR));
		String fecha = (year + "-" + mes+ "-" + dia);
				
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fec=formatter2.parse(fecha);
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
		
		JLabel lblHorarioFin = new JLabel("Horario Fin:");
		lblHorarioFin.setBounds(10, 131, 73, 14);
		Cronograma.add(lblHorarioFin);
		DateTimePicker dateTimePicker_1 = new DateTimePicker();
		dateTimePicker_1.setBounds(91, 120, 127, 23);
		Cronograma.add(dateTimePicker_1);
		
		// Date to String Hora Fin
		String dia2 = Integer.toString(dateTimePicker_1.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes2 = Integer.toString(dateTimePicker_1.getCalendar().get(Calendar.MONTH) + 1);
		String year2 = Integer.toString(dateTimePicker_1.getCalendar().get(Calendar.YEAR));
		String fecha2 = (year2 + "-" + mes2+ "-" + dia2);
				
		SimpleDateFormat formatter3=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fec2=formatter3.parse(fecha2);
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
			
		
	}
}

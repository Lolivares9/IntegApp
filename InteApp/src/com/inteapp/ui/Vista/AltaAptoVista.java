package Vista;

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
import javax.swing.JPanel;
import javax.swing.JTextArea;
//import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import javax.swing.JFormattedTextField;
import com.toedter.calendar.JCalendar;

import Controlador.SocioController;
import Modelo.AptoMedico;
import Modelo.Socio;

public class AltaAptoVista {

	private JTextField profesional;
	private JCalendar calendar;
	private JTextArea observaciones;
	private SocioController s;
	private JPanel Apto;
	Date fec= new Date();
	JComboBox comboBox;
	
	
	public JPanel getApto() {
		return Apto;
	}

	/**
	 * Create the application.
	 */
	public AltaAptoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		s = SocioController.getSingletonInstance();
		
		Apto = new JPanel();
		Apto.setBounds(0, 0, 700, 496);
		Apto.setLayout(null);

		
		JLabel lblNewLabel_1 = new JLabel("Fecha Apto:");
		lblNewLabel_1.setBounds(10, 83, 89, 14);
		Apto.add(lblNewLabel_1);
		
		calendar = new JCalendar();
		calendar.setBounds(91, 74, 295, 153);
		Apto.add(calendar);
	
	
		String dia = Integer.toString(calendar.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes = Integer.toString(calendar.getCalendar().get(Calendar.MONTH) + 1);
		String year = Integer.toString(calendar.getCalendar().get(Calendar.YEAR));
		String fecha = (year + "-" + mes+ "-" + dia);
		
				
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fec=formatter2.parse(fecha);
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
	
				
		JLabel lblProfesional = new JLabel("Profesional:");
		lblProfesional.setBounds(10, 258, 77, 14);
		Apto.add(lblProfesional);
		
		profesional = new JTextField();
		profesional.setBounds(91, 255, 184, 20);
		profesional.setColumns(10);
		Apto.add(profesional);
		
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 294, 89, 14);
		Apto.add(lblObservaciones);
				
		observaciones = new JTextArea();
		observaciones.setBounds(91, 319, 295, 120);
		Apto.add(observaciones);
		
		JButton button = new JButton("GRABAR");
		button.setBounds(187, 450, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AptoMedico apto  = s.AltaAptoMedico(fecha ,profesional.getText(), observaciones.getText());
					//calendar.setDate(null);	
					Socio socio = (Socio)comboBox.getSelectedItem();
					socio.GuardarApto(apto);
					profesional.setText(null);
					observaciones.setText(null);
			}
		});
		Apto.add(button);
		
		JLabel lblAltaAptoMedico = new JLabel("ALTA APTO MEDICO");
		lblAltaAptoMedico.setBounds(121, 11, 198, 45);
		lblAltaAptoMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaAptoMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Apto.add(lblAltaAptoMedico);
		
		comboBox = new JComboBox<Socio>(s.getSocios());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
			}
		});
		
		comboBox.setBounds(91, 49, 184, 20);
		Apto.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Socio:");
		lblNewLabel.setBounds(10, 52, 46, 14);
		Apto.add(lblNewLabel);
	}
}

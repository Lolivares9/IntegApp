package com.inteapp.ui;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import mappers.MapperPreferencias;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
/*				JFileChooser navegador = new JFileChooser();
				navegador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				navegador.setAcceptAllFileFilterUsed(false);
                if (navegador.showOpenDialog(null) == 0) {
                	File path =  navegador.getCurrentDirectory();
                	JOptionPane.showMessageDialog(null, "Path "+navegador.getSelectedFile());
                }
*/
public class Preferencias extends javax.swing.JFrame{
	private static final long serialVersionUID = 7337044116767570123L;
	private JTextField textCodBarra;
	private JTextField textReportes;
	private JLabel lblCodigosDeBarra;
	private JLabel lblReportes;
	private String ValueActualCodBarra;
	private String ValueActualReportes;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton btnExamCod;
	private JButton btnExamRep;
	
	public Preferencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Preferencias.class.getResource("/Images/IconoVentana.png")));
		setTitle("Directorios");
		this.setSize(589, 212);
		setResizable(false);
		getContentPane().setLayout(null);
		lblCodigosDeBarra = new JLabel("Codigos de Barra");
		lblCodigosDeBarra.setBounds(10, 29, 103, 20);
		getContentPane().add(lblCodigosDeBarra);
		
		textCodBarra = new JTextField();
		textCodBarra.setBounds(121, 29, 345, 20);
		getContentPane().add(textCodBarra);
		textCodBarra.setColumns(10);

		btnExamCod = new JButton("");
		btnExamCod.setBorder(null);
		btnExamCod.setIcon(new ImageIcon(Preferencias.class.getResource("/Images/Examinar.png")));
		btnExamCod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser navegador = new JFileChooser();
				navegador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				navegador.setAcceptAllFileFilterUsed(false);
                if (navegador.showOpenDialog(null) == 0) {
                	textCodBarra.setText(navegador.getSelectedFile().toString());
                	textCodBarra.setEditable(false);
                }
			}
		});
		btnExamCod.setBounds(476, 28, 25, 20);
		btnExamCod.setBorderPainted(false);
		btnExamCod.setContentAreaFilled(false); 
		//btnExamCod.setFocusPainted(false); 
		//btnExamCod.setOpaque(false);
		getContentPane().add(btnExamCod);
		
		lblReportes = new JLabel("Reportes");
		lblReportes.setBounds(10, 71, 103, 20);
		getContentPane().add(lblReportes);
		
		textReportes = new JTextField();
		textReportes.setColumns(10);
		textReportes.setBounds(121, 71, 345, 20);
		getContentPane().add(textReportes);
		
		
		obtenerDirectorios();
		
		btnExamRep = new JButton("");
		btnExamRep.setBorder(null);
		btnExamRep.setIcon(new ImageIcon(Preferencias.class.getResource("/Images/Examinar.png")));
		btnExamRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser navegador = new JFileChooser();
				navegador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				navegador.setAcceptAllFileFilterUsed(false);
                if (navegador.showOpenDialog(null) == 0) {
                	textReportes.setText(navegador.getSelectedFile().toString());
                	textReportes.setEditable(false);
                }		
			}
		});
		btnExamRep.setBounds(476, 70, 25, 20);
		btnExamRep.setBorderPainted(false);
		btnExamRep.setContentAreaFilled(false); 
		btnExamRep.setFocusPainted(false); 
		btnExamRep.setOpaque(false);
		getContentPane().add(btnExamRep);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Preferencias.class.getResource("/Images/save.png")));
		btnGuardar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnGuardar.doClick();
				}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=false;
				if (!textCodBarra.getText().equals(ValueActualCodBarra) || !textReportes.getText().equals(ValueActualReportes)){
					//PATH PARA LAS IMAGENES (CODIGOS DE BARRA)
					String preferencia = lblCodigosDeBarra.getText();
					String value = textCodBarra.getText();
					if (MapperPreferencias.existePreferencia(preferencia)){
						if (!value.equals("")){
							flag = MapperPreferencias.updatePreferencia(preferencia, value);	
						}
						else{
							JOptionPane.showMessageDialog(getContentPane(), "Ingrese un directorio valido para los Codigos de barra","", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (Preferencias.class.getResource("/Images/information.png")));
						}
					}
					else{
						if (!value.equals("")){
							flag = flag && MapperPreferencias.insertPreferencia(preferencia, value);	
						}
						else{
							JOptionPane.showMessageDialog(getContentPane(), "Ingrese un directorio valido para los Codigos de barra","", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (Preferencias.class.getResource("/Images/information.png")));
						}
					}
					//PATH PARA LOS REPORTES
					preferencia = lblReportes.getText();
					value = textReportes.getText();
					if (MapperPreferencias.existePreferencia(preferencia)){
						if (!value.equals("")){
							flag = flag && MapperPreferencias.updatePreferencia(preferencia, value);
							//JOptionPane.showMessageDialog(null, "Directorios actualizados correctamente");
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(getContentPane(), "Ingrese un directorio valido para los Reportes","", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (Preferencias.class.getResource("/Images/information.png")));
						}
					}
					else{
						if (!value.equals("")){
							flag = flag && MapperPreferencias.insertPreferencia(preferencia, value);
							//JOptionPane.showMessageDialog(null, "Directorios actualizados correctamente");
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(getContentPane(), "Ingrese un directorio valido para los Reportes","", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (Preferencias.class.getResource("/Images/information.png")));
						}
					}
					if (flag){
						JOptionPane.showMessageDialog(getContentPane(), "Directorios actualizados correctamente." ,"Directorios Actualizados", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (Preferencias.class.getResource("/Images/Modificado.png")));
					}
				}
				else{
					dispose();
				}
			}
		});
		btnGuardar.setBounds(80, 115, 139, 45);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Preferencias.class.getResource("/Images/Cancel.png")));
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCancelar.doClick();
				}
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(295, 115, 139, 45);
		getContentPane().add(btnCancelar);
	}

	private void obtenerDirectorios() {
		//SETEO LOS DIRECTORIOS ACTUALES
		ValueActualCodBarra = MapperPreferencias.selectValuePreferencia(lblCodigosDeBarra.getText());
		ValueActualReportes = MapperPreferencias.selectValuePreferencia(lblReportes.getText());
		textCodBarra.setText(ValueActualCodBarra);
		textCodBarra.setEditable(false);
		textReportes.setText(ValueActualReportes);
		textReportes.setEditable(false);		
	}
	
}

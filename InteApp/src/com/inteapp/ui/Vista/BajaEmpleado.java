package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaEmpleado extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblCuil;
	private JTextField txtCuil;
	private JButton eliminar;

	public JPanel getBaja() {
		return contentPane;
	}
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BajaEmpleado() {
		setTitle("baja Empleado");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCuil = new JLabel("CUIL:");
		getContentPane().add(lblCuil);
		
		
		txtCuil = new JTextField();
		getContentPane().add(txtCuil);
		txtCuil.setColumns(10);
		
		eliminar = new JButton("Eliminar");
		getContentPane().add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCuil, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(eliminar)
						.addComponent(txtCuil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(219, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCuil, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCuil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(eliminar)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	

}

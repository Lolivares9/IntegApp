package Vista;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.AbonoController;
import Controlador.ActividadController;
import Controlador.CronogramaController;
import Controlador.SocioController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class Menu {

	private JFrame frame;
	private SocioController s = SocioController.getSingletonInstance();
	private ActividadController a = ActividadController.getSingletonInstance();
	private AbonoController ab = AbonoController.getSingletonInstance();
	private CronogramaController cr = CronogramaController.getSingletonInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(new java.awt.BorderLayout());
		JPanel menu = new JPanel();
		//menu.setBounds(0, 0, 434, 238);
		frame.getContentPane().add(menu);
		menu.setLayout(null);
		menu.setLayout(null);
		
		JButton btnNewButton = new JButton("INSCRIPCION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				AltaSocioVista a = new AltaSocioVista ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnNewButton.setBounds(95, 149, 230, 23);
		//menu.add(btnNewButton);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnINICIO = new JMenu("INICIO");
		menuBar.add(mnINICIO);
		
		JMenu mnSocio = new JMenu("Socio");
		menuBar.add(mnSocio);
		
		JMenu mnActividad = new JMenu("Actividad");
		menuBar.add(mnActividad);
		
		JMenu mnAbono = new JMenu("Abono");
		menuBar.add(mnAbono);
		
		JMenu mnCronograma = new JMenu("Cronograma");
		menuBar.add(mnCronograma);
		
		class Imagen extends javax.swing.JPanel {

			public Imagen() {
			this.setSize(300, 400); //se selecciona el tamaño del panel
			}

			//Se crea un método cuyo parámetro debe ser un objeto Graphics

			public void paint(Graphics grafico) {
			Dimension height = getSize();

			//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

			ImageIcon Img = new ImageIcon(getClass().getResource("/Images/wallpaper.jpg")); 

			//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

			grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

			setOpaque(false);
			super.paintComponent(grafico);
			}
		}
		
		Imagen Imagen = new Imagen();
		frame.getContentPane().add(Imagen);
		
		String version= "16.2 ";
		JLabel lblNewLabel = new JLabel("Version:"+ version + " ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		frame.repaint();
		
		/*
		mnINICIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				JPanel menu = new JPanel();
				frame.repaint();
			}
		});
		*/
		
	// SOCIO SUBMENU
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AltaSocioVista a = new AltaSocioVista ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnSocio.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				BajaSocioVista a = new BajaSocioVista ();
				frame.setContentPane(a.getBaja());
				frame.repaint();
			}
		});
		mnSocio.add(mntmBaja);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarSocioVista l = new ListarSocioVista ();
				frame.setContentPane(l.getLista());
				frame.repaint();
			}
		});
		
		JMenuItem mntmModificacion = new JMenuItem("Modificacion");
		mntmModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarSocioVista m = new ModificarSocioVista ();
				frame.setContentPane(m.getModificacion());
				frame.repaint();
			}
		});
		mnSocio.add(mntmModificacion);
		mnSocio.add(mntmListar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Apto Medico");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaAptoVista a = new AltaAptoVista ();
				frame.setContentPane(a.getApto());
				frame.repaint();
			}
		});
		mnSocio.add(mntmNewMenuItem);
		
		JMenuItem mntmListarAptos = new JMenuItem("Listar Aptos");
		mntmListarAptos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarAptosVista a = new ListarAptosVista ();
				frame.setContentPane(a.getLista());
				frame.repaint();
			}
		});
		mnSocio.add(mntmListarAptos);
	
	
		
		
	// ACTIVIDAD SUBMENU
		JMenuItem mntmAltaAct = new JMenuItem("Alta");
		mntmAltaAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AltaActividadVista a = new AltaActividadVista ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnActividad.add(mntmAltaAct);
		
		JMenuItem mntmBajaAct = new JMenuItem("Baja");
		mntmBajaAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				BajaActividadVista a = new BajaActividadVista ();
				frame.setContentPane(a.getBaja());
				frame.repaint();
			}
		});
		mnActividad.add(mntmBajaAct);
		
		JMenuItem mntmModifAct = new JMenuItem("Modificacion");
		mntmModifAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				ModificarActividadVista a = new ModificarActividadVista ();
				frame.setContentPane(a.getModif());
				frame.repaint();
			}
		});
		mnActividad.add(mntmModifAct);
		
		JMenuItem mntmListarAct = new JMenuItem("Listar");
		mntmListarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarActividadVista l = new ListarActividadVista ();
				frame.setContentPane(l.getLista());
				frame.repaint();
			}
		});
		mnActividad.add(mntmListarAct);
		
		JMenuItem mntmAsociar = new JMenuItem("Asociar");
		mntmAsociar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsociacionSocioActVista aso = new AsociacionSocioActVista ();
				frame.setContentPane(aso.getAso());
				frame.repaint();
			}
		});
		mnActividad.add(mntmAsociar);
	
		
	// ABONO SUBMENU	
		JMenuItem mntmAltaAbono = new JMenuItem("Alta");
		mntmAltaAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AltaAbonoVista a = new AltaAbonoVista ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnAbono.add(mntmAltaAbono);
		
		JMenuItem mntmModifAbono = new JMenuItem("Modificacion");
		mntmModifAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				ModificarAbonoVista a = new ModificarAbonoVista ();
				frame.setContentPane(a.getModif());
				frame.repaint();
			}
		});
		mnAbono.add(mntmModifAbono);
	
		JMenuItem mntmBajaAbono = new JMenuItem("Baja");
		mntmBajaAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				BajaAbonoVista ab = new BajaAbonoVista ();
				frame.setContentPane(ab.getBaja());
				frame.repaint();
			}
		});
		mnAbono.add(mntmBajaAbono);
		
		JMenuItem mntmListarAbo = new JMenuItem("Listar");
		mntmListarAbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarAbonoVista l = new ListarAbonoVista ();
				frame.setContentPane(l.getLista());
				frame.repaint();
			}
		});
		mnAbono.add(mntmListarAbo);
		
		JMenuItem mntmAsociaAbono = new JMenuItem("Asociar");
		mntmAsociaAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AsociacionSocioAbonoVista a = new AsociacionSocioAbonoVista ();
				frame.setContentPane(a.getAso());
				frame.repaint();
			}
		});
		mnAbono.add(mntmAsociaAbono);
		
	// CRONOGRAMA SUBMENU	
		JMenuItem mntmAsociarCronograma = new JMenuItem("Asociar Actividades");
		mntmAsociarCronograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AltaCronogramaVista cr = new AltaCronogramaVista ();
				frame.setContentPane(cr.getCronograma());
				frame.repaint();
			}
		});
		mnCronograma.add(mntmAsociarCronograma);
		

	}
}

 v

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
		frame.setBounds(100, 100, 655, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(new java.awt.BorderLayout());
		JPanel menu = new JPanel();
		//menu.setBounds(0, 0, 434, 238);
		frame.getContentPane().add(menu);
		menu.setLayout(null);
		menu.setLayout(null);
		
		JButton btnNewButton = new JButton("LIQUIDAR SUELDO");
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				//AltaSocioVista a = new AltaSocioVista ();
				//frame.setContentPane(a.getAlta());
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
		
		JMenu mnSocio = new JMenu("Empleado");
		menuBar.add(mnSocio);
		
		JMenu mnActividad = new JMenu("Sueldos");
		menuBar.add(mnActividad);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		class Imagen extends javax.swing.JPanel {

			public Imagen() {
			this.setSize(300, 400); //se selecciona el tama�o del panel
			}

			//Se crea un m�todo cuyo par�metro debe ser un objeto Graphics

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
		
	// EMPLEADO SUBMENU
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
			AltaEmpleado a = new AltaEmpleado ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnSocio.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				BajaEmpleado a = new BajaEmpleado ();
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
				ModificarEmpleado m = new ModificarEmpleado ();
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
		JMenuItem mntmAltaAct = new JMenuItem("Liquidar Sueldos");
		mntmAltaAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				LiquidarSueldos a = new LiquidarSueldos ();
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
	
		
	// Cliente SUBMENU	
		JMenuItem mntmAltaCliente = new JMenuItem("Alta");
		mntmAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AltaClienteVista a = new AltaClienteVista ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnCliente.add(mntmAltaCliente);
		
		JMenuItem mntmModifCliente = new JMenuItem("Modificacion");
		mntmModifCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				ModificarClienteVista a = new ModificarClienteVista ();
				frame.setContentPane(a.getModif());
				frame.repaint();
			}
		});
		mnCliente.add(mntmModifCliente);
	
		JMenuItem mntmBajaCliente = new JMenuItem("Baja");
		mntmBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				BajaClienteVista ab = new BajaClienteVista ();
				frame.setContentPane(ab.getBaja());
				frame.repaint();
			}
		});
		mnCliente.add(mntmBajaCliente);
		
		JMenuItem mntmListarAbo = new JMenuItem("Listar");
		mntmListarAbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarClienteVista l = new ListarClienteVista ();
				frame.setContentPane(l.getLista());
				frame.repaint();
			}
		});
		mnCliente.add(mntmListarAbo);
		
		JMenuItem mntmFacturacionCliente = new JMenuItem("Facturar");
		mntmFacturacionCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				FacturacionClienteVista a = new FacturacionClienteVista ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnCliente.add(mntmFacturacionCliente);
		
		JMenuItem mntmAsociaCliente = new JMenuItem("Asociar");
		mntmAsociaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				AsociacionSocioClienteVista a = new AsociacionSocioClienteVista ();
				frame.setContentPane(a.getAso());
				frame.repaint();
			}
		});
		mnCliente.add(mntmAsociaCliente);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		
		
		
		JMenuItem mntmGenerarReportes = new JMenuItem("Generar Reporte Total Cliente");
		mntmGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				GenerarReporteTotalCliente a = new GenerarReporteTotalCliente ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnReportes.add(mntmGenerarReportes);
		
		JMenuItem mntmGenerarReporteCliente = new JMenuItem("Generar Reporte Cliente");
		mntmGenerarReporteCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				GenerarReporteCliente a = new GenerarReporteCliente ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnReportes.add(mntmGenerarReporteCliente);
		
		JMenuItem mntmGenerarReporteEmpleado = new JMenuItem("Generar Reporte Empleado");
		mntmGenerarReporteEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				GenerarReporteEmpleado a = new GenerarReporteEmpleado ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnReportes.add(mntmGenerarReporteEmpleado);
		
		JMenu mnNovedades = new JMenu("Novedades");
		menuBar.add(mnNovedades);
		
		JMenuItem mntmCargarNovedades = new JMenuItem("Cargar Novedades");
		mntmCargarNovedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				CargarNovedades a = new CargarNovedades ();
				frame.setContentPane(a.getAlta());
				frame.repaint();
			}
		});
		mnNovedades.add(mntmCargarNovedades);

	}
}

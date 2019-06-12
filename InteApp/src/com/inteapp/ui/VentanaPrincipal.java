package com.inteapp.ui;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;

import reports.ControladorReportes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;

import main.Control;

import org.apache.log4j.Logger;

import ImagePanel.MiPanel;

public class VentanaPrincipal extends javax.swing.JFrame{
	static Logger logger = Logger.getLogger(VentanaPrincipal.class);
	private static final long serialVersionUID = 7628062630411918642L;
	private JPanel pnlBackButtons;
	private JPanel pnlFondo;
	private JButton btnNuevaVenta;
	private JMenuBar menuBar;
	private JMenu jmenuVentas;
	private JMenuItem jMenuItemNuevaVenta;
	private JMenuItem jMenuItemAnularVenta;
	private JMenu jmenuProductos;
	private JMenu jMenuModificarProducto;
	private JMenu jmenuReportes;
	private JMenu mnReportesVarios;
	private JMenu mnReportesPorMarcas;
	private JMenu jMenuMonitoreo;
	private JMenuItem jMenuItemNuevoProducto;
	private JMenuItem jMenuItemModificarProducto;
	private JMenuItem jMenuItemModificarVariosProductos;
	private JMenuItem jMenuItemEliminarProducto;
	private JMenuItem mntmActualizarStock;
	private JMenuItem jMenuItemReportePersonalizado;
	private JMenuItem jMenuItemReporteDiario;
	private JMenuItem jMenuItemReporteSemanal;
	private JMenuItem jMenuItemReporteMensual;
	private JMenuItem jMenuItemReporteAnual;
	private JMenuItem mntmProductosExistentes;
	private JMenu jmenuPreferencias;
	private JButton btnAnularVenta;
	private JButton btnNuevaMarca;
	private JButton btnNuevoProducto;
	private JButton btnSalir;
	private JMenu jmenuMarcas;
	private MiPanel miPanel;
	private JMenuItem jMenuItemNuevaMarca;
	private JMenuItem jMenuItemDirectorios;
	private JMenuItem jMenuItemEliminarMarca;
	private JMenuItem jMenuItemReporteDiarioPorMarca;
	private JMenuItem jMenuItemReporteSemanalPorMarca;
	private JMenuItem jMenuItemReporteMensualPorMarca;
	private JMenuItem jMenuItemReporteAnualPorMarca;
	private JMenuItem jMenuItemReportePersonalizadoPorMarca;
	private JMenuItem jMenuItemVentasDelDia;
	
	private static MonitoreoDeVentas monitoreoVentas;
	public VentanaPrincipal() {
		setResizable(false);
		setTitle("TRANKOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/Images/IconoVentana.png")));
		getContentPane().setLayout(null);
		//ACTION AL CERRAR LA VENTANA
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(getContentPane(), 
		                "¿Esta seguro que desea salir?", "Cerrar", 
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE,
		                new ImageIcon (VentanaPrincipal.class.getResource ("/Images/question.png"))) == JOptionPane.YES_OPTION){
		                logger.info("Finalizando ejecucion...");
		                new Control().cerrarApp(); 
		                System.exit(0);		       
		            }
		    }
		});
		//JMENU ITEM
		jMenuItemNuevaVenta = new JMenuItem("Nueva Venta");
		jMenuItemNuevaVenta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/VentaNueva2.png")));
		jMenuItemAnularVenta = new JMenuItem("Anular Venta");
		jMenuItemAnularVenta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/VentaAnular.png")));
		jMenuItemNuevoProducto = new JMenuItem("Nuevo Producto");
		jMenuItemNuevoProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/ZapatoNuevo.png")));
		jMenuItemEliminarProducto = new JMenuItem("Eliminar Producto");
		jMenuItemEliminarProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/ZapatoEliminar.png")));
		mntmActualizarStock = new JMenuItem("Ingresar Stock");
		mntmActualizarStock.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Zapato.png")));
		jMenuItemNuevaMarca = new JMenuItem("Nueva Marca");
		jMenuItemNuevaMarca.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/MarcaNueva.png")));
		jMenuItemEliminarMarca = new JMenuItem("Eliminar Marca");
		jMenuItemEliminarMarca.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/MarcaEliminar.png")));
		jMenuItemReporteDiario = new JMenuItem("Reporte Diario");
		jMenuItemReporteSemanal = new JMenuItem("Reporte Semanal");
		jMenuItemReporteMensual = new JMenuItem("Reporte Mensual");
		jMenuItemReporteAnual = new JMenuItem("Reporte Anual");
		jMenuItemReportePersonalizado = new JMenuItem("Reporte Personalizado");
		jMenuItemReporteDiarioPorMarca = new JMenuItem("Reporte Diario");
		jMenuItemReporteSemanalPorMarca = new JMenuItem("Reporte Semanal");
		jMenuItemReporteMensualPorMarca = new JMenuItem("Reporte Mensual");
		jMenuItemReporteAnualPorMarca = new JMenuItem("Reporte Anual");
		jMenuItemReportePersonalizadoPorMarca = new JMenuItem("Reporte Personalizado");
		jMenuItemDirectorios = new JMenuItem("Directorios");
		jMenuItemDirectorios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/preferencias.png")));
		jMenuItemVentasDelDia = new JMenuItem("Ventas del dia");
		jMenuItemVentasDelDia.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/MonitoreoVentas.png")));
		jMenuItemVentasDelDia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		//JMENU
		jmenuVentas = new JMenu("Ventas");
		jmenuVentas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Venta.png")));
		jmenuVentas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jmenuVentas.add(jMenuItemNuevaVenta);
		jmenuVentas.add(jMenuItemAnularVenta);
		jmenuProductos = new JMenu("Productos");
		jmenuProductos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Zapato.png")));
		jmenuProductos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jmenuProductos.add(jMenuItemNuevoProducto);
		
		jMenuModificarProducto = new JMenu("Modificar Producto");
		jMenuModificarProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/ZapatoModificar.png")));
		jmenuProductos.add(jMenuModificarProducto);
		jMenuItemModificarProducto = new JMenuItem("Modificar Producto");
		jMenuModificarProducto.add(jMenuItemModificarProducto);
		
		jMenuItemModificarVariosProductos = new JMenuItem("Modificar Varios Productos");
		jMenuItemModificarVariosProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProductosMasivo modifProdMasivo = new ModificarProductosMasivo();
				modifProdMasivo.setLocationRelativeTo(getContentPane());
				modifProdMasivo.setVisible(true);
				modifProdMasivo.validarComboBox();
			}
		});
		jMenuModificarProducto.add(jMenuItemModificarVariosProductos);
		//ACTION JMENU ITEM MODIFICAR PRODUCTO
		jMenuItemModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto modifProd = new ModificarProducto();
				modifProd.setLocationRelativeTo(getContentPane());
				modifProd.setVisible(true);
				modifProd.validarComboBox();
			}
		});
		jmenuProductos.add(jMenuItemEliminarProducto);
		jmenuProductos.add(mntmActualizarStock);
		jmenuMarcas = new JMenu("Marcas");
		jmenuMarcas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Marcas.png")));
		jmenuMarcas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jmenuMarcas.add(jMenuItemNuevaMarca);	
		jmenuMarcas.add(jMenuItemEliminarMarca);	
		mnReportesVarios = new JMenu("Reportes varios");
		mnReportesVarios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Reporte.png")));
		mnReportesVarios.add(jMenuItemReporteDiario);
		mnReportesVarios.add(jMenuItemReporteSemanal);		
		mnReportesVarios.add(jMenuItemReporteMensual);		
		mnReportesVarios.add(jMenuItemReporteAnual);		
		mnReportesVarios.add(jMenuItemReportePersonalizado);
		mnReportesPorMarcas = new JMenu("Reportes por Marcas");
		mnReportesPorMarcas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Reporte2.png")));
		mnReportesPorMarcas.add(jMenuItemReporteDiarioPorMarca);		
		mnReportesPorMarcas.add(jMenuItemReporteSemanalPorMarca);		
		mnReportesPorMarcas.add(jMenuItemReporteMensualPorMarca);		
		mnReportesPorMarcas.add(jMenuItemReporteAnualPorMarca);
		mnReportesPorMarcas.add(jMenuItemReportePersonalizadoPorMarca);
		mntmProductosExistentes = new JMenuItem("Productos Existentes");
		mntmProductosExistentes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Zapato.png")));
		jmenuReportes = new JMenu("Reportes");
		jmenuReportes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Reportes.png")));
		jmenuReportes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jmenuPreferencias = new JMenu("Preferencias");
		jmenuPreferencias.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Preferences.png")));
		jmenuPreferencias.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jMenuMonitoreo = new JMenu("Monitoreo");
		jMenuMonitoreo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Monitoreo2.png")));
		jMenuMonitoreo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jMenuMonitoreo.add(jMenuItemVentasDelDia);
		
		jmenuReportes.add(mnReportesVarios);
		jmenuReportes.add(mnReportesPorMarcas);
		jmenuReportes.add(mntmProductosExistentes);
		jmenuPreferencias.add(jMenuItemDirectorios);
		//JMENU BAR
		menuBar = new JMenuBar();
		menuBar.setLocation(0, 0);
		menuBar.setSize(726, 30);
		menuBar.add(jmenuVentas);
		menuBar.add(jmenuProductos);
		menuBar.add(jmenuMarcas);
		menuBar.add(jmenuReportes);
		menuBar.add(jmenuPreferencias);
		menuBar.add(jMenuMonitoreo);
		//AGREGO CEL JMENUBAR EN LA VENTANA
		getContentPane().add(menuBar, BorderLayout.NORTH);		
		
		//JBUTTON
		btnNuevaVenta = new JButton("<html><p align=\"center\">Nueva<br><p align=\"center\">Venta</p></html>");
		btnNuevaVenta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/VentaNueva2.png")));
		btnNuevaVenta.setBounds(10, 11, 121, 74);
		btnNuevaVenta.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnAnularVenta = new JButton("<html><p align=\"center\">Anular<br><p align=\"center\">Venta</p></html>");
		btnAnularVenta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/VentaAnular.png")));
		btnAnularVenta.setBounds(10, 103, 121, 74);
		btnAnularVenta.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNuevaMarca = new JButton("<html><p align=\"center\">Nueva<br><p align=\"center\">Marca</p></html>");
		btnNuevaMarca.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/MarcaNueva.png")));
		btnNuevaMarca.setBounds(10, 199, 121, 74);
		btnNuevaMarca.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNuevoProducto = new JButton("<html><p align=\"center\">Nuevo<br><p align=\"center\">Producto</p></html>");
		btnNuevoProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/ZapatoNuevo.png")));
		btnNuevoProducto.setBounds(10, 295, 121, 74);
		btnNuevoProducto.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSalir = new JButton("<html><p align=\"center\">Salir<br></html>");
		btnSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Images/Cancel.png")));
		btnSalir.setBounds(10, 392, 121, 74);
		btnSalir.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		
		//INICIALIZACION DE LAS VARIABLES
		pnlBackButtons = new JPanel();
		pnlBackButtons.setBounds(0, 0, 139, 491);
		pnlBackButtons.setBackground(Color.WHITE);
		pnlBackButtons.setLayout(null);
		pnlBackButtons.add(btnNuevaVenta);
		pnlBackButtons.add(btnNuevoProducto);
		pnlBackButtons.add(btnAnularVenta);
		pnlBackButtons.add(btnNuevaMarca);
		pnlBackButtons.add(btnSalir);
		
		//PANEL FONDO
		pnlFondo = new JPanel();
		pnlFondo.setBackground(Color.WHITE);
		pnlFondo.setBounds(10, 41, 706, 479);
		pnlFondo.add(pnlBackButtons);
		pnlFondo.setLayout(null);
		
		//JPANEL (IMAGEN DE FONDO)
		miPanel = new MiPanel();
		miPanel.setBounds(139, 36, 567, 454);
		FlowLayout flowLayout = (FlowLayout) miPanel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		pnlFondo.add(miPanel);
		getContentPane().add(pnlFondo);
		
		//ACTION JMENU ITEM DIRECTORIOS
		jMenuItemDirectorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Preferencias preferencias = new Preferencias();
				preferencias.setLocationRelativeTo(getContentPane());
				preferencias.setVisible(true);
			}
		});
		//ACTION JMENU ITEM NUEVA VENTA
		jMenuItemNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				NuevaVenta nuevaVenta = new NuevaVenta(monitoreoVentas);
				nuevaVenta.setLocationRelativeTo(getContentPane());
				nuevaVenta.setVisible(true);
				nuevaVenta.AgregarItem();
			}
		});
		//ACTION JMENU ITEM ANULAR VENTA
		jMenuItemAnularVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				AnularVenta anularVenta = new AnularVenta(monitoreoVentas);
				anularVenta.setLocationRelativeTo(getContentPane());
				anularVenta.setVisible(true);
			}
		});
		//ACTION JMENU ITEM NUEVO PRODUCTO
		jMenuItemNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoProducto nuevoProd = new NuevoProducto();
				nuevoProd.setLocationRelativeTo(getContentPane());
				nuevoProd.setVisible(true);
				nuevoProd.validarComboBox();
			}
		});
		//ACTION JMENU ITEM ELIMINAR PRODUCTO
		jMenuItemEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto elimProd = new EliminarProducto();
				elimProd.setLocationRelativeTo(getContentPane());
				elimProd.setVisible(true);
			}
		});	
		//ACTION JMENU ITEM INGRESAR STOCK PRODUCTO
		mntmActualizarStock.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					mntmActualizarStock.doClick();
				}
			}
		});
		mntmActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarStock ingresarStock = new IngresarStock();
				ingresarStock.setLocationRelativeTo(getContentPane());
				ingresarStock.setVisible(true);
			}
		});
		//ACTION JMENU ITEM NUEVA MARCA
		jMenuItemNuevaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaMarca nuevaMarca = new NuevaMarca();
				nuevaMarca.setLocationRelativeTo(getContentPane());
				nuevaMarca.setVisible(true);
			}
		});
		//ACTION JMENU ITEM ELIMINAR MARCA	
		jMenuItemEliminarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarMarca elimMarca = new EliminarMarca();
				elimMarca.setLocationRelativeTo(getContentPane());
				elimMarca.setVisible(true);
				elimMarca.validarComboBox();
			}
		});
		//ACTION JMENU ITEM REPORTE PERSONALIZADO
		jMenuItemReportePersonalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportePersonalizado reporteP = new ReportePersonalizado();
				reporteP.setLocationRelativeTo(getContentPane());
				reporteP.setVisible(true);
			}
		});
		//ACTION JMENU ITEM REPORTE ANUAL
		jMenuItemReporteAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				ControladorReportes.getInstance().reporteVentasAnuales();
			}
		});
		//ACTION JMENU ITEM REPORTE MENSUAL
		jMenuItemReporteMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorReportes.getInstance().reporteVentasMensuales();
			}
		});
		//ACTION JMENU ITEM REPORTE SEMANAL
		jMenuItemReporteSemanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorReportes.getInstance().reporteVentasSemanales();
			}
		});
		//ACTION JMENU ITEM REPORTE DIARIO
		jMenuItemReporteDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorReportes.getInstance().reporteVentasDiarias();
			}
		});
		//ACTION JMENU ITEM REPORTE DIARIO POR MARCA
		jMenuItemReporteDiarioPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportePorMarca reportePorMarca = new ReportePorMarca("Diario");
				reportePorMarca.setLocationRelativeTo(getContentPane());		
				reportePorMarca.validarComboBox();
			}
		});
		//ACTION JMENU ITEM REPORTE SEMANA POR MARCA		
		jMenuItemReporteSemanalPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportePorMarca reportePorMarca = new ReportePorMarca("Semanal");
				reportePorMarca.setLocationRelativeTo(getContentPane());		
				reportePorMarca.validarComboBox();
			}
		});
		//ACTION JMENU ITEM REPORTE MENSUAL POR MARCA
		jMenuItemReporteMensualPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportePorMarca reportePorMarca = new ReportePorMarca("Mensual");
				reportePorMarca.setLocationRelativeTo(getContentPane());		
				reportePorMarca.validarComboBox();
			}
		});
		//ACTION JMENU ITEM REPORTE ANUAL POR MARCA
		jMenuItemReporteAnualPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportePorMarca reportePorMarca = new ReportePorMarca("Anual");
				reportePorMarca.setLocationRelativeTo(getContentPane());		
				reportePorMarca.validarComboBox();
			}
		});
		//ACTION JMENU ITEM REPORTE PERSONALIZADO POR MARCA
		jMenuItemReportePersonalizadoPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportePersonalizadoPorMarca reportePM = new ReportePersonalizadoPorMarca();
				reportePM.setLocationRelativeTo(getContentPane());
				reportePM.setVisible(true);
				reportePM.validarComboBox();
			}
		});
		//ACTION JMENU ITEM REPORTE PRODUCTOS EXISTENTES
		mntmProductosExistentes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					mntmProductosExistentes.doClick();
				}
			}
		});
		mntmProductosExistentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorReportes.getInstance().reporteProductosExistentes();
			}
		});			
		//ACTION BUTTON NUEVA VENTA
		btnNuevaVenta.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					jMenuItemNuevaVenta.doClick();
				}
			}
		});
		btnNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemNuevaVenta.doClick();
			}
		});
		//ACTION BUTTON ANULAR VENTA
		btnAnularVenta.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					jMenuItemAnularVenta.doClick();
				}
			}
		});
		btnAnularVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemAnularVenta.doClick();
			}
		});
		//ACTION BUTTON NUEVA MARCA
		btnNuevaMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					jMenuItemNuevaMarca.doClick();	
				}
			}
		});
		btnNuevaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemNuevaMarca.doClick();
			}
		});
		//ACTION BUTTON NUEVO PRODUCTO
		btnNuevoProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					jMenuItemNuevoProducto.doClick();
				}
			}
		});
		btnNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemNuevoProducto.doClick();
			}
		});		
		//ACTION BUTTON SALIR
		btnSalir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnSalir.doClick();
				}
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Finalizando ejecucion...");
				new Control().cerrarApp(); 
				System.exit(0);
			}
		});	
		
		//VENTANA DE MONITOREO DE VENTAS.
		monitoreoVentas = new MonitoreoDeVentas();
		monitoreoVentas.setLocationRelativeTo(null);
		//ACTION JMENU MONITOREO DE VENTAS
		jMenuItemVentasDelDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monitoreoVentas.setLocationRelativeTo(getContentPane());
				monitoreoVentas.setVisible(true);
			}
		});
		
		setSize (732,553);
		setLocationRelativeTo(null);
		this.setVisible(true);
		logger.info("Inicializando ejecucion...");
	}
}
 
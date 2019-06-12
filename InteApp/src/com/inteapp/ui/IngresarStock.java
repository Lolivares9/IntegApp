package com.inteapp.ui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import mappers.MapperPreferencias;
import controller.ControladorProductos;
import services.CodeBarGenerator;
import views.ProductoView;

public class IngresarStock extends javax.swing.JFrame{
	private static final long serialVersionUID = 8520233684380522959L;
	private JTextField textCodigo;
	private JTextField textStock;
	private JLabel lblCodigo;  
	private JLabel lblMarca;
	private JLabel lblStock; 
	private JLayeredPane lyrdCod;
	private JLabel pnlCodigo;
	private JButton btnIngresarStock;
	private JButton btnCancelar;
	private JButton btnDescCod;
	private String pathActualCodBarra; 
	private JLabel lblDescripcion;
	private JTextField textDescripcion;
	private JTextField txtMarca;
	private ProductoView p = null;
	public IngresarStock() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(IngresarStock.class.getResource("/Images/IconoVentana.png")));
		setResizable(false);
		setTitle("Ingresar Stock");
		obtenerDirectorios();
		this.setSize(500, 280);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("");
		lblCodigo.setIcon(new ImageIcon(IngresarStock.class.getResource("/Images/barcode3.png")));
		lblCodigo.setBounds(10, 23, 78, 22);
		getContentPane().add(lblCodigo);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 56, 78, 22);
		getContentPane().add(lblMarca);
		
		lblStock = new JLabel("<html><p align=\"center\">Unidades<br><p align=\"center\">Ingresadas</p></html>");
		lblStock.setBounds(10, 117, 69, 37);
		getContentPane().add(lblStock);

		textCodigo = new JTextField();
		textCodigo.setBounds(83, 26, 164, 20);
		textCodigo.setColumns(10);
		getContentPane().add(textCodigo);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 89, 78, 22);
		getContentPane().add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(83, 89, 164, 20);
		getContentPane().add(textDescripcion);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(83, 56, 164, 22);
		getContentPane().add(txtMarca);
		
		textStock = new JTextField();
		textStock.setColumns(10);
		textStock.setBounds(83, 123, 78, 20);
		getContentPane().add(textStock);
		
		btnIngresarStock = new JButton("Actualizar");
		btnIngresarStock.setIcon(new ImageIcon(IngresarStock.class.getResource("/Images/ZapatoModificar.png")));
		btnIngresarStock.setBounds(86, 170, 120, 49);
		getContentPane().add(btnIngresarStock);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(IngresarStock.class.getResource("/Images/Cancel.png")));
		btnCancelar.setBounds(252, 170, 134, 49);
		getContentPane().add(btnCancelar);
		
		btnDescCod = new JButton("");
		btnDescCod.setIcon(new ImageIcon(IngresarStock.class.getResource("/Images/DescBarCode.png")));
		btnDescCod.setBounds(429, 122, 26, 26);
		//btnDescCod.setBorderPainted(false);
		btnDescCod.setContentAreaFilled(false); 
		btnDescCod.setFocusPainted(false); 
		btnDescCod.setOpaque(false);
		btnDescCod.setVisible(false);
		getContentPane().add(btnDescCod);
		
		lyrdCod = new JLayeredPane();
		lyrdCod.setToolTipText("");
		lyrdCod.setBorder(new LineBorder(Color.GRAY));
		lyrdCod.setBounds(257, 23, 204, 97);
		getContentPane().add(lyrdCod);
		
		pnlCodigo = new JLabel();
		pnlCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCodigo.setBounds(10, 11, 184, 76);
		lyrdCod.add(pnlCodigo);
		pnlCodigo.setBackground(Color.WHITE);
		
		//Acción al presionar enter en el campo de código
		textCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					cargarProducto();
				}
			}
		});
		textCodigo.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {

			}
		});
		//accion al presionar enter luego de la cantidad de stock ingresada.
		textStock.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					btnIngresarStock.doClick();
				}
			}
		});
		btnIngresarStock.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnIngresarStock.doClick();
				}
			}
		});
		//Acción boton modificar
		btnIngresarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modif = ControladorProductos.getInstance().actualizarStockProducto(p, Integer.parseInt(textStock.getText()));
				if(modif){
			        if (JOptionPane.showConfirmDialog(getContentPane(), "<html><p align=\"center\">Se actualizó correctamente el stock del producto<br><p align=\"center\">¿Desea ingresar stock de otro producto?</p></html>", "",
			                JOptionPane.YES_NO_OPTION,
			                JOptionPane.QUESTION_MESSAGE, new ImageIcon (IngresarStock.class.getResource("/Images/question.png"))) == JOptionPane.YES_OPTION){			     
			        	p = null;			        	
			        	textCodigo.setEditable(true);
			        	textCodigo.setText("");			        	
			        	txtMarca.setText("");
			        	txtMarca.setEditable(false);			        	
			        	textDescripcion.setText("");
			        	textDescripcion.setEditable(false);			        	
			        	textStock.setText("");
			        	textStock.setEditable(false);
			        	
			        	btnIngresarStock.setEnabled(false);
			        	pnlCodigo.setIcon(null);
			        	btnDescCod.setVisible(false);
			            }else{
			            	dispose();
			            }					
				}
			}
		});		
		btnCancelar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCancelar.doClick();
				}
			}
		});
		//Acción boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});		
		//Acción del botón descargar
		btnDescCod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if (JOptionPane.showConfirmDialog(getContentPane(), 
		                "¿Desea descargar el código de barras?", "Guardar", 
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE , new ImageIcon (IngresarStock.class.getResource("/Images/question.png"))) == JOptionPane.YES_OPTION){
		        	File outputFile = new File(pathActualCodBarra + "\\"+ txtMarca.getText().toString() + " - " + (textDescripcion.getText()).replace("/", "-") +  ".jpg");
					try {
						CodeBarGenerator cbg = new CodeBarGenerator();
						cbg.generate(outputFile, textCodigo.getText());
						JOptionPane.showMessageDialog(getContentPane(), "Imagen almacenada en el directorio: " + pathActualCodBarra, "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (IngresarStock.class.getResource("/Images/ok.png")));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            }
			}
		});
			
		btnIngresarStock.setEnabled(false);
	}
	private void traerCodigo(){
		CodeBarGenerator cbg = new CodeBarGenerator();
		BufferedImage im = cbg.generarCodigo(textCodigo.getText());
		ImageIcon img = new ImageIcon(im);
		pnlCodigo.setIcon(img);
		btnDescCod.setVisible(true);
	}
	private void obtenerDirectorios() {
		//SETEO LOS DIRECTORIOS ACTUALES
		pathActualCodBarra = MapperPreferencias.selectValuePreferencia("Codigos de Barra");
	}
	private void cargarProducto() {
		//Busco código ingresado en base de datos
		p = ControladorProductos.getInstance().buscarProducto(textCodigo.getText());
		if(p!=null){
			//SETEO LAS MARCA Y DESCRIPCION ACTUAL PARA PODER MAPEAR LA IMAGEN
			traerCodigo();

			txtMarca.setText(p.getMarca().getNombre());									
			textDescripcion.setText(p.getDescripcion());						

			textCodigo.setEditable(false);
			txtMarca.setEditable(false);
			textDescripcion.setEditable(false);	
			btnIngresarStock.setEnabled(true);
			
			textStock.setText("0");
			textStock.requestFocus();
			textStock.selectAll();
		}else{
			JOptionPane.showMessageDialog(getContentPane(), "El producto no se encuentra dado de alta.", "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (IngresarStock.class.getResource("/Images/warning.png")));
		}
	}
	public void cargarCodigoDelProducto(String codProd) {
		textCodigo.setText(codProd);	
		cargarProducto();
	}
}

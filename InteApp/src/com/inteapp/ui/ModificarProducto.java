package com.inteapp.ui;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControladorMarcas;
import controller.ControladorProductos;
import services.CodeBarGenerator;
import views.ProductoView;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import mappers.MapperPreferencias;
import negocio.Marca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;

import java.awt.Toolkit;

public class ModificarProducto extends javax.swing.JFrame {
	private static final long serialVersionUID = 8520233684380522959L;
	private JTextField textCodigo;
	private JTextField textPrecio;
	private JTextField textCosto;
	private JLabel lblCodigo;  
	private JLabel lblMarca;
	private JLabel lblPrecio; 
	private JLabel lblCosto;
	private JLayeredPane lyrdCod;
	private JLabel pnlCodigo;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnDescCod;
	private String pathActualCodBarra; 
	private JLabel lblDescripcion;
	private JTextField textDescripcion;
	private JComboBox<String> cboMarca;
	private String descripcionActual;
	private String marcaActual;
	public ModificarProducto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarProducto.class.getResource("/Images/IconoVentana.png")));
		setResizable(false);
		setTitle("Modificar Producto");
		obtenerDirectorios();
		this.setSize(500, 280);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("");
		lblCodigo.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/barcode3.png")));
		lblCodigo.setBounds(10, 23, 78, 22);
		getContentPane().add(lblCodigo);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 56, 78, 22);
		getContentPane().add(lblMarca);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 122, 44, 22);
		getContentPane().add(lblPrecio);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(151, 122, 39, 22);
		getContentPane().add(lblCosto);

		textCodigo = new JTextField();
		textCodigo.setBounds(83, 26, 164, 20);
		getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		//Acción al presionar enter en el campo de código
		textCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					//Busco código ingresado en base de datos
					ProductoView p = ControladorProductos.getInstance().buscarProducto(textCodigo.getText());
					if(p!=null){
						//SETEO LAS MARCA Y DESCRIPCION ACTUAL PARA PODER MAPEAR LA IMAGEN
						marcaActual = p.getMarca().getNombre();
						descripcionActual = p.getDescripcion();
						
						textDescripcion.setText(p.getDescripcion());
						textPrecio.setText(Float.toString(p.getPrecio()));
						textCosto.setText(Float.toString(p.getCosto()));
						traerCodigo();
						textCodigo.setEditable(false);
						btnModificar.setEnabled(true);
						textDescripcion.requestFocus();
						cboMarca.setSelectedItem(p.getMarca().getNombre());
						cboMarca.setEditable(false);
						cboMarca.setEnabled(false);
						
					}else{
						JOptionPane.showMessageDialog(getContentPane(), "El producto no se encuentra dado de alta.", "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (ModificarProducto.class.getResource("/Images/warning.png")));
					}
				}
			}
		});
		textCodigo.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				
			}
		});
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(83, 123, 59, 20);
		getContentPane().add(textPrecio);
		
		textCosto = new JTextField();
		textCosto.setColumns(10);
		textCosto.setBounds(187, 123, 60, 20);
		getContentPane().add(textCosto);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/ZapatoModificar.png")));
		btnModificar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnModificar.doClick();
				}
			}
		});
		btnModificar.setEnabled(false);
		//Acción boton modificar
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Marca marca = new Marca (cboMarca.getSelectedItem().toString());
				ProductoView p = new ProductoView(textCodigo.getText(),marca , textDescripcion.getText(), Float.parseFloat(textPrecio.getText()), Float.parseFloat(textCosto.getText()), 0);
				boolean modif = ControladorProductos.getInstance().modificarProducto(p);
				if(modif){
					File archModif = new File(pathActualCodBarra+ "\\"+ marcaActual + " - " + descripcionActual +".jpg");
					archModif.renameTo(new File(pathActualCodBarra+ "\\" + cboMarca.getSelectedItem() + " - " + textDescripcion.getText() +".jpg"));
			        if (JOptionPane.showConfirmDialog(getContentPane(),"<html><p align=\"center\">Se modificó correctamente el producto<br><p align=\"center\">¿Desea modificar otro producto?</p></html>", "Modificar", 
			                JOptionPane.YES_NO_OPTION,
			                JOptionPane.QUESTION_MESSAGE, new ImageIcon (ModificarProducto.class.getResource("/Images/question.png"))) == JOptionPane.YES_OPTION){
			        	textCodigo.setEditable(true);
			        	textCodigo.setText("");
			        	textDescripcion.setText("");
			        	textPrecio.setText("");
			        	textCosto.setText("");
			        	btnModificar.setEnabled(false);
			        	pnlCodigo.setIcon(null);
			        	btnDescCod.setVisible(false);
			            }else{
			            	dispose();
			            }					
				}
			}
		});
		btnModificar.setBounds(86, 170, 120, 49);
		getContentPane().add(btnModificar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/Cancel.png")));
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
		btnCancelar.setBounds(252, 170, 134, 49);
		getContentPane().add(btnCancelar);
		
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
		
		btnDescCod = new JButton("");
		btnDescCod.setIcon(new ImageIcon(ModificarProducto.class.getResource("/Images/DescBarCode.png")));
		btnDescCod.setBounds(429, 122, 26, 26);
		//btnDescCod.setBorderPainted(false);
		btnDescCod.setContentAreaFilled(false); 
		btnDescCod.setFocusPainted(false); 
		btnDescCod.setOpaque(false);
		btnDescCod.setVisible(false);
		getContentPane().add(btnDescCod);
		
		//Acción del botón descargar
		btnDescCod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if (JOptionPane.showConfirmDialog(getContentPane(), 
		                "¿Desea descargar el código de barras?", "Guardar", 
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE, new ImageIcon (ModificarProducto.class.getResource("/Images/question.png"))) == JOptionPane.YES_OPTION){
		        	File outputFile = new File(pathActualCodBarra + "\\"+ cboMarca.getSelectedItem().toString()+ " - " + (textDescripcion.getText()).replace("/", "-") +  ".jpg");
					try {
						CodeBarGenerator cbg = new CodeBarGenerator();
						cbg.generate(outputFile, textCodigo.getText());
						JOptionPane.showMessageDialog(getContentPane(), "Imagen almacenada en el directorio: " + pathActualCodBarra, "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (ModificarProducto.class.getResource("/Images/ok.png")));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            }
			}
		});
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 89, 78, 22);
		getContentPane().add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(83, 89, 164, 20);
		getContentPane().add(textDescripcion);
		
		cboMarca = new JComboBox<String>();
		cboMarca.setBounds(83, 56, 164, 22);
		getContentPane().add(cboMarca);
		ControladorMarcas.getInstance().cargarComboBoxMarca(cboMarca);

	}
	
	private void traerCodigo(){
		CodeBarGenerator cbg = new CodeBarGenerator();
		BufferedImage im = cbg.generarCodigo(textCodigo.getText());
		ImageIcon img = new ImageIcon(im);
		pnlCodigo.setIcon(img);
		btnDescCod.setVisible(true);
	}
	public void validarComboBox() {
		if (cboMarca.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(getContentPane(), "No se encontraron marcas existentes.\nPrimero debe crear una Marca para los productos.","Marcas inexistentes", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (ModificarProducto.class.getResource("/Images/nok.png")));
			dispose();
		}
	}
	private void obtenerDirectorios() {
		//SETEO LOS DIRECTORIOS ACTUALES
		pathActualCodBarra = MapperPreferencias.selectValuePreferencia("Codigos de Barra");
	}
}

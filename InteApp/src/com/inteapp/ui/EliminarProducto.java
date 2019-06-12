package com.inteapp.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import services.CodeBarGenerator;
import views.ProductoView;
import controller.ControladorProductos;
import mappers.MapperPreferencias;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.Toolkit;

public class EliminarProducto extends javax.swing.JFrame{

	private static final long serialVersionUID = 7337044116767570123L;
	private JLabel lblDescripcion;
	private JLabel pnlCodigo;
	private JLabel lblCodigo;  
	private JTextField textCodigo;
	private JTextField textDescripcion;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JLayeredPane layeredPane;
	private String pathActualCodBarra;
	private JTextField textMarca;
	
	public EliminarProducto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EliminarProducto.class.getResource("/Images/IconoVentana.png")));
		//PROPIEDADES DE LA VENTANA
		setResizable(false);
		setTitle("Eliminar Producto");
		this.setSize(478, 230);
		getContentPane().setLayout(null);
		//OBTENGO DIRECTORIO DEL PATH DONDE SE ALMACENARAN LAS IMAGENES
		obtenerDirectorios();
		//INICIALIZACION DE LAS VARIABLES
		//LABELS		
		lblCodigo = new JLabel("");
		lblCodigo.setIcon(new ImageIcon(EliminarProducto.class.getResource("/Images/barcode3.png")));
		lblCodigo.setBounds(10, 23, 78, 22);	
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 87, 97, 22);	
		//TEXTFIELDS
		textCodigo = new JTextField();
		textCodigo.setBounds(82, 24, 150, 20);
		textCodigo.setColumns(10);
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(82, 88, 150, 20);
		//BUTTON
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(EliminarProducto.class.getResource("/Images/Cancel.png")));
		btnCancelar.setBounds(250, 140, 130, 45);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(EliminarProducto.class.getResource("/Images/Eliminar.png")));
		btnEliminar.setBounds(92, 140, 130, 45);
		btnEliminar.setEnabled(false);
		//PANEL
		pnlCodigo = new JLabel();
		pnlCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCodigo.setBounds(10, 11, 184, 76);
		pnlCodigo.setBackground(Color.WHITE);
		//LAYEREDPANE
		layeredPane = new JLayeredPane();
		layeredPane.setToolTipText("");
		layeredPane.setBorder(new LineBorder(Color.GRAY));
		layeredPane.setBounds(250, 23, 204, 97);
		layeredPane.add(pnlCodigo);
		//ACTION ENTER TEXTFIELD CODIGO DE BARRAS
		textCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(!textCodigo.getText().isEmpty()){
						buscarCodigo();
					}
				}
			}
		});
		textDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_ENTER){
					if(!textCodigo.getText().isEmpty()){
						btnEliminar.doClick();
					}
				}
			}
		});
		textDescripcion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				buscarCodigo();
			}
		});	
		//ACTION BUTTON ELIMINAR
		btnEliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnEliminar.doClick();
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modif = ControladorProductos.getInstance().eliminarProducto(textCodigo.getText());
				if(modif){
					File archDel = new File(pathActualCodBarra+ "\\" + textMarca.getText() + " - " + textDescripcion.getText()+".jpg");
					archDel.delete();
			        if (JOptionPane.showConfirmDialog(getContentPane(), 
			                "Se anulo correctamente el producto ¿Desea anular otro producto?", "Anular", 
			                JOptionPane.YES_NO_OPTION,
			                JOptionPane.QUESTION_MESSAGE,
			                new ImageIcon (EliminarProducto.class.getResource("/Images/question.png"))) == JOptionPane.YES_OPTION){
			        	textCodigo.setEditable(true);
			        	textCodigo.setText("");
			        	textDescripcion.setText("");
			        	btnEliminar.setEnabled(false);
			        	pnlCodigo.setIcon(null);
			            }else{
			            	dispose();
			            }					
				}
			}
		});
		//ACTION BUTTON CANCELAR
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_ENTER){
						btnCancelar.doClick();
				}
			}
		});
		//AGREGO COMPONENTES EN LA VENTANA
		getContentPane().add(lblCodigo);
		getContentPane().add(lblDescripcion);
		getContentPane().add(textCodigo);
		getContentPane().add(textDescripcion);
		getContentPane().add(layeredPane);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnEliminar);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 56, 97, 22);
		getContentPane().add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(82, 57, 150, 20);
		getContentPane().add(textMarca);
		
	}
	
	private void traerCodBarras(){
		CodeBarGenerator cbg = new CodeBarGenerator();
		BufferedImage im = cbg.generarCodigo(textCodigo.getText());
		ImageIcon img = new ImageIcon(im);
		pnlCodigo.setIcon(img);
	}
	
	private void buscarCodigo(){
		//Busco código ingresado en base de datos
		ProductoView p = ControladorProductos.getInstance().buscarProducto(textCodigo.getText());
		if(p!=null){
			textMarca.setText(p.getMarca().getNombre());
			textDescripcion.setText(p.getDescripcion());
			traerCodBarras();
			textCodigo.setEditable(false);
			btnEliminar.setEnabled(true);
			textDescripcion.setEditable(false);
			textMarca.setEditable(false);
			btnEliminar.requestFocus();
		}else{
			textCodigo.requestFocus();
			JOptionPane.showMessageDialog(getContentPane(), "El producto no se encuentra dado de alta.","", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (EliminarProducto.class.getResource("/Images/information.png")));
		}
	}
	
	private void obtenerDirectorios() {
		//SETEO LOS DIRECTORIOS ACTUALES
		pathActualCodBarra = MapperPreferencias.selectValuePreferencia("Codigos de Barra");
	}
}

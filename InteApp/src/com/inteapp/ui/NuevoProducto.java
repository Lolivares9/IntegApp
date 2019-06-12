package com.inteapp.ui;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import mappers.MapperPreferencias;
import negocio.Marca;
import controller.ControladorMarcas;
import controller.ControladorProductos;
import services.CodeBarGenerator;
import views.ProductoView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;

import java.awt.Toolkit;

public class NuevoProducto extends javax.swing.JFrame{
	private static final long serialVersionUID = 7337044116767570123L;
	private JTextField textCodigo;
	private JTextField textDescripcion;
	private JTextField textPrecio;
	private JTextField textCosto;
	private JLabel lblCodigo;  
	private JLabel lblDescripcion;
	private JLabel lblPrecio; 
	private JLabel lblCosto;
	private JLabel pnlCodigo;
	private JButton btnCrear;
	private JButton btnCancelar;
	private String pathActualCodBarra;
	private JLabel lblMarca;
	private JComboBox<String> comboBoxMarca;
	private JLayeredPane lyrdCod;
	private JTextField txtStock;
	private CodeBarGenerator cbg;
	public NuevoProducto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoProducto.class.getResource("/Images/IconoVentana.png")));
		setResizable(false);
		setTitle("Nuevo Producto");
		this.setSize(500, 320);
		getContentPane().setLayout(null);
		
		obtenerDirectorios();
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 23, 78, 22);
		getContentPane().add(lblCodigo);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 89, 97, 22);
		getContentPane().add(lblDescripcion);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(42, 159, 44, 22);
		getContentPane().add(lblPrecio);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(146, 159, 39, 22);
		getContentPane().add(lblCosto);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(82, 24, 164, 20);
		getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(82, 90, 164, 20);
		getContentPane().add(textDescripcion);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(87, 160, 49, 20);
		getContentPane().add(textPrecio);
		
		textCosto = new JTextField();
		textCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCrear.doClick();
				}
			}
		});
		textCosto.setColumns(10);
		textCosto.setBounds(192, 160, 49, 20);
		getContentPane().add(textCosto);
		
		lyrdCod = new JLayeredPane();
		lyrdCod.setToolTipText("");
		lyrdCod.setBorder(new LineBorder(Color.GRAY));
		lyrdCod.setBounds(256, 35, 204, 97);
		getContentPane().add(lyrdCod);
		
		String codigo = Long.toString(ControladorProductos.getInstance().getCodigoProducto() + 1);
		textCodigo.setText(codigo);
		textCodigo.setEditable(false);
		cbg = new CodeBarGenerator();
		BufferedImage im = cbg.generarCodigo(textCodigo.getText());
		ImageIcon img = new ImageIcon(im);
		pnlCodigo = new JLabel(img);
		pnlCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCodigo.setBounds(10, 11, 184, 76);
		lyrdCod.add(pnlCodigo);
		pnlCodigo.setBackground(Color.WHITE);
		btnCrear = new JButton("Crear");
		btnCrear.setIcon(new ImageIcon(NuevoProducto.class.getResource("/Images/ZapatoNuevo.png")));
		btnCrear.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnCrear.doClick();
				}
			}
		});
		
		
		JLabel lblStock = new JLabel("<html><p align=\"center\">Stock<br><p align=\"center\">Disponible</p></html>");
		lblStock.setBounds(8, 122, 78, 26);
		getContentPane().add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(82, 122, 49, 20);
		getContentPane().add(txtStock);
		txtStock.setText("1");
		txtStock.selectAll();
		
		//ACCIÓN BOTON CREAR
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textDescripcion.getText().equals("") && (!textPrecio.getText().equals("")  &&  (textPrecio.getText().matches("[0-9]*+[.]+[0-9]*")|| textPrecio.getText().matches("[0-9]*"))) && (
						!textCosto.getText().equals("")	 && (textCosto.getText().matches("[0-9]*+[.]+[0-9]*") || textCosto.getText().matches("[0-9]*")))){
					Marca marca = new Marca (comboBoxMarca.getSelectedItem().toString());
					ProductoView p = new ProductoView(textCodigo.getText(), marca ,textDescripcion.getText(), Float.parseFloat(textPrecio.getText()), Float.parseFloat(textCosto.getText()), Integer.parseInt(txtStock.getText()));
					Boolean creado = ControladorProductos.getInstance().AltaProducto(p);
					if (creado){
						File outputFile = new File(pathActualCodBarra + "\\" + p.getMarca().getNombre() + " - " + p.getDescripcion().replace("/", "-") +  ".jpg");
						try {
							cbg.generate(outputFile, textCodigo.getText());
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(getContentPane(), "Error al generar el codigo de barras: " + e1.getMessage() ,"Error",JOptionPane.ERROR_MESSAGE, new ImageIcon (NuevoProducto.class.getResource("/Images/ok.png")));
						}
						dispose();
					}
					else{
						textDescripcion.requestFocus();
						textDescripcion.selectAll();
					}
				}
				else if (textDescripcion.getText().equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "Debe completar la descripcion del producto.","Descripcion vacia",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (NuevoProducto.class.getResource("/Images/information.png")));
				}
				else if (textPrecio.getText().equals("")  &&  (!textPrecio.getText().matches("[0-9]*+[.]+[0-9]*")|| !textPrecio.getText().matches("[0-9]*"))){
					JOptionPane.showMessageDialog(getContentPane(), "El precio debe estar completado, separando los centavos por un punto.","Precio incorrecto",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (NuevoProducto.class.getResource("/Images/information.png")));
				}
				else if (textCosto.getText().equals("")	 && (!textCosto.getText().matches("[0-9]*+[.]+[0-9]*") || !textCosto.getText().matches("[0-9]*"))){
					JOptionPane.showMessageDialog(getContentPane(), "El costo debe estar completado, separando los centavos por un punto.","Costo incorrecto",JOptionPane.INFORMATION_MESSAGE,new ImageIcon (NuevoProducto.class.getResource("/Images/information.png")));
				}
			}
		});
		btnCrear.setBounds(72, 210, 134, 49);
		getContentPane().add(btnCrear);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(NuevoProducto.class.getResource("/Images/Cancel.png")));
		btnCancelar.addKeyListener(new KeyAdapter() {
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
		btnCancelar.setBounds(252, 210, 134, 49);
		getContentPane().add(btnCancelar);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 56, 78, 22);
		getContentPane().add(lblMarca);
		
		comboBoxMarca = new JComboBox<String>();
		comboBoxMarca.setBounds(82, 56, 164, 20);
		getContentPane().add(comboBoxMarca);
		//CARGO EL COMBOBOX MARCA CON LAS MARCAS EXISTENTES
		ControladorMarcas.getInstance().cargarComboBoxMarca(comboBoxMarca);

	}

	private void obtenerDirectorios() {
		//SETEO LOS DIRECTORIOS ACTUALES
		pathActualCodBarra = MapperPreferencias.selectValuePreferencia("Codigos de Barra");
	}
	public void validarComboBox() {
		if (comboBoxMarca.getSelectedIndex() == -1){
			JOptionPane.showMessageDialog(getContentPane(), "No se encontraron marcas existentes","Marcas inexistentes", JOptionPane.INFORMATION_MESSAGE, new ImageIcon (NuevoProducto.class.getResource("/Images/warning.png")));
			dispose();
		}
	}
}

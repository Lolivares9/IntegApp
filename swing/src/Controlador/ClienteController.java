package Controlador;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelo.Cliente;
import Modelo.Cliente.Asociacion2;
import Modelo.ClienteTipo;
import Modelo.Actividad;
import Modelo.AptoMedico;
import Modelo.Socio;


public class ClienteController {

	private Vector<Cliente> clientes;
	private static ClienteController bc;
	private Vector<Asociacion2> asociaciones = new Vector<Asociacion2>();

	private ClienteController() {
		clientes = new Vector<Cliente>();
	}

	public static ClienteController getSingletonInstance() {
		if (bc == null) {
			bc = new ClienteController();
		}
		return bc;
	}

	public Vector<Cliente> getClientes() {
		return clientes;
	}

	public void AltaCliente(String codigo, String nombre, String precio, String vigencia, ClienteTipo tipo) {
		Cliente ab = new Cliente(codigo, nombre, precio, vigencia, tipo);
		clientes.add(ab);
	}

	public Cliente modificarCliente(String codigo) {
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo().compareTo(codigo) == 0) {
				return cliente;
			}
		}
		return null;
	}

	public void modificarCliente(String codigo, String nombre, String vigencia, String precio) {
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo().compareTo(codigo) == 0) {
				cliente.setVigencia(vigencia);
				cliente.setNombre(nombre);
				cliente.setCodigo(codigo);
				cliente.setPrecio(precio);
			}
		}
		boolean existe = false;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCodigo().compareTo(codigo) == 0) {
				existe = true;
				clientes.get(i).setVigencia(vigencia);
				clientes.get(i).setNombre(nombre);
				clientes.get(i).setCodigo(codigo);
				clientes.get(i).setPrecio(precio);
			}
		}
		if (!existe)
			JOptionPane.showMessageDialog(null, "No se encontró el usuario", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);
	}

		public void BajaCliente(String codigo) {
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo().compareTo(codigo) == 0) {
				clientes.remove(cliente);
			}
		}
	}

	public void Asociar(Cliente a, Socio s) {
		Cliente.getPair().add(a,s);
		Asociacion2 asociar = new Asociacion2(a, s);
		asociar.Asociar(a, s);
	}

	public static ClienteController getBc() {
		return bc;
	}

	public static void setBc(ClienteController bc) {
		ClienteController.bc = bc;
	}

	public Vector<Asociacion2> getAsociaciones() {
		return asociaciones;
	}

	public void setAsociaciones(Vector<Asociacion2> asociaciones) {
		this.asociaciones = asociaciones;
	}

	public void setClientes(Vector<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
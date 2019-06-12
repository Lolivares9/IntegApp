package Controlador;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelo.Abono;
import Modelo.Abono.Asociacion2;
import Modelo.AbonoTipo;
import Modelo.Actividad;
import Modelo.AptoMedico;
import Modelo.Socio;


public class AbonoController {

	private Vector<Abono> abonos;
	private static AbonoController bc;
	private Vector<Asociacion2> asociaciones = new Vector<Asociacion2>();

	private AbonoController() {
		abonos = new Vector<Abono>();
	}

	public static AbonoController getSingletonInstance() {
		if (bc == null) {
			bc = new AbonoController();
		}
		return bc;
	}

	public Vector<Abono> getAbonos() {
		return abonos;
	}

	public void AltaAbono(String codigo, String nombre, String precio, String vigencia, AbonoTipo tipo) {
		Abono ab = new Abono(codigo, nombre, precio, vigencia, tipo);
		abonos.add(ab);
	}

	public Abono modificarAbono(String codigo) {
		for (Abono abono : abonos) {
			if (abono.getCodigo().compareTo(codigo) == 0) {
				return abono;
			}
		}
		return null;
	}

	public void modificarAbono(String codigo, String nombre, String vigencia, String precio) {
		for (Abono abono : abonos) {
			if (abono.getCodigo().compareTo(codigo) == 0) {
				abono.setVigencia(vigencia);
				abono.setNombre(nombre);
				abono.setCodigo(codigo);
				abono.setPrecio(precio);
			}
		}
		boolean existe = false;
		for (int i = 0; i < abonos.size(); i++) {
			if (abonos.get(i).getCodigo().compareTo(codigo) == 0) {
				existe = true;
				abonos.get(i).setVigencia(vigencia);
				abonos.get(i).setNombre(nombre);
				abonos.get(i).setCodigo(codigo);
				abonos.get(i).setPrecio(precio);
			}
		}
		if (!existe)
			JOptionPane.showMessageDialog(null, "No se encontró el usuario", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);
	}

		public void BajaAbono(String codigo) {
		for (Abono abono : abonos) {
			if (abono.getCodigo().compareTo(codigo) == 0) {
				abonos.remove(abono);
			}
		}
	}

	public void Asociar(Abono a, Socio s) {
		Abono.getPair().add(a,s);
		Asociacion2 asociar = new Asociacion2(a, s);
		asociar.Asociar(a, s);
	}

	public static AbonoController getBc() {
		return bc;
	}

	public static void setBc(AbonoController bc) {
		AbonoController.bc = bc;
	}

	public Vector<Asociacion2> getAsociaciones() {
		return asociaciones;
	}

	public void setAsociaciones(Vector<Asociacion2> asociaciones) {
		this.asociaciones = asociaciones;
	}

	public void setAbonos(Vector<Abono> abonos) {
		this.abonos = abonos;
	}
	
}
package Controlador;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelo.AptoMedico;
import Modelo.Socio;

public class SocioController {

	private Vector<Socio> socios;
	private static SocioController sc;

	private SocioController() {
		socios = new Vector<Socio>();
	}

	public static SocioController getSingletonInstance() {
		if (sc == null) {
			sc = new SocioController();
		}
		return sc;
	}

	public void AltaSocio(String nombre, String apellido, String domicilio, String telefono, String mail, String dni) {
		String fecha = null;
		String prof = null;
		String obs = null;
		Socio s = new Socio(nombre, apellido, domicilio, telefono, mail, dni);
		socios.add(s);
	}
	

	public AptoMedico AltaAptoMedico(String fecha, String prof, String obs) {
		AptoMedico a = new AptoMedico(fecha, prof, obs);
		return (a);
	}

	public Vector<Socio> getSocios() {
		return socios;
	}

	public Socio modificarSocio(String dni) {
		for (Socio socio : socios) {
			if (socio.getDni().compareTo(dni) == 0) {
				return socio;
			}
		}
		return null;
	}

		
	public void modificarSocio(String nombre, String apellido, String domicilio, String telefono, String mail, String dni) {
		for (Socio socio : socios) {
			if (socio.getDni().compareTo(dni) == 0) {
				socio.setApellido(apellido);
				socio.setNombre(nombre);
				socio.setDni(dni);
				socio.setDomicilio(domicilio);
				socio.setMail(mail);
				socio.setTelefono(telefono);
				
			}
		}
		
		
			   boolean existe=false;
			   for(int i=0;i<socios.size();i++){
			         if(socios.get(i).getDni().compareTo(dni) == 0){
			               existe=true;		                
			                socios.get(i).setApellido(apellido);
			                socios.get(i).setNombre(nombre);
			                socios.get(i).setDni(dni);
			                socios.get(i).setDomicilio(domicilio);
			                socios.get(i).setMail(mail);
			                socios.get(i).setTelefono(telefono);
			           }
			     }
			      if(!existe)
			          JOptionPane.showMessageDialog(null, "No se encontró el usuario","Error en la consulta",JOptionPane.ERROR_MESSAGE);
		}
	

	public void BajaSocio(String dni) {
		for (Socio socio : socios) {
			if (socio.getDni().compareTo(dni) == 0) {
				socios.remove(socio);
			}
		}

	}

	

}
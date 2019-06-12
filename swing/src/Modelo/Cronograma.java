package Modelo;

import java.util.Date;
import java.util.Vector;

public class Cronograma {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String mail;
	private String dni;
	 
	
	public static class Asociacion
	{
	    public Asociacion(Actividad a, Date fecha1, Date fecha2) {
			// TODO Auto-generated constructor stub
		}
		public Date HoraInicio; 
	    public Date HoraFin;  
	    public Vector<Actividad> actividades = new Vector<Actividad>(); 
	 };
	
	public Cronograma(String nombre, String apellido, String domicilio, String telefono, String mail, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.dni = dni;
	}
	

	public Cronograma() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return nombre +" "+ apellido;
	}
	
	

}

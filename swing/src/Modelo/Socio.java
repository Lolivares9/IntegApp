package Modelo;

import java.util.Date;
import java.util.Vector;

public class Socio {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String mail;
	private String dni;
	private Vector<AptoMedico> aptos = new Vector<AptoMedico>();
	private Vector<Abono> abonosA = new Vector<Abono>();
	private Vector<Actividad> actividadesA = new Vector<Actividad>();
	
	public Socio(String nombre, String apellido, String domicilio, String telefono, String mail, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.dni = dni;
	}

	public void GuardarApto(AptoMedico apto) {
		aptos.add(apto);
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

	public Vector<AptoMedico> getAptos() {
		return aptos;
	}

	public void setAptos(Vector<AptoMedico> aptos) {
		this.aptos = aptos;
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
	
	public void AddActividad(Actividad act){
		this.actividadesA.addElement(act);
	}
	
	public void AddAbono(Abono a){
		this.abonosA.addElement(a);
	}

	public Vector<Abono> getAbonosA() {
		return abonosA;
	}

	public void setAbonosA(Vector<Abono> abonosA) {
		this.abonosA = abonosA;
	}

	public Vector<Actividad> getActividadesA() {
		return actividadesA;
	}

	public void setActividadesA(Vector<Actividad> actividadesA) {
		this.actividadesA = actividadesA;
	}

}

package Controlador;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelo.Cliente;
import Modelo.ClienteTipo;
import Modelo.Actividad;
import Modelo.Actividad.Asociacion2;
import Modelo.AptoMedico;
import Modelo.Socio;
import Modelo.Cronograma.Asociacion;

public class ActividadController {

	private static CronogramaController act;
	private Vector<Actividad> actividades;
	private static ActividadController ac;
	private Vector<Asociacion2> asociaciones = new Vector<Asociacion2>();
	
	public static CronogramaController getAct() {
		return act;
	}

	public static void setAct(CronogramaController act) {
		ActividadController.act = act;
	}

	private	ActividadController() {
		actividades = new Vector<Actividad>();
		
	}
	
	public static ActividadController getSingletonInstance () {
		if (ac == null) {
			ac = new ActividadController();
		}
		return ac;
	}

	public void AltaActividad(String codigo, String titulo, String descripcion, String horariosni) {
		Actividad a = new Actividad(codigo, titulo, descripcion, horariosni);
		//a.GuardarActividad(AltaAptoMedico(fecha,prof,obs));
		actividades.add(a);
	}

	public Vector<Actividad> getActividad() {
		return actividades;
	}

	public void BajaActividad(String codigo) {
		 for (Actividad actividad : actividades){
			 if(actividad.getCodigo().compareTo(codigo)==0){
				 actividades.remove(actividad);			 
			 }
		 }
		
	}
	
	public Vector<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Vector<Actividad> actividades) {
		this.actividades = actividades;
	}

	public static ActividadController getAc() {
		return ac;
	}

	public static void setAc(ActividadController ac) {
		ActividadController.ac = ac;
	}

	public Vector<Asociacion2> getAsociaciones() {
		return asociaciones;
	}

	public void setAsociaciones(Vector<Asociacion2> asociaciones) {
		this.asociaciones = asociaciones;
	}

	public Actividad modificarActividad(String codigo) {
		for (Actividad actividad : actividades) {
			if (actividad.getCodigo().compareTo(codigo) == 0) {
				return actividad;
			}
		}
		return null;
	}


	public void modificarActividad (String codigo, String titulo, String descripcion, String horarios) {
		for (Actividad actividad : actividades) {
			if (actividad.getCodigo().compareTo(codigo) == 0) {
				actividad.setTitulo(titulo);
				actividad.setDescripcion(descripcion);
				actividad.setCodigo(codigo);
				actividad.setHorarios(horarios);
			}
		}
		boolean existe=false;
		   for(int i=0;i<actividades.size();i++){
		         if(actividades.get(i).getCodigo().compareTo(codigo) == 0){
		               existe=true;		                
		               actividades.get(i).setTitulo(titulo);
		               actividades.get(i).setDescripcion(descripcion);
		               actividades.get(i).setCodigo(codigo);
		               actividades.get(i).setHorarios(horarios);
		           }
		     }
		      if(!existe)
		          JOptionPane.showMessageDialog(null, "No se realizo la Modificacion","Error en la consulta",JOptionPane.ERROR_MESSAGE);
	}
	
	public void Asociar(Actividad a, Socio s){
		Asociacion2 asoc = new Asociacion2(a,s);
		asoc.Asociar(a,s);
	
	}
}
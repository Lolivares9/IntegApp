package Controlador;

import java.util.Date;
import java.util.Vector;

import Modelo.Actividad;
import Modelo.AptoMedico;
import Modelo.Cronograma;
import Modelo.Socio;
import Modelo.Cronograma.Asociacion;

public class CronogramaController {

	
	private static CronogramaController cc;
	private Vector<Asociacion> asociaciones = new Vector<Asociacion>();
	private	CronogramaController() {
		
	}
	
	public static CronogramaController getSingletonInstance () {
		if (cc == null) {
			cc = new CronogramaController();
		}
		return cc;
	}

	
	public void AsociarActividad (Actividad a, Date fecha1, Date fecha2 ){
		
		Asociacion asoc = new Asociacion(a,fecha1, fecha2);
		asoc.HoraInicio=fecha1;	
		asoc.HoraFin=fecha2;
		asociaciones.add(asoc);			
		
	}

	public static CronogramaController getCc() {
		return cc;
	}

	public static void setCc(CronogramaController cc) {
		CronogramaController.cc = cc;
	}

	public Vector<Asociacion> getAsociaciones() {
		return asociaciones;
	}

	public void setAsociaciones(Vector<Asociacion> asociaciones) {
		this.asociaciones = asociaciones;
	}

	
	
}
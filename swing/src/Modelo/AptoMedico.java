package Modelo;

import java.util.Date;

public class AptoMedico {
	private String fechaCerti;
	private String profesional;
	private String observaciones;

	public AptoMedico(String fecha, String prof, String obs) {
		this.fechaCerti = fecha;
		this.profesional = prof;
		this.observaciones = obs;
	}

	public String getFechaCerti() {
		return fechaCerti;
	}

	public void setFechaCerti(String fechaCerti) {
		this.fechaCerti = fechaCerti;
	}

	public String getProfesional() {
		return profesional;
	}

	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
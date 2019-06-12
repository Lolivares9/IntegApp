package Modelo;

import java.util.Vector;

import org.javatuples.Pair;
import org.javatuples.Tuple;

public class Actividad {
	private String codigo;
	private String titulo;
	private String descripcion;
	private String horarios;
	public static Pair<Actividad,Socio> pair;
	public static class Asociacion2
	{
	    public Asociacion2(Actividad a, Socio s) {
	    	
	    	
		}
	    public void Asociar(Actividad a, Socio s) {
	    		
	    	pair.add(a,s);
		}	    
	};
	
	public static Pair<Actividad, Socio> getPair() {
		return pair;
	}

	public static void setPair(Pair<Actividad, Socio> pair) {
		Actividad.pair = pair;
	}

	public Actividad(String codigo, String titulo, String descripcion, String horarios) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.horarios = horarios;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public String toString() {
		return titulo;
	}

}

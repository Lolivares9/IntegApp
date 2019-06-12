package Modelo;

import java.util.Date;
import java.util.Vector;

import org.javatuples.Pair;

public class Abono {
	private String codigo;
	private String nombre;
	private String precio;
	private String vigencia;
	private AbonoTipo tipo;
	public static Pair<Abono,Socio> pair;
	
	public static class Asociacion2
	{
	    public Asociacion2(Abono a, Socio s) {
	    		    	
		}
	    public void Asociar(Abono a, Socio s) {
	    	pair.add(a,s);
		}
	};
	
	
	
	public static Pair<Abono, Socio> getPair() {
		return pair;
	}

	public static void setPair(Pair<Abono, Socio> pair) {
		Abono.pair = pair;
	}

	public Abono(String codigo, String nombre, String precio, String vigencia, AbonoTipo tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.vigencia = vigencia;
		this.tipo = tipo;
	}
	
	public void Modificar (String codigo, String nombre, String precio, String vigencia, AbonoTipo tipo) {
		if (this.codigo == codigo)
		{
			this.nombre = nombre;
			this.precio = precio;
			this.vigencia = vigencia;
			this.tipo = tipo;
		}
		else
		{
			//Ver como devolver un error y no realizar la modicacion.
		}
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public AbonoTipo getTipo() {
		return tipo;
	}

	public void setTipo(AbonoTipo tipo) {
		this.tipo = tipo;
	}

	public void Baja (int codigo) {
		//ver baja
	}
	public String toString() {
		return nombre +" $"+ precio;
	}
	
}


package Modelo;

import java.util.Date;
import java.util.Vector;

import org.javatuples.Pair;

public class Cliente {
	private String codigo;
	private String nombre;
	private String precio;
	private String vigencia;
	private ClienteTipo tipo;
	public static Pair<Cliente,Socio> pair;
	
	public static class Asociacion2
	{
	    public Asociacion2(Cliente a, Socio s) {
	    		    	
		}
	    public void Asociar(Cliente a, Socio s) {
	    	pair.add(a,s);
		}
	};
	
	
	
	public static Pair<Cliente, Socio> getPair() {
		return pair;
	}

	public static void setPair(Pair<Cliente, Socio> pair) {
		Cliente.pair = pair;
	}

	public Cliente(String codigo, String nombre, String precio, String vigencia, ClienteTipo tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.vigencia = vigencia;
		this.tipo = tipo;
	}
	
	public void Modificar (String codigo, String nombre, String precio, String vigencia, ClienteTipo tipo) {
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

	public ClienteTipo getTipo() {
		return tipo;
	}

	public void setTipo(ClienteTipo tipo) {
		this.tipo = tipo;
	}

	public void Baja (int codigo) {
		//ver baja
	}
	public String toString() {
		return nombre +" $"+ precio;
	}
	
}


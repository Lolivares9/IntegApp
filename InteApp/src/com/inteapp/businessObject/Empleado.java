package com.inteapp.businessObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inteapp.entities.EmpleadoEntity;

public class Empleado {
	
	private Integer idCliente;
	//Datos personales
	private String cuil;
	private String nombre;
	private String apellido;
	private String direccion;
	private String mail; 
	private String telefono;
	
	//Datos laborales
	private String tipoLiquidacion;
	private int vacacionesDisp;
	private int diasEstudioDisp;
	private boolean convenio;
	private Rubro rubro;
	private Categoria categoriaVigente;
	private float salario;
	private List<Novedad> novedades;
	private List<Liquidacion> liquidaciones;
	

	public Empleado(String cuil, String nombre, String apellido, String direccion, String mail, String telefono,
			String tipoLiquidacion, int vacacionesDisp, int diasEstudioDisp, boolean convenio, Rubro rubro,
			Categoria categoriaVigente, float salario, List<Novedad> novedades, List<Liquidacion> liquidaciones) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.tipoLiquidacion = tipoLiquidacion;
		this.vacacionesDisp = vacacionesDisp;
		this.diasEstudioDisp = diasEstudioDisp;
		this.convenio = convenio;
		this.rubro = rubro;
		this.categoriaVigente = categoriaVigente;
		this.salario = salario;
		this.novedades = novedades;
		this.liquidaciones = liquidaciones;
	}
	
	public void AltaNovedad(Novedad n) {
		this.novedades.add(n);
	}
	
	public void AltaLiquidacion (Liquidacion l){
		this.liquidaciones.add(l);	
	}
	
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoLiquidacion() {
		return tipoLiquidacion;
	}
	public void setTipoLiquidacion(String tipoLiquidacion) {
		this.tipoLiquidacion = tipoLiquidacion;
	}
	public int getVacacionesDisp() {
		return vacacionesDisp;
	}
	public void setVacacionesDisp(int vacacionesDisp) {
		this.vacacionesDisp = vacacionesDisp;
	}
	public int getDiasEstudioDisp() {
		return diasEstudioDisp;
	}
	public void setDiasEstudioDisp(int diasEstudioDisp) {
		this.diasEstudioDisp = diasEstudioDisp;
	}
	public boolean isConvenio() {
		return convenio;
	}
	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	public Categoria getCategoriaVigente() {
		return categoriaVigente;
	}
	public void setCategoria(Categoria categoriaVigente) {
		this.categoriaVigente = categoriaVigente;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public List<Novedad> getNovedades() {
		return novedades;
	}
	public void setNovedades(List<Novedad> novedades) {
		this.novedades = novedades;
	}
	public List<Liquidacion> getLiquidaciones() {
		return liquidaciones;
	}
	public void setLiquidaciones(List<Liquidacion> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}

	public EmpleadoEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void liquidarSueldo() {
		if (convenio == true ) {
			float sueldo = categoriaVigente.getSueldo();
			float sueldoBruto = 0;
			float sueldoNeto = 0;
			List<ItemRubro> itemsRubro = rubro.getItemsRubroObligatorios();
			
			cargarNovedadesItemsRubro(itemsRubro);
			List<ItemRubro> retribuciones = new ArrayList<ItemRubro>();
			List<ItemRubro> contribuciones = new ArrayList<ItemRubro>();
			
			separarItemsRubro (itemsRubro, retribuciones, contribuciones);
			
			sueldoBruto = calcularSueldoBruto(sueldo, retribuciones);
			sueldoNeto = calcularSueldoNeto(sueldoBruto, contribuciones);
			
			Liquidacion liq = new Liquidacion (itemsRubro, new Date(), new Date(), sueldoBruto, sueldoNeto);
			liquidaciones.add(liq);
		}
		else {
			
		}
	}

	private float calcularSueldoNeto(float sueldoBruto, List<ItemRubro> contribuciones) {
		float sueldoNeto = sueldoBruto; 
		for (ItemRubro it: contribuciones) {
			sueldoNeto = sueldoNeto - (sueldoBruto * (it.getPorcentaje()));
		}
		return sueldoNeto;
	}

	private float calcularSueldoBruto(float sueldo, List<ItemRubro> retribuciones) {
		float sueldoBruto = sueldo; 
		for (ItemRubro it: retribuciones) {
			sueldoBruto = sueldoBruto + (sueldo * (it.getPorcentaje()));
		}
		return sueldoBruto;
	}

	private void separarItemsRubro(List<ItemRubro> itemsRubro, List<ItemRubro> retribuciones,List<ItemRubro> contribuciones) {
		for (ItemRubro it : itemsRubro) {
			if (it.getConcepto().getSigno().equals("+")) {
				retribuciones.add(it);
			}
			else {
				contribuciones.add(it);
			}
		}	
	}

	private void cargarNovedadesItemsRubro(List<ItemRubro> itemsRubro) {
		ItemRubro it= null;
		for (Novedad n: novedades) {
			Concepto c = n.getConcepto();
			it = this.rubro.buscarItemRubro(c);
			if (it != null) {
				itemsRubro.add(it);
			}
		}
	}	
}

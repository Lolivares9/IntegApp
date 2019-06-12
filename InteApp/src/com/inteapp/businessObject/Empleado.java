package com.inteapp.businessObject;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.inteapp.entities.EmpleadoEntity;

public class Empleado {
	
	private Integer idEmpleado;
	//Datos personales
	private String cuil;
	private String nombre;
	private String apellido;
	private String direccion;
	private String mail; 
	private String telefono;
	
	//Datos laborales
	private Date fechaIngreso;
	private String tipoLiquidacion;
	private Date fechaUltimaLiquidacion;
	private Date fechaProximaLiquidacion;
	private int vacacionesDisp;
	private int diasEstudioDisp;
	private boolean convenio;
	private Rubro rubro;
	private Categoria categoriaVigente;
	private float salario;
	private List<Novedad> novedades;
	private List<Liquidacion> liquidaciones;
	

	public Empleado(String cuil, String nombre, String apellido, String direccion, String mail, String telefono, Date fechaIngreso,
			String tipoLiquidacion,Date fechaUltimaLiquidacion ,Date fechaProximaLiquidacion,  int vacacionesDisp, int diasEstudioDisp, boolean convenio, Rubro rubro,
			Categoria categoriaVigente, float salario, List<Novedad> novedades, List<Liquidacion> liquidaciones) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.fechaIngreso = fechaIngreso;
		this.tipoLiquidacion = tipoLiquidacion; 
		this.fechaUltimaLiquidacion = fechaUltimaLiquidacion;
		this.fechaProximaLiquidacion = fechaProximaLiquidacion;
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

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setCategoriaVigente(Categoria categoriaVigente) {
		this.categoriaVigente = categoriaVigente;
	}

	public EmpleadoEntity toEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Date getFechaUltimaLiquidacion() {
		return fechaUltimaLiquidacion;
	}

	public void setFechaUltimaLiquidacion(Date fechaUltimaLiquidacion) {
		this.fechaUltimaLiquidacion = fechaUltimaLiquidacion;
	}

	public Date getFechaProximaLiquidacion() {
		return fechaProximaLiquidacion;
	}

	public void setFechaProximaLiquidacion(Date fechaProximaLiquidacion) {
		this.fechaProximaLiquidacion = fechaProximaLiquidacion;
	}

	public void liquidarSueldo() {
		float sueldo = obtenerSueldo();
		
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		System.out.println("Fecha obten: " + today);
		
		if (today.compareTo(fechaProximaLiquidacion) >= 0) {
			
			//Liquidacion de sueldo normal
			float sueldoBruto = 0;
			float sueldoNeto = 0;
			int mes = cal.get(Calendar.MONTH);
			List<ItemRubro> itemsRubro = rubro.getItemsRubroObligatorios();
			
			cargarNovedadesItemsRubro(itemsRubro);
			
			if (mes == 5 ) {
				float antiguedadSemestre = calcularAntiguedadSemestre();
				Concepto c = new Concepto("SAC 1er Semestre", false, "+");
				ItemRubro it = new ItemRubro(c, (float) (0.5 * antiguedadSemestre / 180));
				itemsRubro.add(it);	
			}
			else if (mes == 11) {
				float antiguedadSemestre = calcularAntiguedadSemestre();
				Concepto c = new Concepto("SAC 2do Semestre", false, "+");
				ItemRubro it = new ItemRubro(c, (float) (0.5 * antiguedadSemestre / 180));
				itemsRubro.add(it);	
			}
			
			List<ItemRubro> retribuciones = new ArrayList<ItemRubro>();
			List<ItemRubro> contribuciones = new ArrayList<ItemRubro>();
			
			separarItemsRubro (itemsRubro, retribuciones, contribuciones);
			
			sueldoBruto = calcularSueldoBruto(sueldo, retribuciones);
			sueldoNeto = calcularSueldoNeto(sueldoBruto, contribuciones);
			
			Liquidacion liq = new Liquidacion (itemsRubro, new Date(0), new Date(0), sueldoBruto, sueldoNeto);
			liquidaciones.add(liq);
			

			imprimirLiquidacionEnConsola(sueldoBruto);
			actualizarProximaFechaLiquidacion();
			
		}
	}

	private float obtenerSueldo() {
		float sueldo = 0;
		if (convenio == true ) {
			sueldo = categoriaVigente.getSueldo();
		}
		else {
			sueldo = this.salario;
		}
		return sueldo;
	}

	private void imprimirLiquidacionEnConsola(float sueldoBruto) {
		//Impresion por Consola de la liquidacion del cliente 
		System.out.println("Cliente " + nombre + ": ");
		System.out.println("Fecha Ingreso: " + fechaIngreso);
		System.out.println("Fecha Ultima Liquidacion: " + fechaUltimaLiquidacion);
		System.out.println("Fecha Proxima Liquidacion: " + fechaProximaLiquidacion);
		for (Liquidacion l : liquidaciones){
			System.out.println("Liquidacion: ");
			System.out.println("Sueldo Bruto: " + l.getLiqBruta());
			System.out.println("Sueldo Neta: " + l.getLiqNeta());
			System.out.println("Conceptos: ");
			for (ItemRubro it: l.getItems()){
				System.out.println(it.getConcepto().getDescripcion() + " Porcentaje: " + it.getPorcentaje() + " $" + it.getPorcentaje() * sueldoBruto);
			}
		}
		System.out.println("");
		//Fin impresion liquidacion
	}

	private void actualizarProximaFechaLiquidacion() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaProximaLiquidacion);
		
		if (tipoLiquidacion.equals("MENSUAL")) {
			int anio = cal.get(Calendar.YEAR) ;
			int mes = cal.get(Calendar.MONTH);
			int ultimoDiaMes= cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
			cal.set(anio, mes + 1, ultimoDiaMes);
		}
		else if (tipoLiquidacion.equals("QUINCENAL")) {
			int ultimoDiaMes = 15;
			
			int anio = cal.get(Calendar.YEAR) ;
			int mes = cal.get(Calendar.MONTH);
			int dia = cal.get(Calendar.DAY_OF_MONTH);
			if (dia == 15) {
				ultimoDiaMes= cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			}else {
				mes = mes + 1;
			}
			cal.set(anio, mes, ultimoDiaMes);
		}
		else if (tipoLiquidacion.equals("SEMANAL")) {
			
			int anio = cal.get(Calendar.YEAR) ;
			int mes = cal.get(Calendar.MONTH);
			int dia = cal.get(Calendar.DAY_OF_MONTH);
			
			cal.set(anio, mes, dia + 7);
		}	
		else if (tipoLiquidacion.equals("DIARIO")) {			
			int anio = cal.get(Calendar.YEAR) ;
			int mes = cal.get(Calendar.MONTH);
			int dia = cal.get(Calendar.DAY_OF_MONTH);
			
			cal.set(anio, mes, dia + 1);
		}
		
		fechaUltimaLiquidacion = fechaProximaLiquidacion;
		fechaProximaLiquidacion = cal.getTime();
		
		//imprimo datos para verificar las nuevas fechas
		System.out.println("");
		System.out.println("\nNuevas Fechas de liquidacion:");
		System.out.println("Fecha Ultima Liquidacion: " + fechaUltimaLiquidacion);
		System.out.println("Fecha Proxima Liquidacion: " + fechaProximaLiquidacion);
	}

	private float calcularSueldoNeto(float sueldoBruto, List<ItemRubro> contribuciones) {
		float sueldoNeto = sueldoBruto; 
		for (ItemRubro it: contribuciones) {
			sueldoNeto = sueldoNeto - (sueldoBruto * (it.getPorcentaje()));
		}
		return sueldoNeto;
	}

	private float calcularSueldoBruto(float sueldo, List<ItemRubro> retribuciones) {
		float sueldoBruto = 0; 
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

	public void liquidacionFinal(boolean renuncia) {
		float sueldo = obtenerSueldo();
		
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		//System.out.println("Fecha obten: " + today);
		
		Long dateDiff = today.getTime() - fechaUltimaLiquidacion.getTime();
		int diasPendientesLiquidar = (int) (dateDiff / 1000 / 60 / 60 / 24);
		dateDiff = today.getTime() - fechaIngreso.getTime();
		float antiguedad = (float) (dateDiff / 1000 / 60 / 60 / 24/ 365);
		float antiguedadSemestre = calcularAntiguedadSemestre();
		
		float sueldoBruto = 0;
		float sueldoNeto = 0;
		List<ItemRubro> itemsRubro = rubro.getItemsRubroObligatorios();
		cargarNovedadesItemsRubro(itemsRubro);
		
		Concepto c = null;
		ItemRubro it = null;
		
		if(renuncia) {
			c = new Concepto("Vacaciones No Gozadas", false, "+");
			it = new ItemRubro(c, this.vacacionesDisp / 25);
			itemsRubro.add(it);	
			
			c = new Concepto("SAC Proporcional", false, "+");
			it = new ItemRubro(c, (float) (0.5 * antiguedadSemestre / 180));
			itemsRubro.add(it);
			
		}else {
			c = new Concepto("Antiguedad", false, "+");
			it = new ItemRubro(c, antiguedad);
			itemsRubro.add(it);
			
			c = new Concepto("Vacaciones No Gozadas", false, "+");
			it = new ItemRubro(c, this.vacacionesDisp / 25);
			itemsRubro.add(it);	
			
			c = new Concepto("SAC Proporcional", false, "+");
			it = new ItemRubro(c, (float) (0.5 * antiguedadSemestre / 180));
			itemsRubro.add(it);
		}
		
		List<ItemRubro> retribuciones = new ArrayList<ItemRubro>();
		List<ItemRubro> contribuciones = new ArrayList<ItemRubro>();
		
		separarItemsRubro (itemsRubro, retribuciones, contribuciones);
		
		for (ItemRubro item : retribuciones) {
			if (item.getConcepto().getDescripcion().equals("Sueldo Basico")) {
				item.setPorcentaje((float)diasPendientesLiquidar / 30);
				break;
			}
		}
		
		sueldoBruto = calcularSueldoBruto(sueldo, retribuciones);
		sueldoNeto = calcularSueldoNeto(sueldoBruto, contribuciones);
		
		Liquidacion liq = new Liquidacion (itemsRubro, new Date(0), new Date(0), sueldoBruto, sueldoNeto);
		liquidaciones.add(liq);
		imprimirLiquidacionEnConsola(sueldoBruto);
	}

	private float calcularAntiguedadSemestre() {
		float diasSemestre = 0;
		Calendar cal = Calendar.getInstance();	
		int mes = cal.get(Calendar.MONTH);
	
		if (mes <= 5) {
			diasSemestre = cal.get(Calendar.DAY_OF_YEAR);
		}
		else {
			diasSemestre = cal.get(Calendar.DAY_OF_YEAR) - 180;
		}
		return diasSemestre;
	}	
}

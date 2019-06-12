package com.inteapp.test;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Concepto;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.ItemRubro;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.businessObject.Novedad;
import com.inteapp.businessObject.Rubro;


public class Run {

	public static void main(String[] args) {
	
		Cliente cli = null;
		List<Empleado> empleados = new ArrayList<Empleado>();
		List<Novedad> novedades = new ArrayList<Novedad>();
		List<Novedad> novedades2 = new ArrayList<Novedad>();
		List<Novedad> novedades3 = new ArrayList<Novedad>();
		List<Liquidacion> liquidaciones = new ArrayList<Liquidacion>();
		List<Liquidacion> liquidaciones2 = new ArrayList<Liquidacion>();
		List<Liquidacion> liquidaciones3 = new ArrayList<Liquidacion>();
		List<ItemRubro> itemsRubros = new ArrayList<ItemRubro>();
		List<ItemRubro> itemsRubros2 = new ArrayList<ItemRubro>();
		List<ItemRubro> itemsRubros3 = new ArrayList<ItemRubro>();
		List<Categoria> categorias = new ArrayList<Categoria>();
		Novedad novedad1;
		Novedad novedad2;
		ItemRubro itemRubro1;
		ItemRubro itemRubro2;
		ItemRubro itemRubro3;
		ItemRubro itemRubro4;
		ItemRubro itemRubro5;
		ItemRubro itemRubro6;
		Concepto concepto1;
		Concepto concepto2;
		Concepto concepto3;
		Concepto concepto4;
		Concepto concepto5;
		Concepto concepto6;
		Rubro rubro;
		Rubro rubro2;
		Rubro rubro3;
		
		Categoria categoriaVigente;
		categoriaVigente = new Categoria("SENIOR",40000);
		categorias.add(categoriaVigente);
		
		concepto1 = new Concepto("Jubilacion",true,"-");
		concepto2 = new Concepto("Ley 19.032",true,"-");
		concepto3 = new Concepto("Obra Social",true,"-");
		concepto4 = new Concepto("Sueldo Basico",true,"+");
		concepto5 = new Concepto("Bono Desempeño",false,"+");
		concepto6 = new Concepto("Licencia Vacaciones",false,"+");
		
		itemRubro1 = new ItemRubro(concepto1,(float)0.11);
		itemRubro2 = new ItemRubro(concepto2,(float)0.03);
		itemRubro3 = new ItemRubro(concepto3,(float)0.03);
		itemRubro4 = new ItemRubro(concepto4,(float)1);
		itemRubro5 = new ItemRubro(concepto5,(float)0.5);
		itemRubro6 = new ItemRubro(concepto6,(float)0.11);
		
		itemsRubros.add(itemRubro1);
		itemsRubros.add(itemRubro2);
		itemsRubros.add(itemRubro3);
		itemsRubros.add(itemRubro4);
		itemsRubros.add(itemRubro6);
		
		itemsRubros2.add(itemRubro5);
		itemsRubros2.add(itemRubro1);
		itemsRubros2.add(itemRubro2);
		itemsRubros2.add(itemRubro3);
		itemsRubros2.add(itemRubro4);
		itemsRubros2.add(itemRubro6);
		
		itemsRubros3.add(itemRubro1);
		itemsRubros3.add(itemRubro2);
		itemsRubros3.add(itemRubro3);
		itemsRubros3.add(itemRubro4);
		itemsRubros3.add(itemRubro6);
		
		rubro =  new Rubro("Informatica","S",itemsRubros);
		rubro2 =  new Rubro("Bancario","S",itemsRubros2);
		rubro3 =  new Rubro("Fuera de Convenio","S",itemsRubros3);
		
		novedad1 = new Novedad(new Date(0),concepto5,1);
		novedad2 = new Novedad(new Date(0),concepto6,15);
		
		novedades.add(novedad2);
		novedades2.add(novedad1);
		
		Empleado empleado1;
		Empleado empleado2;
		Empleado empleado3;
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(2009, 7, 30,0,0,0);
		Date date = (Date)cal.getTime() ;// get back a Date object
		
		cal.set(2019, 4, 31,0,0,0);
		Date fechaUltLiq = (Date)cal.getTime() ;
		
		cal.set(2019, 5, 30, 0,0,0);
		Date fechaProxLiq = (Date)cal.getTime() ;
		
		cal.set(2019, 4, 31, 0,0,0);
		Date fechaProxLiq2 = (Date)cal.getTime() ;
		
		empleado1 = new Empleado("30391558486","Matias","Boccardo","Avenida Belgrano 3629","mati_boc@gmail.com",
				"11562592",date , "MENSUAL",fechaUltLiq, fechaProxLiq, 15,15,true,rubro,categoriaVigente,40000,novedades,liquidaciones);
		
		empleado2 = new Empleado("30391558486","Lautaro","Boccardo","Avenida Belgrano 3629","mati_boc@gmail.com",
				"11562592",date , "MENSUAL",fechaUltLiq, fechaProxLiq, 15,15,true,rubro2,categoriaVigente,40000,novedades2,liquidaciones2);
		
		empleado3 = new Empleado("30391558486","Cristian","Boccardo","Avenida Belgrano 3629","mati_boc@gmail.com",
				"11562592",date , "SEMANAL", fechaUltLiq,  fechaProxLiq2, 15,15,false,rubro3,null,40000,novedades3,liquidaciones3);
		

		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		
		cli = new Cliente("Accenture","30391558486","Avenida Belgrano 3629","Argentina, Bs As","acc@gmail.com","11562592","J",empleados);
		//cli.liquidarEmpleados();

		empleado3.liquidacionFinal(false);
		
//		Escala esc = new Escala(null,null,categorias);
//		
//		EscalaDAO es = EscalaDAO.getInstancia();
//		
		//es.guardar(esc);
		//esc = es.buscarEscala(1);
		//esc.getCategorias().get(0).setSueldo(2000);
		//esc.save();
		//EscalaDAO.getInstancia().eliminarEscala(esc);
		
	}

}

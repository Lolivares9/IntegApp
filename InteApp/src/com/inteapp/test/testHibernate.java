package com.inteapp.test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Concepto;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.ItemRubro;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.businessObject.Novedad;
import com.inteapp.businessObject.Rubro;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.dao.RubroDAO;
import com.inteapp.entities.*;
import com.inteapp.hibernate.HibernateUtil;

public class testHibernate {
	public static void main(String[] args) {
		ClienteEntity cli = new ClienteEntity();
		List<EmpleadoEntity> empleados = new ArrayList<EmpleadoEntity>();
		List<NovedadEntity> novedades = new ArrayList<NovedadEntity>();
		List<NovedadEntity> novedades2 = new ArrayList<NovedadEntity>();
		List<LiquidacionEntity> liquidaciones = new ArrayList<LiquidacionEntity>();
		List<ItemRubroEntity> itemsRubros = new ArrayList<ItemRubroEntity>();
		List<ItemRubroEntity> itemsRubros2 = new ArrayList<ItemRubroEntity>();
		List<ItemRubroEntity> itemsRubros3 = new ArrayList<ItemRubroEntity>();
		List<CategoriaEntity> categorias = new ArrayList<CategoriaEntity>();
		
		NovedadEntity novedad1 = new NovedadEntity();
		NovedadEntity novedad2 = new NovedadEntity();
		ItemRubroEntity itemRubro1 = new ItemRubroEntity();
		ItemRubroEntity itemRubro2 = new ItemRubroEntity();
		ConceptoEntity concepto1 = new ConceptoEntity();
		ConceptoEntity concepto2 = new ConceptoEntity();
		RubroEntity rubro = new RubroEntity();
		CategoriaEntity categoriaVigente = new CategoriaEntity();
		EmpleadoEntity empleado1 = new EmpleadoEntity();
		List<EscalaEntity> escalas = new ArrayList<EscalaEntity>();
		EscalaEntity escala = new EscalaEntity();
		
		categoriaVigente.setCategoria("SENIOR");
		categoriaVigente.setSueldo(400000);
		
		categorias.add(categoriaVigente);
		escala.setCategorias(categorias);
		escala.setVigenciaDesde(new Date(0));
		escala.setVigenciaHasta(new Date(0));
		escala.setRubro(null);
		escalas.add(escala);
		
		concepto1.setBasico(true);
		concepto1.setDescripcion("JUBILACION");
		concepto1.setSigno("-");
		concepto2.setBasico(true);
		concepto2.setDescripcion("LEY 19.032");
		concepto2.setSigno("-");
		
		itemRubro1.setConcepto(concepto1);
		itemRubro1.setPorcentaje((float)0.11);
		itemRubro2.setConcepto(concepto2);
		itemRubro2.setPorcentaje((float)0.03);
		
		itemsRubros.add(itemRubro1);
		itemsRubros.add(itemRubro2);
		
		itemsRubros2.add(itemRubro1);
		itemsRubros2.add(itemRubro2);
		
		itemsRubros3.add(itemRubro1);
		itemsRubros3.add(itemRubro2);
		
		rubro.setConvenio("S");
		rubro.setItemsRubro(itemsRubros);
		rubro.setNombre("INFORMATICA");
		rubro.setEscalas(escalas);
		

		
		novedad1.setCantDias(1);
		novedad1.setConcepto(concepto1);
		novedad1.setFechaNovedad(new Date(0));
		
		novedad2.setCantDias(15);
		novedad2.setConcepto(concepto2);
		novedad2.setFechaNovedad(new Date(0));
		
		novedades.add(novedad2);
		novedades2.add(novedad1);
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(2009, 7, 30,0,0,0);
		Date date = (Date)cal.getTime() ;// get back a Date object
		
		cal.set(2019, 4, 31,0,0,0);
		Date fechaUltLiq = (Date)cal.getTime() ;
		
		cal.set(2019, 5, 30, 0,0,0);
		Date fechaProxLiq = (Date)cal.getTime() ;
		
		
		empleado1.setCuil("30391558486");
		empleado1.setNombre("Matias");
		empleado1.setApellido("Boccardo");
		empleado1.setDireccion("Avenida Belgrano 3629");
		empleado1.setMail("mati_boc@gmail.com");
		empleado1.setTelefono("11562592");
		empleado1.setFechaIngreso(date);
		empleado1.setTipoLiquidacion("MENSUAL");
		empleado1.setFechaUltLiq(fechaUltLiq);
		empleado1.setFechaProxLiq(fechaProxLiq);
		empleado1.setDiasEstudioDisp(15);
		empleado1.setVacacionesDisp(15);
		empleado1.setPerteneceConvenio(true);
		empleado1.setRubro(rubro);
		empleado1.setCategoria(categoriaVigente);
		empleado1.setSalario(400000);
		empleado1.setNovedades(novedades);
		empleado1.setLiquidaciones(liquidaciones);
		empleado1.setNovedades(null);
		empleado1.setLiquidaciones(null);
		empleados.add(empleado1);
		
		cli.setRazonSocial("Accenture");
		cli.setCuit("30391558486");
		cli.setDireccion("Avenida Belgrano 3629");
		cli.setMail("acc@gmail.com");
		cli.setLocalidad("Argentina, Bs As");
		cli.setTelefono("11562592");
		cli.setTipoPersona("J");
		cli.setEmpleados(empleados);
		//ClienteDAO.getInstancia().guardarEntity(cli);
/*---------------------------------------------------------------------------*/		
		
		
		
		List<EscalaEntity> escalasRubro = new ArrayList<EscalaEntity>();
		List<CategoriaEntity> categoriasRubro = new ArrayList<CategoriaEntity>();
		itemsRubros = new ArrayList<ItemRubroEntity>();
		itemRubro1 = new ItemRubroEntity();
		itemRubro2 = new ItemRubroEntity();
		itemRubro1.setConcepto(concepto1);
		itemRubro1.setPorcentaje((float)0.11);
		itemRubro2.setConcepto(concepto2);
		itemRubro2.setPorcentaje((float)0.03);
		itemsRubros.add(itemRubro1);
		itemsRubros.add(itemRubro2);
		CategoriaEntity categoriaRubro = new CategoriaEntity();
		categoriaRubro.setSueldo(4000);
		categoriaRubro.setCategoria("SENIOR");
		categoriasRubro.add(categoriaRubro);
		EscalaEntity escalaRubro = new EscalaEntity();
		escalaRubro.setCategorias(categoriasRubro);
		escalaRubro.setVigenciaDesde(new Date(0));
		escalaRubro.setVigenciaHasta(new Date(0));
		escalasRubro.add(escalaRubro);
		RubroEntity r = new RubroEntity();
		r.setConvenio("SI");
		r.setEscalas(escalasRubro);
		r.setNombre("JUB");
		r.setItemsRubro(itemsRubros);
		RubroDAO.getInstancia().guardar(r);
		
		/*
		 
		 	public void guardarEntity(ClienteEntity cli) {
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session s = sf.openSession();
				
				s.beginTransaction();
				s.saveOrUpdate(cli);
				s.getTransaction().commit();
				s.close();
			}
		 
		 
		 
		empleado2 = new Empleado("30391558486","Lautaro","Boccardo","Avenida Belgrano 3629","mati_boc@gmail.com",
				"11562592",date , "MENSUAL",fechaUltLiq, fechaProxLiq, 15,15,true,rubro2,categoriaVigente,40000,novedades2,liquidaciones2);
		
		empleado3 = new Empleado("30391558486","Cristian","Boccardo","Avenida Belgrano 3629","mati_boc@gmail.com",
				"11562592",date , "SEMANAL", fechaUltLiq,  fechaProxLiq2, 15,15,false,rubro3,null,40000,novedades3,liquidaciones3);
		

		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		
		cli = new Cliente(,,,,,,,);
		cli.liquidarEmpleados();*/
	}
	
	
}

package com.inteapp.test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.inteapp.dao.ClienteDAO;
import com.inteapp.entities.*;

public class testHibernateFinal {

	public static void main(String[] args) {
		ClienteEntity cli = new ClienteEntity();
		List<EmpleadoEntity> empleados = new ArrayList<EmpleadoEntity>();
		List<NovedadEntity> novedades = new ArrayList<NovedadEntity>();
		List<NovedadEntity> novedades2 = new ArrayList<NovedadEntity>();
		List<LiquidacionEntity> liquidaciones = new ArrayList<LiquidacionEntity>();
		List<ItemRubroEntity> itemsRubros = new ArrayList<ItemRubroEntity>();
		List<CategoriaEntity> categorias = new ArrayList<CategoriaEntity>();
		List<EscalaEntity> escalasRubro = new ArrayList<EscalaEntity>();
		List<CategoriaEntity> categoriasRubro = new ArrayList<CategoriaEntity>();
		EmpleadoEntity empleado1 = new EmpleadoEntity();
		ItemRubroEntity itemRubro1 = new ItemRubroEntity();
		ItemRubroEntity itemRubro2 = new ItemRubroEntity();
		LiquidacionEntity liquidacion = new LiquidacionEntity();
		NovedadEntity novedad = new NovedadEntity();
		itemsRubros = new ArrayList<ItemRubroEntity>();
		itemRubro1 = new ItemRubroEntity();
		itemRubro2 = new ItemRubroEntity();
		ConceptoEntity concepto1 = new ConceptoEntity();
		ConceptoEntity concepto2 = new ConceptoEntity();
		

		CategoriaEntity categoriaRubro = new CategoriaEntity();
		
		EscalaEntity escalaRubro = new EscalaEntity();
		
		RubroEntity r = new RubroEntity();
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(2009, 7, 30,0,0,0);
		Date date = (Date)cal.getTime() ;// get back a Date object
		
		cal.set(2019, 4, 31,0,0,0);
		Date fechaUltLiq = (Date)cal.getTime() ;
		
		cal.set(2019, 5, 30, 0,0,0);
		Date fechaProxLiq = (Date)cal.getTime() ;
		
		/*--------------CATEGORIA--------------*/
		
		categoriaRubro.setSueldo(4000);
		categoriaRubro.setCategoria("SENIOR");
		categoriasRubro.add(categoriaRubro);
		
		/*--------------ESCALA--------------*/
		
		escalaRubro.setCategorias(categoriasRubro);
		escalaRubro.setVigenciaDesde(new Date(0));
		escalaRubro.setVigenciaHasta(new Date(0));
		escalasRubro.add(escalaRubro);
		
		/*--------------CONCEPTOS--------------*/
		concepto1.setBasico(true);
		concepto1.setDescripcion("JUBILACION");
		concepto1.setSigno("-");
		concepto2.setBasico(true);
		concepto2.setDescripcion("LEY 19.032");
		concepto2.setSigno("-");
			
		
		/*--------------ITEM RUBRO--------------*/
		itemRubro1.setConcepto(concepto1);
		itemRubro1.setPorcentaje((float)0.11);
		itemRubro2.setConcepto(concepto2);
		itemRubro2.setPorcentaje((float)0.03);
		itemRubro1.setLiquidacion(null);
		itemRubro2.setLiquidacion(null);
		itemsRubros.add(itemRubro1);
		itemsRubros.add(itemRubro2);

		/*--------------RUBRO--------------*/
		r.setConvenio("SI");
		r.setEscalas(escalasRubro);
		r.setNombre("JUB");
		r.setItemsRubro(itemsRubros);
		//empleado1.setRubro(r);
		
		/*--------------NOVEDADES--------------*/
		novedad.setCantDias(4);
		novedad.setConcepto(concepto1);
		novedad.setFechaNovedad(new Date(0));
		empleado1.setNovedades(novedades);
		
		/*--------------LIQUIDACIONES--------------*/
		liquidacion.setItemsRubro(itemsRubros);
		liquidacion.setFechaDesde(new Date(0));
		liquidacion.setFechaHasta(new Date(0));
		liquidacion.setItemsRubro(itemsRubros);
		liquidacion.setLiqBruta(4000);
		liquidacion.setLiqNeta(2000);
		liquidaciones.add(liquidacion);
		
		/*--------------EMPLEADO--------------*/
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
		//empleado1.setCategoria(categoriaRubro);
		empleado1.setSalario(400000);
		empleado1.setLiquidaciones(liquidaciones);//agregue
		empleados.add(empleado1);
		
		
		/*--------------CLIENTE--------------*/
		cli.setRazonSocial("Accenture");
		cli.setCuit("30391558486");
		cli.setDireccion("Avenida Belgrano 3629");
		cli.setMail("acc@gmail.com");
		cli.setLocalidad("Argentina, Bs As");
		cli.setTelefono("11562592");
		cli.setTipoPersona("J");
		cli.setEmpleados(empleados);
		ClienteDAO.getInstancia().guardarEntity(cli);

	}

}

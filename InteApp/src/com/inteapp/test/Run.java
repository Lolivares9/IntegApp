package com.inteapp.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.inteapp.businessObject.Categoria;
import com.inteapp.businessObject.Cliente;
import com.inteapp.businessObject.Concepto;
import com.inteapp.businessObject.Empleado;
import com.inteapp.businessObject.Escala;
import com.inteapp.businessObject.ItemRubro;
import com.inteapp.businessObject.Liquidacion;
import com.inteapp.businessObject.Novedad;
import com.inteapp.businessObject.Rubro;
import com.inteapp.dao.ClienteDAO;
import com.inteapp.dao.EscalaDAO;
import com.inteapp.entities.CategoriaEntity;
import com.inteapp.entities.ClienteEntity;
import com.inteapp.entities.EscalaEntity;
import com.inteapp.hibernate.HibernateUtil;

public class Run {

	public static void main(String[] args) {
		Cliente cli = null;
		List<Empleado> empleados = new ArrayList<Empleado>();
		List<Novedad> novedades = new ArrayList<Novedad>();
		List<Novedad> novedades2 = new ArrayList<Novedad>();
		List<Liquidacion> liquidaciones = new ArrayList<Liquidacion>();
		List<Liquidacion> liquidaciones2 = new ArrayList<Liquidacion>();
		List<ItemRubro> itemsRubros = new ArrayList<ItemRubro>();
		List<ItemRubro> itemsRubros2 = new ArrayList<ItemRubro>();
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
		Categoria categoriaVigente;
		categoriaVigente = new Categoria("SENIOR",40000);
		categorias.add(categoriaVigente);
		
		concepto1 = new Concepto("JUBILACION",true,"-");
		concepto2 = new Concepto("LEY 19.032",true,"-");
		concepto3 = new Concepto("OBRA SOCIAL",true,"-");
		concepto4 = new Concepto("SUELDO BASICO",true,"+");
		concepto5 = new Concepto("BONO DESEMPEÑO",false,"+");
		concepto6 = new Concepto("VACACIONES",false,"+");
		
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
		
		rubro =  new Rubro("INFORMATICA","S",itemsRubros);
		rubro2 =  new Rubro("BANCARIO","S",itemsRubros2);
		
		novedad1 = new Novedad(new Date(0),concepto5,1);
		novedad2 = new Novedad(new Date(0),concepto6,15);
		
		novedades.add(novedad2);
		novedades2.add(novedad1);
		
		Empleado empleado1;
		Empleado empleado2;
		
		empleado1 = new Empleado("Accenture","30391558486","Avenida Belgrano 3629","Argentina, Bs As",
				"acc@gmail.com","11562592","Mensual",15,15,true,rubro,categoriaVigente,40000,novedades,liquidaciones);
		empleado2 = new Empleado("Accenture","12312312","Avenida Belgran123329","Argentina, Bs As",
		
				"acc@gmail.com","11562592","Mensual",15,15,true,rubro2,categoriaVigente,40000,novedades2,liquidaciones2);
		
		empleados.add(empleado1);
		empleados.add(empleado2);
		
		cli = new Cliente("Accenture","30391558486","Avenida Belgrano 3629","Argentina, Bs As","acc@gmail.com","11562592","J",empleados);
		cli.liquidarEmpleados();


		
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

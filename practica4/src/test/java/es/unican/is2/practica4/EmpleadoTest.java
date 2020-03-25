/**
 * 
 */
package es.unican.is2.practica4;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.practica4.model.Empleado;
import es.unican.is2.practica4.model.Categoria;

/**
 * @author docencia
 *
 */
public class EmpleadoTest {

	private Empleado empleado; 
	/**
	 * Test method for {@link es.unican.is2.practica4.model.Empleado#Empleado(java.lang.String, java.time.LocalDate, es.unican.is2.practica4.model.Categoria)}.
	 */
	@Test
	public void testEmpleado() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.unican.is2.practica4.model.Empleado#darBaja()}.
	 */
	@Test
	public void testDarBaja() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.unican.is2.practica4.model.Empleado#sueldoBruto()}.
	 */
	@Test
	public void testSueldoBruto() {
		
		LocalDate current = java.time.LocalDate.now();
		
		empleado = new Empleado("Michael",current, Categoria.DIRECTIVO);
		empleado.baja = true;
		//1.DIRECTOR,TRUE,HOY
		empleado.sueldoBruto();
		
		//2.GESTOR,FALSE,HOY-3
		empleado.baja = false;
		empleado.categoria = Categoria.GESTOR;
		
		empleado.fechaContratacion = current.minusDays(3);
		empleado.sueldoBruto();
		
		//3.OBRERO,FALSE,HOY-5
		empleado.categoria=Categoria.OBRERO;
		empleado.fechaContratacion =  current.minusDays(5);
		empleado.sueldoBruto();
		
		//4.OBRERO,FALSE,HOY-7
		empleado.fechaContratacion =  current.minusDays(7);
		empleado.categoria = Categoria.DIRECTIVO;
		empleado.sueldoBruto();
		
		//5.GESTOR,TRUE,HOY-6
		empleado.baja=true;
		empleado.fechaContratacion =  current.minusDays(6);
		empleado.categoria = Categoria.GESTOR;
		empleado.sueldoBruto();
		
		//6.DIRECTOR,FALSE,HOY-10
		empleado.fechaContratacion = current.minusDays(10);
		empleado.baja=false;
		empleado.categoria = Categoria.DIRECTIVO;
		empleado.sueldoBruto();
		
		//7.GESTOR,FALSE,HOY-11
		empleado.categoria = Categoria.GESTOR;
		empleado.fechaContratacion =  current.minusDays(11);
		empleado.sueldoBruto();
		
		//8.OBRERO,TRUE,HOY-12
		empleado.categoria = Categoria.OBRERO;
		empleado.fechaContratacion =  current.minusDays(12);
		empleado.baja=true;
		empleado.sueldoBruto();
		
		//9.OBRERO,FALSE,HOY-20
		empleado.baja=false;
		empleado.fechaContratacion =  current.minusDays(20);
		empleado.sueldoBruto();
		
		//10.GESTOR,TRUE,HOY-22
		empleado.fechaContratacion =  current.minusDays(22);
		empleado.baja=true;
		empleado.categoria=Categoria.OBRERO;
		empleado.sueldoBruto();
		
		//11.GESTOR,FALSE,HOY-21
		empleado.fechaContratacion =  current.minusDays(21);
		empleado.baja=false;
		empleado.categoria=Categoria.GESTOR;
		empleado.sueldoBruto();
		
		//1.DIRECTOR,TRUE,HOY
		empleado.fechaContratacion =  current;
		empleado.baja=true;
		empleado.categoria=Categoria.DIRECTIVO;
		
		//2.NULL,TRUE,HOY
		empleado.categoria=null;
		
		//3.DIRECTOR,TRUE,MAÑANA
		empleado.fechaContratacion=current.plusDays(1);
		//4.DIRECTOR, TRUE, 
		
		
		
		
		
		fail("Not yet implemented");
		
		
	}


}

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
		empleado = new Empleado("Michael",LocalDate.parse("2009-12-31"), Categoria.DIRECTIVO);
		
		empleado = new Empleado("Michael", java.time.LocalDate.now(), Categoria.DIRECTIVO);
		empleado.darBaja();
				
		empleado.sueldoBruto(empleado)
		
		
		
		
		fail("Not yet implemented");
		
	}


}

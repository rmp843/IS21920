/**
 * 
 */
package es.unican.is2.practica4;

import static org.junit.Assert.*;
import es.unican.is2.practica4.model.DatoIncorrectoException;
import es.unican.is2.practica4.model.FechaIncorrectaException;
import es.unican.is2.practica4.model.CategoriaIncorrectaException;
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
	 * Test method for {@link es.unican.is2.practica4.model.Empleado#darBaja()}.
	 */
	@Test
	public void testDarBaja() {
		try {
			empleado = new Empleado("Michael",java.time.LocalDate.now(),Categoria.DIRECTIVO);
			empleado.baja = false;
			assert(empleado.darDeBaja());
			assert(!empleado.darDeBaja());
		}
		catch(Exception e) {
			fail("Fallo de excepción");
		}
	}

	/**
	 * Test method for {@link es.unican.is2.practica4.model.Empleado#sueldoBruto()}.
	 */
	@Test
	public void testSueldoBruto() {

		//CASOS CORRECTOS
		LocalDate current = java.time.LocalDate.now();

		try {
			empleado = new Empleado("Michael",current, Categoria.DIRECTIVO);
			empleado.baja = true;
			//1.DIRECTOR,TRUE,HOY
			assert(empleado.sueldoBruto() == 1125);
		}catch(Exception e) {
			fail("Ha habido un error en el método");
		}


		//2.GESTOR,FALSE,HOY-3
		try {
			empleado.baja = false;
			empleado.categoria = Categoria.GESTOR;

			empleado.fechaContratacion = current.minusYears(3);

			assert(empleado.sueldoBruto()==1200);
		}catch(Exception e) {
			fail("Ha habido un error en el método");
		}
		//3.OBRERO,FALSE,HOY-5
		try {
			empleado.categoria=Categoria.OBRERO;
			empleado.fechaContratacion =  current.minusYears(5);
			assert(empleado.sueldoBruto()==100);
		}catch(Exception e) {
			fail("Ha habido un error en el método");
		}

		//4.OBRERO,FALSE,HOY-7
		try{
			empleado.fechaContratacion =  current.minusYears(7);
			empleado.categoria = Categoria.DIRECTIVO;
			assert(empleado.sueldoBruto()==1550);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}
		//5.GESTOR,TRUE,HOY-6
		try {
			empleado.baja=true;
			empleado.fechaContratacion =  current.minusYears(6);
			empleado.categoria = Categoria.GESTOR;
			assert(empleado.sueldoBruto()==937.5);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}
		//6.DIRECTOR,FALSE,HOY-10
		try {
			empleado.fechaContratacion = current.minusYears(10);
			empleado.baja=false;
			empleado.categoria = Categoria.DIRECTIVO;
			assert(empleado.sueldoBruto()==1550);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");

		}
		//7.GESTOR,FALSE,HOY-11
		try {
			empleado.categoria = Categoria.GESTOR;
			empleado.fechaContratacion =  current.minusYears(11);
			assert(empleado.sueldoBruto()==1300);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}
		//8.OBRERO,TRUE,HOY-12
		try {
			empleado.categoria = Categoria.OBRERO;
			empleado.fechaContratacion =  current.minusYears(12);
			empleado.baja=true;
			assert(empleado.sueldoBruto()==150);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}
		//9.OBRERO,FALSE,HOY-20
		try {
			empleado.baja=false;
			empleado.fechaContratacion =  current.minusYears(20);
			assert(empleado.sueldoBruto()==200);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}

		//10.GESTOR,TRUE,HOY-22
		try {
			empleado.fechaContratacion =  current.minusYears(22);
			empleado.baja=true;
			empleado.categoria=Categoria.GESTOR;
			assert(empleado.sueldoBruto()==1050);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}
		//11.GESTOR,FALSE,HOY-21
		try {
			empleado.fechaContratacion =  current.minusYears(21);
			empleado.baja=false;
			empleado.categoria=Categoria.GESTOR;
			assert(empleado.sueldoBruto()==1400);
		}catch(Exception e) {
			fail("Ha habido un error en el metodo");
		}
		//CASOS FALLIDOS


		//1.SECRETARIO,TRUE,HOY
		try {
			empleado.categoria=Categoria.SECRETARIO;
			empleado.sueldoBruto();
			fail("Debería haber saltado excepción");
		}catch(CategoriaIncorrectaException e) {}

		//2.NULL,TRUE,HOY
		try {
			empleado.categoria=null;
			empleado.sueldoBruto();
			fail("Debería haber saltado excepción");
		}catch(Exception e) {

		}
		//3.DIRECTOR,TRUE,MAÑANA
		try {
			empleado.fechaContratacion=current.plusDays(1);
			empleado.sueldoBruto();
			fail("Deberia haber saltado la excepcion");
		}catch(FechaIncorrectaException e) {}

		//3.DIRECTOR,TRUE,DAY+2
		try {
			empleado.fechaContratacion=current.plusDays(2);
			empleado.sueldoBruto();
			fail("Deberia haber saltado la excepcion");
		}catch(FechaIncorrectaException e) {}


		//4.DIRECTOR, TRUE, NULL
		try {
			empleado.fechaContratacion=null; 
			empleado.sueldoBruto();
			fail("Debería haber saltado excepción");
		}catch(FechaIncorrectaException e) {}
	}


}

package es.unican.is2.practica4.model;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Empleado {

	public String nombre;
	public LocalDate fechaContratacion;
	public boolean baja;
	public Categoria categoria;

	public Empleado(String nombre, LocalDate fecha, Categoria categoria) {
		baja = false;
		this.categoria = categoria;
		fechaContratacion = fecha;
	}

	public double sueldoBruto() {



		//Si la fecha de contratación es mayor al día de hoy, o erronea lanzamos error
		if (fechaContratacion == null || fechaContratacion.isAfter(java.time.LocalDate.now())) {
			throw new FechaIncorrectaException();
		}
		int years = difYears(fechaContratacion,java.time.LocalDate.now());
		//Si la categoria es null lanzamos error
		if(categoria == null) {
			throw new DatoIncorrectoException();
		}
		double sueldo = 0;
		switch(categoria) {
		case DIRECTIVO:
			sueldo = 1500;
			break;
		case GESTOR:
			sueldo = 1200;
			break;
		case OBRERO:
			sueldo = 100;
			break;
		default:
			throw new CategoriaIncorrectaException();
		}
		//bonificacion para más de 5 años
		if(years > 5 && years <= 10) {
			sueldo+= 50;
		}
		//bonificación para más de 10 años
		else if(years > 10 && years <= 20) {
			sueldo+=100;
		}
		//bonificacion para más de 20 años
		else if(years > 20){
			sueldo+=200;
		}
		if(baja) {
			sueldo = sueldo - (sueldo*0.25); 
		}
		return sueldo;
	}


	public boolean darBaja() {
		if(!baja) {
			baja = true;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Devuelve la diferencia de años entre 2 fechas
	 * @param from
	 * @param to
	 * @return
	 */
	private int difYears(LocalDate from, LocalDate to) {
		Period period = Period.between(from, to);
		return period.getYears();
	}
}

package es.unican.is2.practica4.model;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Empleado {

	public String nombre;
	public LocalDate fechaContratacion;
	public boolean baja;
	public Categoria categoria;
	
	public Empleado(String nombre, LocalDate fechaUltimaVisita, Categoria categoria) {
		baja = false;
		this.categoria = categoria;
	}

	public double sueldoBruto() {
		int years = difYears(fechaContratacion,java.time.LocalDate.now());
		double sueldo = 0;
		switch(categoria) {
		case DIRECTIVO:
			sueldo = 1500;
		case GESTOR:
			sueldo = 1200;
		case OBRERO:
			sueldo = 1000;
		}
		if(years > 5 && years <= 10) {
			sueldo+= 50;
		}
		else if(years > 10 && years < 10) {
			sueldo+=100;
		}
		else {
			sueldo+=200;
		}
		return sueldo;
	}
	
	
	public void darBaja() {
		baja = true;
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

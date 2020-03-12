package es.unican.is2.practica4.model;

import java.util.ArrayList;

public class Empresa {

	public ArrayList<Empleado> empleados;
	public Empresa() {
	}

	/**
	 * Retorna el gasto de nominas total de las empresas
	 * @return
	 */
	public double gastoNominas(){
		double contador = 0;
		for(Empleado e: empleados) {
			contador+= e.sueldoBruto();
		}
		return contador;
	}
}

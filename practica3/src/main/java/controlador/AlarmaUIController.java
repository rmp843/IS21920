package controlador;


import javax.swing.JButton;
import javax.swing.JLabel;

import es.unican.is2.practica3.*;

public class AlarmaUIController {

	private AlarmaHogar alarma;
	private String codigo = "";
	
	public AlarmaUIController() {
		alarma = new AlarmaHogar();
	}
	
	public void encenderAlarma() {
		alarma.alarmaOn();
	}
	
	public void desactivarAlarma(){
		alarma.alarmaOff(codigo);
	}

	public void intrusoAlarma() {
		alarma.intruso();
	}
	
	public void offAlarma() {
		alarma.off();
	}
	
	/**
	 * Añade un digito al codigo introducido
	 */
	public void teclaPresionada(JButton b) {
		String numero = b.getText().toString();
		codigo = codigo + numero;
	}
	
	/**
	 * Muestra el codigo por pantalla
	 * @param lbl
	 */
	public void mostrarCodigo(JLabel etiqueta) {
		etiqueta.setText(codigo);
		
	}
	
	/**
	 * Borra el codigo de desactivacion.
	 */
	public void borrarCodigo() {
		codigo = "";
	}
	
	/**
	 * Devuelve el piloto
	 */
	public Piloto piloto() {
		return alarma.getPiloto();
	}
	
}
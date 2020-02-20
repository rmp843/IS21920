package es.unican.is2.practica3;

public class Piloto {
	PilotoEstado estado;
	enum PilotoEstado {ENCENDIDO, APAGADO, PARPADEANDO};
	
	public Piloto() {
		estado = PilotoEstado.APAGADO;
	}
	public void encender() {
		estado = PilotoEstado.ENCENDIDO;
	}
	public void apagar() {
		estado = PilotoEstado.APAGADO;
	}
	public void parpadear() {
		estado = PilotoEstado.PARPADEANDO;
	}
}

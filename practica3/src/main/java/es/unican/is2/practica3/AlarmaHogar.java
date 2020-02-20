package es.unican.is2.practica3;

public class AlarmaHogar {

	private AlarmaHogarState state;
	protected Piloto piloto = new Piloto();
	
	private int intervaloSalida;
	private int intervaloDesactivacion;
	private int codigoDesactivacion;
	private int errores;
	
	public AlarmaHogar() {
		state = AlarmaHogarState.init(this); 
	}
	public void setState(AlarmaHogarState value){
		this.state = value;     
	}      
	
	public int intervaloSalida() {
		return intervaloSalida;
	}
	public int intervaloDesactivacion() {
		return intervaloDesactivacion;
	}
	public int codigoDesactivacion() {
		return codigoDesactivacion;
	}
	public int errores() {
		return errores;
	}
	
	public void notificarCentralita() {
		state.notificarCentralita(this);
	}
	public void desactivarSensores() {
		state.desactivarSensores(this);
	}
	public void activarSensores() {
		state.activarSensores(this);
	}
	public void alarmaOff() {
		state.alarmaOff(this);
	}
	public void alarmaOn() {
		state.alarmaOn(this);
	}
	public void intruso() {
		state.intruso(this);
	}
	public void off() {
		state.off(this);
	}
}

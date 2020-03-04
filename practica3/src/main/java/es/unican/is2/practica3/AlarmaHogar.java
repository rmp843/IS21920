package es.unican.is2.practica3;

public class AlarmaHogar {

	private AlarmaHogarState state;
	protected Piloto piloto = new Piloto();
	
	private int intervaloSalida;
	private int intervaloDesactivacion;
	private String codigoDesactivacion;
	private int errores;
	
	public AlarmaHogar() {
		state = AlarmaHogarState.init(this); 
		codigoDesactivacion = "123";
		errores = 0;
		intervaloSalida = 10000;
		intervaloDesactivacion = 10000;
	}
	public void setState(AlarmaHogarState value){
		this.state = value;     
	}      
	
	public AlarmaHogarState getState() {
		return state;
	}
	public Piloto getPiloto() {
		return piloto;
	}
	public int intervaloSalida() {
		return intervaloSalida;
	}
	public int intervaloDesactivacion() {
		return intervaloDesactivacion;
	}
	public String codigoDesactivacion() {
		return codigoDesactivacion;
	}
	public int errores() {
		return errores;
	}
	public void addError() {
		errores++;
	}
	public void resetErrores() {
		errores = 0;
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
	public void alarmaOff(String codigo) {
		state.alarmaOff(this,codigo);
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

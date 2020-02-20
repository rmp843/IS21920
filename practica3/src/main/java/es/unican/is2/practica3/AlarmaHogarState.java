package es.unican.is2.practica3;

public abstract class AlarmaHogarState {
	private static Apagada estadoApagada = new Apagada();
	private static EsperandoSalida estadoEsperandoSalida = new EsperandoSalida();
	private static Encendida estadoEncendida = new Encendida();
	private static MovimientoDetectado estadoMovimientoDetectado = new MovimientoDetectado();
	private static IntrusoDetectado estadoIntrusoDetectado = new IntrusoDetectado();

	public static AlarmaHogarState init(AlarmaHogar context) {
		estadoApagada.entryAction(context);
		return estadoApagada;      
	}

	public void alarmaOff(AlarmaHogar context) {};
	public void alarmaOn(AlarmaHogar context) {};
	public void intruso(AlarmaHogar context) {};
	public void off(AlarmaHogar context) {};

	public void notificarCentralita(AlarmaHogar context) {};
	public void desactivarSensores(AlarmaHogar context) {};
	public void activarSensores(AlarmaHogar context) {};
	
	public void doAction(AlarmaHogar context) {}
	public void exitAction(AlarmaHogar context) {}
	public void entryAction(AlarmaHogar context) {}
	
	public static AlarmaHogarState getEstadoApagada(){
		return estadoApagada;     
	}
	public static AlarmaHogarState getEstadoEsperandoSalida(){
		return estadoEsperandoSalida;     
	}
	public static AlarmaHogarState getEstadoEncendida(){
		return estadoEncendida;     
	}
	public static AlarmaHogarState getEstadoMovimientoDetectado(){
		return estadoMovimientoDetectado;     
	}
	public static AlarmaHogarState getEstadoIntrusoDetectado(){
		return estadoIntrusoDetectado;     
	}


	

}

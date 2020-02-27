package es.unican.is2.practica3;

public class Encendida extends AlarmaHogarState{

	public void entryAction(AlarmaHogar context) {
		context.activarSensores();
		context.piloto.encender();
	}
	public void exitAction(AlarmaHogar context) {
		context.desactivarSensores();
	}

	public void Intruso(AlarmaHogar context) {
		this.exitAction(context);
		context.setState(getEstadoMovimientoDetectado());
		getEstadoMovimientoDetectado().entryAction(context);
		getEstadoMovimientoDetectado().doAction(context);
	}
}

package es.unican.is2.practica3;

public class Encendida extends AlarmaHogarState{

	public void entryAction(AlarmaHogar context) {
		System.out.println("ENCENDIDA");
		context.activarSensores();
		context.piloto.encender();
	}
	public void exitAction(AlarmaHogar context) {
		context.desactivarSensores();
	}

	@Override
	public void intruso(AlarmaHogar context) {
		System.out.println("Intentado intruso");
		this.exitAction(context);
		context.setState(getEstadoMovimientoDetectado());
		getEstadoMovimientoDetectado().entryAction(context);
		getEstadoMovimientoDetectado().doAction(context);
	}
}

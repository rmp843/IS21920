package es.unican.is2.practica3;

public class IntrusoDetectado extends AlarmaHogarState{

	public void entryAction(AlarmaHogar context) {
		System.out.println("INTRUSO DETECTADO");
		context.notificarCentralita();
	}
	public void exitAction(AlarmaHogar context) {}

	public void off(AlarmaHogar context) {
		this.exitAction(context);
		context.setState(getEstadoApagada());
		getEstadoApagada().entryAction(context);
		getEstadoApagada().doAction(context);
	}
}

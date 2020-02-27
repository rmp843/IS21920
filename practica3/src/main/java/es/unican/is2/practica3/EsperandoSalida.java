package es.unican.is2.practica3;

public class EsperandoSalida extends AlarmaHogarState implements TimedState{
	private final int intervaloSalida = 30000;
	public void entryAction(AlarmaHogar context) {
		getTimedStateController().startRelative(this,context, intervaloSalida);
	}

	public void exitAction(AlarmaHogar context)  {}

	public void alarmaOff(AlarmaHogar context, int codigo) {
		if(codigo == context.codigoDesactivacion()) {
			this.exitAction(context);
			context.setState(getEstadoApagada());
			getEstadoApagada().entryAction(context);
			getEstadoApagada().doAction(context);
		}
	}

	public void timeout(AlarmaHogar context) {
		this.exitAction(context);
		getEstadoEncendida().exitAction(context);
		getEstadoEncendida().doAction(context);
		context.setState(getEstadoEncendida());
	}
}


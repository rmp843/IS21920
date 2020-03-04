package es.unican.is2.practica3;

public class EsperandoSalida extends AlarmaHogarState implements TimedState{
	@Override
	public void entryAction(AlarmaHogar context) {
		getTimedStateController().startRelative(this,context, context.intervaloSalida());
		System.out.println("ESPERANDO SALIDA");
	}
	public void exitAction(AlarmaHogar context)  {}

	
	@Override
	public void alarmaOff(AlarmaHogar context,String codigo) {
		//Si el codigo es el mismo que el de desactivación, se apaga
		if(codigo.equals(context.codigoDesactivacion())) {
			getTimedStateController().cancel();
			this.exitAction(context);
			context.setState(getEstadoApagada());
			getEstadoApagada().entryAction(context);
			getEstadoApagada().doAction(context);
		}
	}

	@Override
	public void timeout(AlarmaHogar context) {
		System.out.println("Timeout");
		this.exitAction(context);
		getEstadoEncendida().entryAction(context);
		getEstadoEncendida().doAction(context);
		context.setState(getEstadoEncendida());
	
	}
}


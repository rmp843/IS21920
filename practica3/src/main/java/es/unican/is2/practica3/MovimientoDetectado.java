package es.unican.is2.practica3;

public class MovimientoDetectado extends AlarmaHogarState implements TimedState{

	private final int MAXERRORES = 3;
	public void entryAction(AlarmaHogar context) {
		System.out.println("MOVIMIENTO DETECTADO");
		getTimedStateController().startRelative(this,context, context.intervaloDesactivacion());
	}

	public void exitAction(AlarmaHogar context)  {}

	public void alarmaOff(AlarmaHogar context, String codigo) {
		if(codigo.equals(context.codigoDesactivacion()) && context.errores() < MAXERRORES) {
			getTimedStateController().cancel();
			this.exitAction(context);
			context.setState(getEstadoApagada());
			getEstadoApagada().entryAction(context);
			getEstadoApagada().doAction(context);
		}
		else if(!codigo.equals(context.codigoDesactivacion())){
			
			//Si ya se ha llegado al máximo de errores, pasa a IntrusoDetectado
			if(context.errores() == MAXERRORES) {
				getTimedStateController().cancel();
				this.exitAction(context);
				context.setState(getEstadoIntrusoDetectado());
				getEstadoIntrusoDetectado().entryAction(context);
				getEstadoIntrusoDetectado().doAction(context);
			}
			//Si no, añade un error al contador
			else {
				context.addError();
			}
		}
	}
	
	public void timeout(AlarmaHogar context) {
		this.exitAction(context);
		getEstadoIntrusoDetectado().entryAction(context);
		getEstadoIntrusoDetectado().doAction(context);
		context.setState(getEstadoIntrusoDetectado());
	}
	
}

package es.unican.is2.practica3;

public class EsperandoSalida extends AlarmaHogarState{

	public void entryAction(AlarmaHogar context) {}

	public void exitAction(AlarmaHogar context)  {}

	public void alarmaOff(AlarmaHogar context) {
		if(context.codigo() == context.codigoDesactivacion()) {
			this.exitAction(context);
			context.setState(getEstadoApagada());
			getEstadoApagada().entryAction(context);
			getEstadoApagada().doAction(context);
		}
	}


}


package es.unican.is2.practica3;

public class Apagada extends AlarmaHogarState{

	public void entryAction(AlarmaHogar context) {
		System.out.println("APAGADA");
		context.piloto.apagar();
		context.resetErrores();
	}
	public void exitAction(AlarmaHogar context) {
	}
	public void alarmaOn(AlarmaHogar context) {
		this.exitAction(context);
		context.piloto.parpadear();
		context.setState(getEstadoEsperandoSalida());
		getEstadoEsperandoSalida().entryAction(context);
		getEstadoEsperandoSalida().doAction(context);
	}
	
	
}

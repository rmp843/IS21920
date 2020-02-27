package es.unican.is2.practica3;

import java.util.*;

public class TimedStateController {

	private static TimedStateController myTimedStateController;
	
	private static Timer timer;
	private ExpiraTimerTask expiraTimerTask;
	
	private TimedState estado;
	private AlarmaHogar context;
	
	private TimedStateController() {
		timer = new Timer();
	}
	
	public static TimedStateController getInstance() {
		if(myTimedStateController == null) {
			myTimedStateController = new TimedStateController();
		}
		return myTimedStateController;
	}
	
	private class ExpiraTimerTask extends TimerTask{
		public void run() {
			estado.timeout(context);
		}
	}
	
	public void startRelative(TimedState estado, AlarmaHogar context, int milis) {
		this.context = context;
		this.estado = estado;
		this.expiraTimerTask = new ExpiraTimerTask();
		timer.schedule(expiraTimerTask, milis);
	}
	
	public void startAbsolute(TimedState estado, AlarmaHogar context, Date instante) {
		this.context = context;
		this.estado = estado;
		this.expiraTimerTask = new ExpiraTimerTask();
		timer.schedule(expiraTimerTask, instante);
	}
	
	
	public void cancel() {
		expiraTimerTask.cancel();
	}
}

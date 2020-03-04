package es.unican.is2.practica3;

interface TimedState {
	/**
	 * Metodo que se ejecuta una vez se active el timer
	 * @param context
	 */
	public void timeout(AlarmaHogar context);
}

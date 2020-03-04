package es.unican.is2.practica3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Piloto {
	PilotoEstado estado;
	enum PilotoEstado {ENCENDIDO, APAGADO, PARPADEANDO};
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	public Piloto() {
		estado = PilotoEstado.APAGADO;
	}
	public void encender() {
		System.out.println("El piloto acaba de encenderse");
		PilotoEstado estadoAnterior = estado;
		estado = PilotoEstado.ENCENDIDO;
		changeSupport.firePropertyChange("pilotoEncendido", estadoAnterior, estado);
	}
	public void apagar() {
		System.out.println("El piloto acaba de apagarse");
		PilotoEstado estadoAnterior = estado;
		estado = PilotoEstado.APAGADO;
		changeSupport.firePropertyChange("pilotoApagado", estadoAnterior, estado);
	}
	public void parpadear() {
		System.out.println("El piloto acaba de empezar a parpadear");
		PilotoEstado estadoAnterior = estado;
		estado = PilotoEstado.PARPADEANDO;
		changeSupport.firePropertyChange("pilotoParpadeando", estadoAnterior, estado);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener){
		changeSupport.addPropertyChangeListener(listener);
	}
}

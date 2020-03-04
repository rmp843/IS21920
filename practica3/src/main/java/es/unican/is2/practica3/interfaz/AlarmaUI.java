package es.unican.is2.practica3.interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import controlador.AlarmaUIController;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AlarmaUI implements PropertyChangeListener {

	private JFrame frame;
	private AlarmaUIController controlador;

	private JButton botonAlarmaOff;
	private JButton botonIntruso;
	private JButton botonOff;

	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JPanel panelPiloto;
	private JLabel etCodigo;


	

	/**
	 * Constructor de la aplicacion
	 */
	public AlarmaUI() {
		controlador = new AlarmaUIController();
		initialize();
	}

	/**
	 * Main que crea la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlarmaUI window = new AlarmaUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//Crea la ventana
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(200, 200, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Comienza a escuchar el piloto
		controlador.piloto().addPropertyChangeListener(this);

		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panelSalida = new JPanel();
		panelSalida.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSalida.setBounds(47, 301, 198, 34);
		panel.add(panelSalida);
		panelSalida.setLayout(new GridLayout(0, 2, 5, 5));
		
		etCodigo = new JLabel("");
		panelSalida.add(etCodigo);


		
		//BOTONES
		boton1 = new JButton("1");
		boton1.setBounds(47, 116, 49, 47);
		panel.add(boton1);

		boton2 = new JButton("2");
		boton2.setBounds(106, 116, 49, 47);
		panel.add(boton2);

		boton3 = new JButton("3");
		boton3.setBounds(167, 116, 49, 47);
		panel.add(boton3);

		boton4 = new JButton("4");
		boton4.setBounds(47, 173, 49, 47);
		panel.add(boton4);

		boton5 = new JButton("5");
		boton5.setBounds(105, 173, 49, 47);
		panel.add(boton5);

		boton6 = new JButton("6");
		boton6.setBounds(167, 173, 49, 47);
		panel.add(boton6);

		boton7 = new JButton("7");
		boton7.setBounds(47, 230, 49, 47);
		panel.add(boton7);

		boton8 = new JButton("8");
		boton8.setBounds(105, 230, 49, 47);
		panel.add(boton8);

		boton9 = new JButton("9");
		boton9.setBounds(167, 230, 49, 47);
		panel.add(boton9);

		
		panelPiloto = new JPanel();
		panelPiloto.setBounds(60, 42, 144, 36);
		panel.add(panelPiloto);
		panelPiloto.setBackground(UIManager.getColor("Button.highlight"));
		panelPiloto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton botonAlarmaOn = new JButton("ENCENDER ALARMA");
		botonAlarmaOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonAlarmaOn.setBounds(240, 102, 136, 35);
		panel.add(botonAlarmaOn);

		botonAlarmaOff = new JButton("APAGAR ALARMA");
		botonAlarmaOff.setBounds(240, 147, 136, 34);
		panel.add(botonAlarmaOff);

		botonIntruso = new JButton("INTRUSO");
		botonIntruso.setBounds(240, 216, 136, 23);
		panel.add(botonIntruso);

		botonOff = new JButton("OFF");
		botonOff.setBounds(240, 242, 136, 23);
		panel.add(botonOff);

		JButton botonBorrar = new JButton("RESET");
		botonBorrar.setBounds(245, 301, 131, 34);
		panel.add(botonBorrar);
		
		//AÑADIMOS LOS LISTENERS A LOS BOTONES PARA QUE PUEDAN DETECTAR ACCIONES
		botonBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.borrarCodigo();
				controlador.mostrarCodigo(etCodigo);
			}
		});
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonIntruso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.intrusoAlarma();
			}
		});
		botonOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.offAlarma();
			}
		});
		
		botonAlarmaOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.desactivarAlarma();
			}
		});
		botonAlarmaOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.encenderAlarma();
			}
		});
		boton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton1);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		
		boton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton2);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		
		boton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton3);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		
		boton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton4);
				controlador.mostrarCodigo(etCodigo);
			}
		});
	
		boton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton5);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		
		boton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton6);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		boton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton7);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		boton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton8);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		
		boton9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.teclaPresionada(boton9);
				controlador.mostrarCodigo(etCodigo);
			}
		});
		
		
		
		
	
		
	}
	
	/**
	 * Responde a los cambios del piloto, cambiando el color según lo hace su estado.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("pilotoEncendido")){
			panelPiloto.setBackground(Color.GREEN);
		}
		if (evt.getPropertyName().equals("pilotoApagado")){
			panelPiloto.setBackground(Color.RED);
		}
		if (evt.getPropertyName().equals("pilotoParpadeando")){
			panelPiloto.setBackground(Color.YELLOW);			
		}
	}

}

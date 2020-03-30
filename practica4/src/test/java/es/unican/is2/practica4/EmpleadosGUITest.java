/**
 * 
 */
package es.unican.is2.practica4;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.practica4.gui.EmpleadosGUI;
import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.Empleado;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * @author Roberto
 *
 */
public class EmpleadosGUITest {


	private FrameFixture demo;

	@Before
	public void setUp() {
		EmpleadosGUI gui = new EmpleadosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}

	@After
	public void tearDown() {
		demo.cleanUp();
	}


	@Test
	public void test() throws InterruptedException {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Comprobamos que la interfaz tiene el aspecto deseado
		LocalDate current = java.time.LocalDate.now();
		String fecha = current.format(formato).toString();

		//GESTOR,FALSE,HOY
		demo.textBox("txtFechaContratacion").setText(fecha);

		demo.comboBox("comboCategoria").selectItem("GESTOR");
		demo.button("btnCalcular").click();		
		
		demo.textBox("txtSueldo").requireText("1200.0");

		//DIRECTIVO,TRUE,HOY-6
		fecha = current.minusYears(6).format(formato).toString();
		demo.textBox("txtFechaContratacion").setText(fecha);
		demo.radioButton("btnBaja").click();
		demo.comboBox("comboCategoria").selectItem("DIRECTIVO");
		demo.button("btnCalcular").click();	
		demo.textBox("txtSueldo").requireText("1162.5");

		//NULL, TRUE, OBRERO
		demo.textBox("txtFechaContratacion").setText("NULL");
		demo.comboBox("comboCategoria").selectItem("OBRERO");
		demo.button("btnCalcular").click();		
		demo.textBox("txtSueldo").requireText("0.0");

		//DIRECTIVO,TRUE,MAÑANA
		fecha = current.plusDays(1).format(formato).toString();
		demo.textBox("txtFechaContratacion").setText(fecha);
		demo.radioButton("btnBaja").click();
		demo.comboBox("comboCategoria").selectItem("DIRECTIVO");
		demo.button("btnCalcular").click();	
		demo.textBox("txtSueldo").requireText("0.0");

		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}

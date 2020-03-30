package es.unican.is2.practica4;

import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

public class ListaOrdenadaAcotadaTest {

	private ListaOrdenadaAcotada<Integer> lista;
	@Test
	public void testListaOrdenadaAcotadaInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaOrdenadaAcotada() {
		fail("Not yet implemented");
	}


	/**
	 * Lectura posicional: Retorna el elemento que ocupa la
	 * posici�n indicada
	 * @param indice
	 * @return Elemento que ocupa la posici�n indice
	 * @throws IndexOutOfBoundsException si el indice es incorrecto
	 */
	
	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	 /**
     * A�ade un elemento en la posici�n que le corresponde
     * @param elemento a a�adir
     * @throws Lanza IllegalStateException si el elemento no cabe
     */
	@Test
	public void testAdd() {
		lista = new ListaOrdenadaAcotada<Integer>(10);
		assert(lista.size()==0);
		//añadimos un elemento
		lista.add(5);
		//Comprobamos que se puede añadir el primer elemento
		assert(lista.size()==1);
		
		//Comprobamos que se puede añadir el segundo elemento
		lista.add(10);
		assert(lista.size()==2);
		
		//Creamos una nueva lista para no depender del metodo clear
		lista = new ListaOrdenadaAcotada<Integer>(10);
		
		
		for(int i = 0;i < 10;i++) {
			lista.add(i);
		}
		//Comprobamos que se puede añadir el ultimo elemento
		assert(lista.size() == 10);
		try {
			lista.add(10);
			fail("Debería haber lanzado la excepción de tamaño excedido");
		}catch(IllegalStateException e) {}

		fail("Not yet implemented");
	}

	 
    /**
     * Elimina el elemento que ocupa la posici�n indicada
     * @param indice Posici�n del elemento a eliminar
     * @return Elemento que ocupaba la posici�n indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     */
	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	/**
     * Retorna el tama�o de la lista
     * @return Tama�o de la lista
     */
	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

}

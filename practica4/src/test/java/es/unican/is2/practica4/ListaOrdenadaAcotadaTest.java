package es.unican.is2.practica4;

import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.is2.practica4.model.ListaOrdenadaAcotada;
public class ListaOrdenadaAcotadaTest {

	private ListaOrdenadaAcotada<Integer> lista;

	 /**
     * A�ade un elemento en la posici�n que le corresponde
     * @param elemento a a�adir
     * @throws Lanza IllegalStateException si el elemento no cabe
     */
	@Test
	public void testAdd() {
		//Crea una lista con tamaño 10, el predeterminado.
		lista = new ListaOrdenadaAcotada<Integer>();
		assert(lista.size()==0);
		//añadimos un elemento
		lista.add(5);
		//Comprobamos que se puede añadir el primer elemento
		assert(lista.size()==1);
		assert(lista.get(0) == 5);
		//Comprobamos que se puede añadir el segundo elemento
		lista.add(10);
		assert(lista.size()==2);
		assert(lista.get(1)==10);
		//Creamos una nueva lista para no depender del metodo clear
		lista = new ListaOrdenadaAcotada<Integer>(10);
		
	
		
		for(int i = 0; i < 9;i++) {
			lista.add(i);
		}
		lista.add(20);
		//Comprobamos que se puede añadir el ultimo elemento y se añade bien
		assert(lista.size() == 10);
		assert(lista.get(9) == 20);
		
		//Comprobamos que no deja añadir elementos si está llena
		try {
			lista.add(11);
			fail("Error, la lista debería estar llena");
		}catch(IllegalStateException e){}
		
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
		lista = new ListaOrdenadaAcotada<Integer>(10);
		for(int i = 0; i < 10; i++) {
			lista.add(i);
		}
		
		//Prueba con el primer elemento
		assert(lista.get(0) == 0);
		
		//Prueba con elemento intermedio
		assert(lista.get(1) == 1);
		
		//Prueba ultimo elemento
		assert(lista.get(9) == 9);
		
		//Caso con indice mayor que la lista
		try {
		lista.get(10);
		fail("El indice está fuera de la lista, no puede funcionar");
		}catch(IndexOutOfBoundsException e) {}
		
		//Caso indice negativo
		try {
		lista.get(-5);
		fail("No puede haber un indice negativo");
		}
		catch(IndexOutOfBoundsException e) {}
	}

	

	 
    /**
     * Elimina el elemento que ocupa la posici�n indicada
     * @param indice Posici�n del elemento a eliminar
     * @return Elemento que ocupaba la posici�n indicada
     * Lanza IndexOutOfBoundsException si el indice es incorrecto
     */
	@Test
	public void testRemove() {
		
		lista = new ListaOrdenadaAcotada<Integer>(5);
		
		//Prueba con la lista vacia
		try {
		lista.remove(0);
		fail("La lista está vacia, no puede eliminar");
		}catch(IndexOutOfBoundsException e) {
		}
		
		//Prueba a eliminar una lista con un elemento
		lista.add(1);
		lista.remove(0);
		assert(lista.size() == 0);
		
		//Prueba a eliminar segundo elemento
		lista.add(1);
		lista.add(2);
		lista.remove(1);
		assert(lista.size() == 1);
		//Comprobamos que el elemento se ha movido bien
		assert(lista.get(0) == 1);
		
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		//Prueba a borrar el ultimo elemento
		lista.remove(4);
		assert(lista.size()==4);
		
		//Probamos a borrar un elemento intermedio
		lista.add(5);
		lista.remove(3);
		//Comprobamos que el elemento se ha movido bien
		assert(lista.get(3) == 5);
		//Probamos un índice fuera de la lista.
		try {
			lista.remove(7);
			fail("No se puede añadir fuera de la lista");
		}catch(IndexOutOfBoundsException e) {}
		
	}

	/**
     * Retorna el tama�o de la lista
     * @return Tama�o de la lista
     */
	@Test
	public void testSize() {
		lista = new ListaOrdenadaAcotada<Integer>(3);
		//Probamos con la lista vacia
		assert(lista.size() == 0);
		
		lista.add(1);
		assert(lista.size() == 1);
		
		lista.add(2);
		assert(lista.size() == 2);
		
		//Probamos con la lista llena
		lista.add(3);
		assert(lista.size() == 3);	
	}

	@Test
	public void testClear() {
		lista = new ListaOrdenadaAcotada<Integer>(3);
		lista.clear();
		
		//Se prueba con la lista vacia
		assert(lista.size()==0);
		
		lista.add(1);
		lista.clear();
		assert(lista.size()==0);
		
		lista.add(2);
		lista.add(2);
		lista.add(2);
		lista.clear();
		
		assert(lista.size() == 0);
		
		lista.add(5);
		
		//Se prueba con la lista llena
		lista.clear();
		assert(lista.size()==0);
		
		
	}

}

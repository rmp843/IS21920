package es.unican.is2.tienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores y que permite
 * llevar la gestión de las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> listaVendedores = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) {//1
		this.datos = datos;
	}
	//WMC=1
	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() {//1
		return direccion;
	}
	//WMC=1
	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() {//1
		return nombre;
	}
	//WMC=1
	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException {//1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {//1 CC+1
			return false;
		}
		listaVendedores.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}
//WMC=2
//CC=1

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException {//1
		Vendedor v = buscaVendedor(id);
		if (v == null) {//1 CC+1
			return false;
		}
		listaVendedores.remove(v);
		vuelcaDatos();
		return true;
	}
	//WMC=2
	//CC=1

	/**
	 * Añade una venta a un vendedor
	 * 
	 * @param id
	 *            Id del vendedor
	 * @param importe
	 *            Importe de la venta
	 * @return true si se añade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException {//1
		Vendedor v = buscaVendedor(id);
		if (v == null) {//1 CC+1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) {//1 CC+1
			importeFinal = v.actualizaImporteFinal(importeFinal);
		}
		v.anhadeVenta(importeFinal);
		vuelcaDatos();
		return true;
	}

	//WMC=3
	//CC=2
	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id
	 *            Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) {//1

		listaVendedores = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();

			leeVendedoresSenior(in);
			leeVendedoresJunior(in);
			leeVendedoresPracticas(in);
			
		} catch (FileNotFoundException e) {//1 CC+1
		} finally {
			if (in != null) {
				in.close();
			}
		} // try

		for (Vendedor v : listaVendedores) {//1 CC+1
			if (v.getId().equals(id)) {
				return v;
			}
		}
		return null;
	}
	
//WMC=3
//CC=2
	private void leeVendedoresPracticas(Scanner in) {//1
		Vendedor ven;
		while (in.hasNext()) {//1 CC+1
			in.next();
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPracticas(nombre, idIn);
			ven.asignaTotalVentas(totalVentas);
			listaVendedores.add(ven);
		}
	}
	
	//WMC=2
	//CC=1
	private void leeVendedoresSenior(Scanner in) {//1
		Vendedor ven;
		while (in.hasNext() && !in.next().equals("Junior")) {//1 CC+1

			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantilla(nombre, idIn, TipoVendedor.SENIOR);
			ven.asignaTotalVentas(totalVentas);
			listaVendedores.add(ven);
		}
	}
	//WMC=2
	//CC=1
	private void leeVendedoresJunior(Scanner in) {//1
		Vendedor ven;
		while (in.hasNext() && !in.next().equals("Prácticas")) {//1 CC+1
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantilla(nombre, idIn, TipoVendedor.JUNIOR);
			ven.asignaTotalVentas(totalVentas);
			listaVendedores.add(ven);
		}
	}
	//WMC=2
	//CC=1
	/**
	 * Retorna la listaVendedores de vendedores actuales de la tienda
	 * 
	 * @return La listaVendedores de vendedores
	 */
	public List<Vendedor> vendedores() {//1
		listaVendedores = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			
			leeVendedoresSenior(in);
			leeVendedoresJunior(in);
			leeVendedoresPracticas(in);
			
		} catch (FileNotFoundException e) {//1 CC+1

		} finally {
			if (in != null) {//1 CC+1
				in.close();
			}
		}
		return listaVendedores;
	}
	//WMC=3
	//CC=2

	/**
	 * Método que genera el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws IOException {//1
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : listaVendedores) {//1 C+1
			if (v instanceof VendedorEnPracticas) {//1 C+2
				practicas.add(v);
			} 
			else if (v instanceof VendedorEnPlantilla) {//1 C+3
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR))//1 C+4
					junior.add(vp);
				else
					senior.add(vp);
			}
		}

		muestraDatosVentas(senior, junior, practicas);
	}
//WMC=5
//CC=1O
	
	/**
	 * Muestra los datos de las ventas de los empleados senior, junior, y de prácticas pasados como parámetros.
	 * @param senior
	 * @param junior
	 * @param practicas
	 * @throws IOException
	 */
	private void muestraDatosVentas(List<Vendedor> senior, List<Vendedor> junior, List<Vendedor> practicas)
			throws IOException {//1
		PrintWriter out = null;
		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("    Senior");
			for (Vendedor v1 : senior)//1 CC+1
				out.println("      Nombre: " + v1.getNombre() + "   Id: " + v1.getId() + "   TotalVentasMes: "
						+ v1.getTotalVentas());
			out.println();
			out.println("    Junior");
			for (Vendedor v2 : junior)//1 CC+1
				out.println("      Nombre: " + v2.getNombre() + "   Id: " + v2.getId() + "   TotalVentasMes: "
						+ v2.getTotalVentas());
			out.println();
			out.println("    Prácticas");
			for (Vendedor v3 : practicas)//1 CC+1
				out.println("      Nombre: " + v3.getNombre() + "   Id: " + v3.getId() + "   TotalVentasMes: "
						+ v3.getTotalVentas());

		} finally {
			if (out != null)//1 CC+1
				out.close();
		}
	}
}
//WMC=4
//CC=3

//WMCTOTAL=31
//CCTOTAL=32

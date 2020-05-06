package es.unican.is2.tienda;


/**
 * Vendedor de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
public abstract class Vendedor {
	
	private static final double INTERES_SENIOR = 0.01;
	private static final double INTERES_JUNIOR = 0.005;
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double totalVentasMensuales;
	
	public Vendedor(String nombre, String id) {//1
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {//1
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() {//1
		return id;
	}

	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {//1
		return totalVentasMensuales;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void asignaTotalVentas(double totalVentas) {//1
		this.totalVentasMensuales = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhadeVenta(double importe){//1
		totalVentasMensuales += importe;
	}
	
	
	@Override
	public boolean equals(Object obj) {//1
		if (!(obj instanceof Vendedor)) //1 CC+1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.id.equals(id) && v.nombre.equals(nombre));//2 CC+1
	}
	


	/**
	 * Retorna el importe final a partir del importe dado y el vendedor dado, según el tipo de vendedor.
	 * @param importeFinal
	 * @return
	 */
	double actualizaImporteFinal(double importeFinal) {//1
		switch (((VendedorEnPlantilla) this).tipo()) {//2 //CC+2
		case JUNIOR:
			importeFinal += importeFinal * INTERES_JUNIOR;
			break;
		case SENIOR:
			importeFinal += importeFinal * INTERES_SENIOR;
			break;
		}
		return importeFinal;
	}
	//WMC=3 CC+2
}
//WMC=13
//CC=4


public class Producto {
	private Integer codigoProducto;
	private String nombreProd;
	private Integer stock;
	private Double precio;
	
	public Producto(Integer codigoProducto, String nombreProd, Integer stock, Double precio) {
		this.codigoProducto = codigoProducto;
		this.nombreProd = nombreProd;
		this.stock = stock;
		this.precio = precio;
	}
	
	public Producto() {
		this.codigoProducto = 0;
		this.nombreProd = "";
		this.stock = 1;
		this.precio = 1.0;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", nombreProd=" + nombreProd + ", stock=" + stock
				+ ", precio=" + precio + "]";
	}
	
}

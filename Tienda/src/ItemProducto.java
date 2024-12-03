
public class ItemProducto {
	private Integer codigoProducto;
	private Integer cantidad;
	private Double precio;
	
	public ItemProducto(Integer codigoProducto, Integer cantidad, Double precio) {
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public ItemProducto() {
		this.codigoProducto = 0;
		this.cantidad = 1;
		this.precio = 1.0;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "ItemProducto [codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

	
}

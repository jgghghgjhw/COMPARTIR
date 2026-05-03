package entidades;

import data.DataDetalleVentas;

public class DetalleVentas {
	int idDetalle;
	int idVenta;
	int idProducto;
	int cantidad;
	DataDetalleVentas ddv=new DataDetalleVentas();
	public DetalleVentas() {
		
	}
public DetalleVentas(int idProducto,int cantidad) {
	this.idProducto=idProducto;
	this.cantidad=cantidad;
		
	}
public int getIdDetalle() {
	return idDetalle;
}
public void setIdDetalle(int idDetalle) {
	this.idDetalle = idDetalle;
}
public int getIdVenta() {
	return idVenta;
}
public void setIdVenta(int idVenta) {
	this.idVenta = idVenta;
}
public int getIdProducto() {
	return idProducto;
}
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
	
public boolean insertarDetalleVenta() {
	return ddv.insertarProducto(this);
}

}

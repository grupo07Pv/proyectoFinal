package ar.edu.unju.fi.apu.modelo.dominio;
// Generated 07/06/2015 16:27:13 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * FacturaDetalle generated by hbm2java
 */
public class FacturaDetalle  implements java.io.Serializable {


     private int codigo;
     private EncabezadoFactura encabezadoFacturas;
     private Producto productos;
     private double precioVenta;
     private int cantidad;

    public FacturaDetalle() {
    }

    public FacturaDetalle(int codigo, EncabezadoFactura encabezadoFacturas, Producto productos, double precioVenta, int cantidad) {
       this.codigo = codigo;
       this.encabezadoFacturas = encabezadoFacturas;
       this.productos = productos;
       this.precioVenta = precioVenta;
       this.cantidad = cantidad;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public EncabezadoFactura getEncabezadoFacturas() {
        return this.encabezadoFacturas;
    }
    
    public void setEncabezadoFacturas(EncabezadoFactura encabezadoFacturas) {
        this.encabezadoFacturas = encabezadoFacturas;
    }
    public Producto getProductos() {
        return this.productos;
    }
    
    public void setProductos(Producto productos) {
        this.productos = productos;
    }
    public  double getPrecioVenta() {
        return this.precioVenta;
    }
    
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}


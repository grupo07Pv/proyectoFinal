package ar.edu.unju.fi.apu.modelo.dominio;
// Generated 08/06/2015 18:13:05 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * DetalleFactura generated by hbm2java
 */
public class DetalleFactura  implements java.io.Serializable {


     private int codigo;
     private Factura facturas;
     private Producto productos;
     private BigDecimal precioVenta;
     private int cantidad;

    public DetalleFactura() {
    }

    public DetalleFactura(Factura facturas, Producto productos, BigDecimal precioVenta, int cantidad) {
       this.facturas = facturas;
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
    public Factura getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Factura facturas) {
        this.facturas = facturas;
    }
    public Producto getProductos() {
        return this.productos;
    }
    
    public void setProductos(Producto productos) {
        this.productos = productos;
    }
    public BigDecimal getPrecioVenta() {
        return this.precioVenta;
    }
    
    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}



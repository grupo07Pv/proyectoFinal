package ar.edu.unju.fi.apu.modelo.dominio;
// Generated 08/06/2015 18:13:05 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int codigo;
     private TipoProducto tipoProducto;
     private String nombre;
     private BigDecimal precio;
     private int stock;
     private byte[] foto;
     private boolean estado;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codigo;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
     
    public Producto() {
    }

	
    public Producto(int codigo, TipoProducto tipoProducto, String nombre, BigDecimal precio, int stock, byte[] foto, boolean estado) {
        this.codigo = codigo;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.foto = foto;
        this.estado = true;
    }

   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public TipoProducto getTipoProducto() {
        return this.tipoProducto;
    }
    
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

      public boolean getConFoto(){
        boolean resu = false;
        if( foto != null){
            resu = true;
        }
        return resu;
    }
}



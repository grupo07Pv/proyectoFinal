package ar.edu.unju.fi.apu.modelo.dominio;
// Generated 08/06/2015 18:13:05 by Hibernate Tools 4.3.1

import java.util.Objects;




/**
 *
 * @author Grupo 7 - VeGaMES
 */
public class TipoProducto  implements java.io.Serializable {


     private int codigo;
     private String nombre;
     private boolean estado;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codigo;
        hash = 71 * hash + Objects.hashCode(this.nombre);
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
        final TipoProducto other = (TipoProducto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
 
    public TipoProducto() {
    }

	
    public TipoProducto(int codigo, String nombre, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }
 
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
 



}



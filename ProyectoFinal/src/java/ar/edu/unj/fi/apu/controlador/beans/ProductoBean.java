package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@RequestScoped
public class ProductoBean {
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        producto = new Producto();
    }
  
}

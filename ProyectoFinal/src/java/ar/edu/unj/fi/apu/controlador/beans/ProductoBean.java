/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ivan
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
    }
  
}

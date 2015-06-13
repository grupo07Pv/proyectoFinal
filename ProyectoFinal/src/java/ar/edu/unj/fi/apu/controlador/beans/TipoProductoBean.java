/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ivan
 */
@ManagedBean
@RequestScoped
public class TipoProductoBean {
    private TipoProducto tipoProducto;
    /**
     * Creates a new instance of TipoProductoBean
     */
    public TipoProductoBean() {
        tipoProducto = new TipoProducto();
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
}

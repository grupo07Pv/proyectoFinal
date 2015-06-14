/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.EncabezadoFactura;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ivan
 */
@ManagedBean
@RequestScoped
public class FacturaBean {
    private EncabezadoFactura encabezadoFactura;
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        encabezadoFactura = new EncabezadoFactura();
    }

    public EncabezadoFactura getEncabezadoFactura() {
        return encabezadoFactura;
    }

    public void setEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        this.encabezadoFactura = encabezadoFactura;
    }
    
}

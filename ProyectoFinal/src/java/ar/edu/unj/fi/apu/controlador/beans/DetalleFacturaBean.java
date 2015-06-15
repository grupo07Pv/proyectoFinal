package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.DetalleFactura;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean (name = "detalleBean")
@RequestScoped
public class DetalleFacturaBean {
    private DetalleFactura facturaDetalle;
    /**
     * Creates a new instance of DetalleFacturaBean
     */
    public DetalleFacturaBean() {
        facturaDetalle = new DetalleFactura();
    }

    public DetalleFactura getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(DetalleFactura facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }
    
}

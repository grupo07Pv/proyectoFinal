package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.FacturaDetalle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean (name = "detalleBean")
@RequestScoped
public class DetalleFacturaBean {
    private FacturaDetalle facturaDetalle;
    /**
     * Creates a new instance of DetalleFacturaBean
     */
    public DetalleFacturaBean() {
        facturaDetalle = new FacturaDetalle();
    }

    public FacturaDetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }
    
}

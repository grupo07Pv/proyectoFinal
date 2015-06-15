package ar.edu.unj.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@RequestScoped
public class FacturaBean {
    private Factura encabezadoFactura;
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        encabezadoFactura = new Factura();
    }

    public Factura getEncabezadoFactura() {
        return encabezadoFactura;
    }

    public void setEncabezadoFactura(Factura encabezadoFactura) {
        this.encabezadoFactura = encabezadoFactura;
    }
    
}

package ar.edu.unju.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@ViewScoped
public class FacturaBean {

    private Factura factura;

    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        factura = new Factura();
        this.factura.setCodigo("");
        this.factura.setFecha(new Date(System.currentTimeMillis()));
        this.factura.setCliente("Cliente");
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

}

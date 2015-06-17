package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.FacturaBean;
import ar.edu.unj.fi.apu.dao.IFacturaDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.FacturaDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@RequestScoped
public class FacturaFormBean {
    @ManagedProperty (value = "#{facturaBean}")
    private FacturaBean facturaBean;
    private BigDecimal total;
    /**
     * Creates a new instance of FacturaFormBean
     */
    public FacturaFormBean() {
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
    }

    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
    }
    public List<Factura> obtenerFacturas(){
        IFacturaDAO facturaDAO = new FacturaDAOImp();
        return facturaDAO.obtenerTodos(facturaBean.getFactura().getCodigo());
    }

    public void grabarFactura (){
        IFacturaDAO facturaDAO = new FacturaDAOImp();
        facturaDAO.agregarFactura(facturaBean.getFactura());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Date getFechaActual(){
        return new Date(System.currentTimeMillis());
    }
}

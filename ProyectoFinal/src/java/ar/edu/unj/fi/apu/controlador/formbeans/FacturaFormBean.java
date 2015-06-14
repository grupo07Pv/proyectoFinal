/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.FacturaBean;
import ar.edu.unj.fi.apu.dao.IEncabezadoFacturaDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.EncabezadoFacturaDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.EncabezadoFactura;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ivan
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
    public List<EncabezadoFactura> obtenerFacturas(){
        IEncabezadoFacturaDAO encabezadoFacturaDAO = new EncabezadoFacturaDAOImp();
        return encabezadoFacturaDAO.obtenerTodos();
    }

    public void grabarFactura (){
        IEncabezadoFacturaDAO encabezadoFacturaDAO = new EncabezadoFacturaDAOImp();
        encabezadoFacturaDAO.agregarEncabezadoFactura(facturaBean.getEncabezadoFactura());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.DetalleFacturaBean;
import ar.edu.unj.fi.apu.dao.IFacturaDetalleDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.FacturaDetalleDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.FacturaDetalle;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ivan, Gabriel, Gustavo
 */
@ManagedBean (name = "detalleFormBean")
@RequestScoped
public class DetalleFacturaFormBean {
    @ManagedProperty (value="#{detalleBean}")
    private DetalleFacturaBean detalleFacturaBean;
    /**
     * Creates a new instance of DetalleFacturaFormBean
     */
    public DetalleFacturaFormBean() {
    }

    public DetalleFacturaBean getDetalleFacturaBean() {
        return detalleFacturaBean;
    }

    public void setDetalleFacturaBean(DetalleFacturaBean detalleFacturaBean) {
        this.detalleFacturaBean = detalleFacturaBean;
    }
    public List<FacturaDetalle> obtenerDetalles(){
        IFacturaDetalleDAO detalleDAO = new FacturaDetalleDAOImp();
        return detalleDAO.obtenerTodos();
    }
    
    public void obtenerDetalle (FacturaDetalle detalleFactura){
        detalleFacturaBean.setFacturaDetalle(detalleFactura);
    }
    public void limpiarFormulario (){
        detalleFacturaBean.setFacturaDetalle(new FacturaDetalle());
    }
    
    public void grabarNuevoDetalle (){
        IFacturaDetalleDAO detalleDAO = new FacturaDetalleDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    public void actualizarTipoProducto (){
        IFacturaDetalleDAO detalleDAO = new FacturaDetalleDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    public void eliminarTipoProducto (){
        IFacturaDetalleDAO detalleDAO = new FacturaDetalleDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    
}

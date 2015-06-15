package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.DetalleFacturaBean;
import ar.edu.unj.fi.apu.dao.IDetalleFacturaDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.DetalleFacturaDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.DetalleFactura;
import ar.edu.unju.fi.apu.modelo.dominio.Factura;
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
    public List<DetalleFactura> obtenerDetalles(){
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        return detalleDAO.obtenerTodos();
    }
    
    public void obtenerDetalle (DetalleFactura detalleFactura){
        detalleFacturaBean.setFacturaDetalle(detalleFactura);
    }
    public void limpiarFormulario (){
        detalleFacturaBean.setFacturaDetalle(new DetalleFactura());
    }
    
    public void grabarNuevoDetalle (){
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    public void actualizarTipoProducto (){
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    public void eliminarTipoProducto (){
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    
}

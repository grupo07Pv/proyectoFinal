package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.DetalleFacturaBean;
import ar.edu.unju.fi.apu.dao.IDetalleFacturaDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.DetalleFacturaDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.DetalleFactura;
import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Grupo 7 - VeGaMES
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

    // Metodos
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
    
    public void grabarNuevoDetalle (){
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        detalleDAO.agregarDetalle(detalleFacturaBean.getFacturaDetalle());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaDetalle').hide();PF('altaDetalle').hide()");
    }
    
    public void limpiarFormulario (){
        detalleFacturaBean.setFacturaDetalle(new DetalleFactura());
    }
    
    public void obtenerDetalle (DetalleFactura detalleFactura){
        detalleFacturaBean.setFacturaDetalle(detalleFactura);
    }
    
    public List<DetalleFactura> obtenerDetalles(){
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        return detalleDAO.obtenerTodos();
    }
    
    public List<DetalleFactura> obtenerDetallesDeFactura(Factura factura){
        System.out.println(factura.getCodigo());
        IDetalleFacturaDAO detalleDAO = new DetalleFacturaDAOImp();
        List<DetalleFactura> filtroDetalle = new ArrayList();
        for(DetalleFactura deta: detalleDAO.obtenerTodos()){
            if (deta.getFacturas().getCodigo().equalsIgnoreCase(factura.getCodigo())){
                filtroDetalle.add(deta);
            }
        }
       
        return filtroDetalle;
    }
    // Getters & Setters
    public DetalleFacturaBean getDetalleFacturaBean() {
        return detalleFacturaBean;
    }

    public void setDetalleFacturaBean(DetalleFacturaBean detalleFacturaBean) {
        this.detalleFacturaBean = detalleFacturaBean;
    }
}

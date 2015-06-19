package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.TipoProductoBean;
import ar.edu.unju.fi.apu.dao.ITipoProductoDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.TipoProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@ViewScoped
public class TipoProductoFormBean implements Serializable{
    @ManagedProperty (value = "#{tipoProductoBean}")
    private TipoProductoBean tipoProductoBean;
    /**
     * Creates a new instance of TipoProductoFormBean
     */
    public TipoProductoFormBean() {
    }

    public TipoProductoBean getTipoProductoBean() {
        return tipoProductoBean;
    }

    public void setTipoProductoBean(TipoProductoBean tipoProductoBean) {
        this.tipoProductoBean = tipoProductoBean;
    }
    public List<TipoProducto> obtenerTipoProductos(){
        ITipoProductoDAO tipoProductoDAO =new TipoProductoDAOImp();
        return tipoProductoDAO.obtenerTodos();
    }
    public void obtenerTipoProducto (TipoProducto tipoProducto){
        tipoProductoBean.setTipoProducto(tipoProducto);
    }
    public void limpiarFormulario (){
        tipoProductoBean.setTipoProducto(new TipoProducto());
    }
    
    public void visualizarVentanaConfirmaAlta (){
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaTipoProducto').show();");
    }
    public void visualizarVentanaConfirmaModificacion (){
        RequestContext.getCurrentInstance().execute("PF('confirmaModificacionTipoProducto').show();");
    }
    
    public void grabarNuevoTipoProducto (){
        tipoProductoBean.getTipoProducto().setEstado(true);
        ITipoProductoDAO tipoProductoDAO = new TipoProductoDAOImp();
        tipoProductoDAO.agregarTipoProducto(tipoProductoBean.getTipoProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmarAltaTipo').hide();PF('altaTipoProd').hide()");
    }
    public void actualizarTipoProducto (){
        ITipoProductoDAO tipoProductoDAO = new TipoProductoDAOImp();
        tipoProductoDAO.modificarTipoProducto(tipoProductoBean.getTipoProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificarTipo').hide();PF('modificarTipoProd').hide()");
    }
    public void eliminarTipoProducto (){
        tipoProductoBean.getTipoProducto().setEstado(false);
        ITipoProductoDAO tipoProductoDAO = new TipoProductoDAOImp();
        tipoProductoDAO.modificarTipoProducto(tipoProductoBean.getTipoProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaBajaTipo').hide()");
    }
}
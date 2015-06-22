package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.UsuarioBean;
import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.util.Encrypt;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean {

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
    }

    public void registrarUsuario() {
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        if (usuarioDAO.obtenerUsuario(usuarioBean.getUsuario().getNombreUsuario()) == null) {
            this.usuarioBean.getUsuario().setPassword(Encrypt.sha512(this.usuarioBean.getUsuario().getPassword()));
            usuarioDAO.agregarUsuario(usuarioBean.getUsuario());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alta Concretada", "Alta Concretada"));
            RequestContext.getCurrentInstance().execute("PF('altaUsuario').hide()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Introduzca otro usuario", null));
        }
    }

    public void actualizarUsuario() {
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        this.usuarioBean.getUsuario().setPassword(Encrypt.sha512(this.usuarioBean.getUsuario().getPassword()));
        usuarioDAO.modificarUsuario(usuarioBean.getUsuario());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion Concretada", "Operacion Concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificarTipo').hide();PF('modificarTipoProd').hide()");
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

}

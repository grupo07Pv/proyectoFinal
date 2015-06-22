package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.UsuarioBean;
import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import ar.edu.unju.fi.apu.modelo.dominio.util.Encrypt;
import java.io.Serializable;
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
public class UsuarioFormBean implements Serializable{

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
            System.out.println("Entro al if");
            this.usuarioBean.getUsuario().setPassword(Encrypt.sha512(this.usuarioBean.getUsuario().getPassword()));
            usuarioDAO.agregarUsuario(usuarioBean.getUsuario());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alta Concretada", "Alta Concretada"));
            RequestContext.getCurrentInstance().update("mensajeUsuario");
            RequestContext.getCurrentInstance().execute("PF('register').hide()");
            usuarioBean = new UsuarioBean();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Introduzca otro usuario", null));
        }
    }

    public String registrarUsuarioAction() {
        String id = usuarioBean.getUsuario().getNombreUsuario();
        String pass = usuarioBean.getUsuario().getPassword();
        String pagina = "/index?faces-redirect=true";
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        if (usuarioDAO.obtenerUsuario(usuarioBean.getUsuario().getNombreUsuario()) == null) {
            System.out.println("Entro al if");
            this.usuarioBean.getUsuario().setPassword(Encrypt.sha512(this.usuarioBean.getUsuario().getPassword()));
            usuarioDAO.agregarUsuario(usuarioBean.getUsuario());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alta Concretada", "Alta Concretada"));
            usuarioBean = new UsuarioBean();
            Usuario usuario = usuarioDAO.validarUsuario(id, pass);
            if (usuario != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", usuario);
                pagina = "/home?faces-redirect=true";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Introduzca otro usuario", null));
        }
        return pagina;
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

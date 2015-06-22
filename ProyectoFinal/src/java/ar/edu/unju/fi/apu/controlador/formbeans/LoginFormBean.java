package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.UsuarioBean;
import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import ar.edu.unju.fi.apu.modelo.dominio.util.Encrypt;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@SessionScoped
public class LoginFormBean implements Serializable{
    private UsuarioBean usuarioBean;
    private String nombreUsuario;
    private String password;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
        HttpSession miSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(5000);
    }

    public String logIn() {
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        setPassword(Encrypt.sha512(getPassword()));
        Usuario usuario = usuarioDAO.validarUsuario(nombreUsuario,password);
        System.out.println("Valido Usuario");
        if (usuario != null) {
            HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("usuario", this.nombreUsuario);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", usuario);
            return "/home?faces-redirect=true";
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credencial inválida", "Credencial inválida");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        return "/index?faces-redirect=true";
    }
    
    public String validarUsuarioDos() {
        String resultado = "/index?faces-redirect=true";
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        setPassword(Encrypt.sha512(getPassword()));
        Usuario usuario = usuarioDAO.validarUsuario(nombreUsuario,password);
        System.out.println("Valido Usuario");
        if (usuario != null) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario válido", "Usuario válido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", usuario);
            resultado = "/home?faces-redirect=true";
            System.out.println("Redirecciona");
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credencial inválida", "Credencial inválida");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println("Entro else");
        }
        System.out.println("Salio If");
        return resultado;
    }
    
    public String getNombreUsuarioValidado() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
        if (usuario == null){
            usuario = new Usuario();
        }
        return usuario.getNombreUsuario();
    }
    
    public static String getNombreUsuarioCliente() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
        return usuario.getNombreUsuario();
    }
    
    public String cerrarSesion() {
        this.nombreUsuario = null;
        this.password = null;
        HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión Cerrada", "Sesión Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "/index?faces-redirect=true";
    }
    public boolean verificarSesion() {
        boolean sesionValida = false;
        Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
        if (usuario!=null){
            sesionValida = true;
        }
        return sesionValida ;
    }
     public boolean validarNombreUsuario(){
        boolean band = false;
        String nombre = getNombreUsuarioValidado();
        if (nombre.equalsIgnoreCase("admin"))
        {   
            band=true;
        }
        return band;
    }
     
     public void limpiarFormulario(){
        this.usuarioBean.setUsuario(new Usuario());
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
     
    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}

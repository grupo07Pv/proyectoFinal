package ar.edu.unju.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
private Usuario usuario;
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}

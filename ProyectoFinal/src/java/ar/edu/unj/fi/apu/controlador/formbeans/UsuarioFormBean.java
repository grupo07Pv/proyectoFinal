package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.UsuarioBean;
import ar.edu.unj.fi.apu.dao.IUsuarioDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@RequestScoped
public class UsuarioFormBean {
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
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
    public boolean validarUsuario (String nombre){
        Usuario usuario = new Usuario(); 
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuario = usuarioDAO.obtenerUsuario(nombre);
        if (usuario.getNombreUsuario() != "admin")
        {   
            return true;
        }else{return false;}
    }
}

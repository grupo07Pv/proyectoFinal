/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.UsuarioBean;
import ar.edu.unj.fi.apu.dao.IUsuarioDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.UsuarioDAOImpl;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ivan
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
        IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        usuario = usuarioDAO.obtenerUsuario(nombre);
        if (usuario.getNombreUsuario() != "admin")
        {   
            return true;
        }else{return false;}
    }
}

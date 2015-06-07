/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao.imp.mysql;

import ar.edu.unj.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ivan
 */
public class UsuarioDAOImpl implements IUsuarioDAO{

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.eq("password", password));
        if (!(criteria.list().isEmpty())){
            usuario =(Usuario) criteria.list().get(0);
        }
        return usuario;
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
       Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        if (!(criteria.list().isEmpty())){
            usuario =(Usuario) criteria.list().get(0);
        }
        return usuario;
    }
    
}

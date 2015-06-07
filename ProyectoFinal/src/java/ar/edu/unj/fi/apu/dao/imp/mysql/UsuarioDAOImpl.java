/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao.imp.mysql;

import ar.edu.unj.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Usuarios;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ivan
 */
public class UsuarioDAOImpl implements IUsuarioDAO{

    @Override
    public Usuarios validarUsuario(String nombreUsuario, String password) {
        Usuarios usuarios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.eq("password", password));
        if (!(criteria.list().isEmpty())){
            usuarios =(Usuarios) criteria.list().get(0);
        }
        return usuarios;
    }

    @Override
    public Usuarios obtenerUsuario(String nombreUsuario) {
       Usuarios usuarios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        if (!(criteria.list().isEmpty())){
            usuarios =(Usuarios) criteria.list().get(0);
        }
        return usuarios;
    }
    
}

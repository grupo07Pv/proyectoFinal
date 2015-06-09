/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao.imp.mysql;

import ar.edu.unj.fi.apu.dao.ITipoProductoDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ivan
 */
public class TipoProductoDAOImp implements ITipoProductoDAO{

    @Override
    public void agregarProducto(TipoProducto tipoProducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tipoProducto);
        session.getTransaction().commit();
        session.close();   
    }

    @Override
    public void modificarProducto(TipoProducto tipoProducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(tipoProducto);
        session.getTransaction().commit();
        session.close();   
    }

    @Override
    public void eliminarProducto(TipoProducto tipoProducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(tipoProducto);
        session.getTransaction().commit();
        session.close();   
    }

    @Override
    public List<TipoProducto> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TipoProducto.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("nombre"));
        List productos = criteria.list();
        return productos;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao.imp.mysql;

import ar.edu.unj.fi.apu.dao.IEncabezadoFacturaDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.EncabezadoFactura;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ivan
 */
public class EncabezadoFacturaDAOImp implements IEncabezadoFacturaDAO{

    @Override
    public void agregarEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(encabezadoFactura);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public void modificarEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(encabezadoFactura);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public List<EncabezadoFactura> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(EncabezadoFactura.class);
        criteria.addOrder(Order.asc("codigo"));
        List productos = criteria.list();
        return productos;
    }
    
}

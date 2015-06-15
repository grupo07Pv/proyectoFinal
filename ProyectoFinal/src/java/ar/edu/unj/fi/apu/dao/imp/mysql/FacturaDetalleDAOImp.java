package ar.edu.unj.fi.apu.dao.imp.mysql;

import ar.edu.unj.fi.apu.dao.IFacturaDetalleDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.FacturaDetalle;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public class FacturaDetalleDAOImp implements IFacturaDetalleDAO{

    @Override
    public void agregarDetalle(FacturaDetalle facturaDetalle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(facturaDetalle);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarDetalle(FacturaDetalle facturaDetalle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(facturaDetalle);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarDetalle(FacturaDetalle facturaDetalle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(facturaDetalle);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public List<FacturaDetalle> obtenerTodos() {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(FacturaDetalle.class);
        criteria.addOrder(Order.asc("codigo"));
        List productos = criteria.list();
        return productos;
    }    
}

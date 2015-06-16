package ar.edu.unj.fi.apu.dao.imp.mysql;

import ar.edu.unj.fi.apu.dao.IFacturaDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public class FacturaDAOImp implements IFacturaDAO{

    @Override
    public void agregarFactura(Factura factura) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(factura);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public void modificarFactura(Factura factura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(factura);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public List<Factura> obtenerTodos(String codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Factura.class);
        criteria.addOrder(Order.asc("codigo"));
        List productos = criteria.list();
        return productos;
    }
    
}

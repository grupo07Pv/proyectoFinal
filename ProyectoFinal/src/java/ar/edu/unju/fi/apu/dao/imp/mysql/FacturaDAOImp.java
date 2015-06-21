package ar.edu.unju.fi.apu.dao.imp.mysql;

import ar.edu.unju.fi.apu.dao.IFacturaDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
    public List<Factura> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Factura.class);
        criteria.addOrder(Order.asc("codigo"));
        List productos = criteria.list();
        session.close();
        return productos;
    }

    @Override
    public Factura getUltimoRegistro() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql="from Factura order by codigo desc";
        Query query=session.createQuery(hql).setMaxResults(1);
        Factura factura = (Factura) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return factura;
    }

    @Override
    public List<Factura> obtenerAlgunas(Date desde, Date Hasta) {
        List <Factura> filtroFactura = new ArrayList();
        for(Factura unaFactura: obtenerTodos()){
            boolean resultado = true;
            
            if( (resultado == true)&&(desde != null)&&(unaFactura.getFecha() != null)){
                if(unaFactura.getFecha().compareTo(desde) <= -1){
                    resultado = false;
                }
            }
            
            if( (resultado == true)&&(Hasta != null)&&(unaFactura.getFecha() != null)){
                if(unaFactura.getFecha().compareTo(Hasta) >= 1){
                    resultado = false;
                }
            }
            if (resultado == true){
                filtroFactura.add(unaFactura);
            }
        }
        return filtroFactura;
    }

    @Override
    public void eliminarFactura(Factura factura) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(factura);
        session.getTransaction().commit();
        session.close();  
    }
    
}

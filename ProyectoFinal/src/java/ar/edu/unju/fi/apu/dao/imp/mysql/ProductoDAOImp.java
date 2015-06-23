package ar.edu.unju.fi.apu.dao.imp.mysql;

import ar.edu.unju.fi.apu.dao.IProductoDAO;
import ar.edu.unju.fi.apu.hibernate.config.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public class ProductoDAOImp implements IProductoDAO{

    @Override
    public void agregarProducto(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(producto);
        session.getTransaction().commit();
        session.close();   
    }

    @Override
    public void modificarProducto(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(producto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void bajaProducto(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(producto);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void eliminarProducto(Producto producto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(producto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Producto> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("codigo"));
        List productos = criteria.list();
        session.close();
        return productos;
    }

    @Override
    public Producto obtenerProducto(int codigo) {
        Producto producto=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria =session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        if (!(criteria.list().isEmpty())){
            producto=(Producto) criteria.list().get(0);
        }
        session.close();
        return producto;
    }
    
}

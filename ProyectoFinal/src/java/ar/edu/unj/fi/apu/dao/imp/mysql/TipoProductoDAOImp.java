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
 * @author Grupo 7 - VeGaMES
 */
public class TipoProductoDAOImp implements ITipoProductoDAO{

    @Override
    public void agregarTipoProducto(TipoProducto tipoProducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tipoProducto);
        session.getTransaction().commit();
        session.close();   
    }

    @Override
    public void modificarTipoProducto(TipoProducto tipoProducto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(tipoProducto);
        session.getTransaction().commit();
        session.close();   
    }

    @Override
    public void eliminarTipoProducto(TipoProducto tipoProducto) {
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
        criteria.addOrder(Order.asc("codigo"));
        List productos = criteria.list();
        return productos;
    }

    @Override
    public TipoProducto obtenerTipoProducto(int codigo) {
        TipoProducto tipoProducto=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria =session.createCriteria(TipoProducto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        if (!(criteria.list().isEmpty())){
            tipoProducto=(TipoProducto) criteria.list().get(0);
        }
        return tipoProducto;
    }
    
}

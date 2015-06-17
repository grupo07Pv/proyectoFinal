package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IProductoDAO {
     public void agregarProducto (Producto producto);
    public void modificarProducto (Producto producto);
    public void bajaProducto(Producto producto);
    public void eliminarProducto (Producto producto);
    public List<Producto> obtenerTodos();
    public Producto obtenerProducto(int codigo);
}

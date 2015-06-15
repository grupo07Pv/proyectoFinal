package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface ITipoProductoDAO {
    public void agregarTipoProducto (TipoProducto tipoProducto);
    public void modificarTipoProducto (TipoProducto tipoProducto);
    public void eliminarTipoProducto (TipoProducto tipoProducto);
    public List<TipoProducto> obtenerTodos();
    public TipoProducto obtenerTipoProducto(int codigo);
}

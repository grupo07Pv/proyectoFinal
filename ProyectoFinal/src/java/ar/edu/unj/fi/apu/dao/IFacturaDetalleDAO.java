package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.FacturaDetalle;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IFacturaDetalleDAO {
    public void agregarDetalle (FacturaDetalle facturaDetalle);
    public void modificarDetalle (FacturaDetalle facturaDetalle);
    public void eliminarDetalle (FacturaDetalle facturaDetalle);
    public List<FacturaDetalle> obtenerTodos();
}

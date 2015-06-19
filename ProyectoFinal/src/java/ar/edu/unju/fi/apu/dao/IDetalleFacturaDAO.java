package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.DetalleFactura;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IDetalleFacturaDAO {
    public void agregarDetalle (DetalleFactura facturaDetalle);
    public void modificarDetalle (DetalleFactura facturaDetalle);
    public void eliminarDetalle (DetalleFactura facturaDetalle);
    public List<DetalleFactura> obtenerTodos();
}

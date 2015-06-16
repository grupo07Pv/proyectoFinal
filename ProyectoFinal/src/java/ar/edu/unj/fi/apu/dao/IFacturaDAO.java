package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IFacturaDAO {
    public void agregarFactura (Factura factura);
    public void modificarFactura (Factura factura);
    public List<Factura> obtenerTodos(String codigo);
}

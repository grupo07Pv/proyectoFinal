package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IFacturaDAO {
    public void agregarEncabezadoFactura (Factura encabezadoFactura);
    public void modificarEncabezadoFactura (Factura encabezadoFactura);
    public List<Factura> obtenerTodos();
}

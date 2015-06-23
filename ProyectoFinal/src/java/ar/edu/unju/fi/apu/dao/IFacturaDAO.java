package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IFacturaDAO {
    public void agregarFactura (Factura factura);
    public void eliminarFactura (Factura factura);
    public Factura getUltimoRegistro();
    public void modificarFactura (Factura factura);
    public List<Factura> obtenerAlgunas(Date desde,Date Hasta);
    public List<Factura> obtenerTodos();
}

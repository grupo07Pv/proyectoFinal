package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.EncabezadoFactura;
import java.util.List;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IEncabezadoFacturaDAO {
    public void agregarEncabezadoFactura (EncabezadoFactura encabezadoFactura);
    public void modificarEncabezadoFactura (EncabezadoFactura encabezadoFactura);
    public List<EncabezadoFactura> obtenerTodos();
}

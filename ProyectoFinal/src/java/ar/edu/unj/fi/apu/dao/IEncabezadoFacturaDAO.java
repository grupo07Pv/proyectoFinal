/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.EncabezadoFactura;
import java.util.List;

/**
 *
 * @author Ivan
 */
public interface IEncabezadoFacturaDAO {
    public void agregarProducto (EncabezadoFactura encabezadoFactura);
    public void modificarProducto (EncabezadoFactura encabezadoFactura);
    public List<EncabezadoFactura> obtenerTodos();
}

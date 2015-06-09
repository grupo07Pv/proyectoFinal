/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.util.List;

/**
 *
 * @author Ivan
 */
public interface ITipoProductoDAO {
     public void agregarProducto (TipoProducto tipoProducto);
    public void modificarProducto (TipoProducto tipoProducto);
    public void eliminarProducto (TipoProducto tipoProducto);
    public List<TipoProducto> obtenerTodos();
}

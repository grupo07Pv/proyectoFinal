/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.TipoProductoBean;
import ar.edu.unj.fi.apu.dao.ITipoProductoDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.TipoProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ivan
 */
@ManagedBean
@RequestScoped
public class TipoProductoFormBean {
    @ManagedProperty (value = "#{tipoProductoBean}")
    private TipoProductoBean tipoProductoBean;
    /**
     * Creates a new instance of TipoProductoFormBean
     */
    public TipoProductoFormBean() {
    }

    public TipoProductoBean getTipoProductoBean() {
        return tipoProductoBean;
    }

    public void setTipoProductoBean(TipoProductoBean tipoProductoBean) {
        this.tipoProductoBean = tipoProductoBean;
    }
    public List<TipoProducto> obtenerTipoProductos(){
        ITipoProductoDAO tipoProductoDAO =new TipoProductoDAOImp();
        return tipoProductoDAO.obtenerTodos();
    }
}

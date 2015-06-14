/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.DetalleFacturaBean;
import ar.edu.unj.fi.apu.dao.IFacturaDetalleDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.FacturaDetalleDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.FacturaDetalle;
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
public class DetalleFacturaFormBean {
    @ManagedProperty (value="#{detalleFacturaBean}")
    private DetalleFacturaBean detalleFacturaBean;
    /**
     * Creates a new instance of DetalleFacturaFormBean
     */
    public DetalleFacturaFormBean() {
    }

    public DetalleFacturaBean getDetalleFacturaBean() {
        return detalleFacturaBean;
    }

    public void setDetalleFacturaBean(DetalleFacturaBean detalleFacturaBean) {
        this.detalleFacturaBean = detalleFacturaBean;
    }
    public List<FacturaDetalle> obtenerDetalles(){
        IFacturaDetalleDAO detalleDAO = new FacturaDetalleDAOImp();
        return detalleDAO.obtenerTodos();
    }
    
}

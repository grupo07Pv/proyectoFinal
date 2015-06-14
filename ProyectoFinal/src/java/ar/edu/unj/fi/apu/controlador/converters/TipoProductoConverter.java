/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.converters;

import ar.edu.unj.fi.apu.dao.ITipoProductoDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.TipoProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ivan
 */
@FacesConverter("tipoProductoConverter")
public class TipoProductoConverter implements Converter{
    List <TipoProducto> productos;
    
    public TipoProductoConverter(){
        productos=new ArrayList<>();
        ITipoProductoDAO tipoProductoDAO = new TipoProductoDAOImp();
        productos=tipoProductoDAO.obtenerTodos();   
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
           ITipoProductoDAO productoDAO = new TipoProductoDAOImp();
           return productoDAO.obtenerTipoProducto(Integer.parseInt(value));
       }
       catch(Exception exception){
           throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
       }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     if (value != ""){
            TipoProducto tipoProducto = (TipoProducto)value;
            return String.valueOf(tipoProducto.getCodigo());
        }else{
            return "";
        }
    }
}
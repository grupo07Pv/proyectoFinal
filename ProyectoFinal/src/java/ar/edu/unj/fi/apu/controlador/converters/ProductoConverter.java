/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.converters;

import ar.edu.unj.fi.apu.dao.IProductoDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.ProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
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
@FacesConverter("productoConverter")
public class ProductoConverter implements Converter{
    List <Producto> productos;
    
    public ProductoConverter(){
        productos=new ArrayList<>();
        IProductoDAO productoDAO = new ProductoDAOImp();
        productos=productoDAO.obtenerTodos();   
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try{
           IProductoDAO productoDAO = new ProductoDAOImp();
           return productoDAO.obtenerProducto(Integer.parseInt(value));
       }
       catch(Exception exception){
           throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
       }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     if (value != ""){
            Producto producto = (Producto)value;
            return String.valueOf(producto.getCodigo());
        }else{
            return "";
        }
    }
}
    


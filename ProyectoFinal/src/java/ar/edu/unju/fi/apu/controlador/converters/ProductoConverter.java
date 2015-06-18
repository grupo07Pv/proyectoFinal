package ar.edu.unju.fi.apu.controlador.converters;

import ar.edu.unju.fi.apu.dao.IProductoDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.ProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Grupo 7 - VeGaMES
 */
@FacesConverter ("productoConverter")
public class ProductoConverter implements Converter{
      
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

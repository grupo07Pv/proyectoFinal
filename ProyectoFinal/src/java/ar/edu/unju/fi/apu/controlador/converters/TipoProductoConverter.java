package ar.edu.unju.fi.apu.controlador.converters;

import ar.edu.unju.fi.apu.dao.ITipoProductoDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.TipoProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
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
@FacesConverter("tipoProductoConverter")
public class TipoProductoConverter implements Converter{
    
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
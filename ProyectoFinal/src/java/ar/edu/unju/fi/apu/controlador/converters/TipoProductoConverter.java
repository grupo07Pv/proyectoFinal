package ar.edu.unju.fi.apu.controlador.converters;

import ar.edu.unju.fi.apu.dao.ITipoProductoDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.TipoProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
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
 * @author Grupo 7 - VeGaMES
 */
@FacesConverter("tipoProductoConverter")
public class TipoProductoConverter implements Converter {

    List<TipoProducto> lista;

    public TipoProductoConverter() {
        lista = new ArrayList<>();
        ITipoProductoDAO tipoDAO = new TipoProductoDAOImp();
        lista = tipoDAO.obtenerTodos();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            for (TipoProducto tipo : lista) {
                if (String.valueOf(tipo.getCodigo()).equals(value)) {
                    return tipo;
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != "") {
            TipoProducto tipoProducto = (TipoProducto) value;
            return String.valueOf(tipoProducto.getCodigo());
        } else {
            return "";
        }
    }
}

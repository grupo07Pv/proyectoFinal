package ar.edu.unju.fi.apu.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.TipoProducto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@ViewScoped
public class TipoProductoBean implements Serializable{
    private TipoProducto tipoProducto;
    /**
     * Creates a new instance of TipoProductoBean
     */
    public TipoProductoBean() {
        tipoProducto = new TipoProducto();
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
}

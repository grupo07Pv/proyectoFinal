package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.FacturaBean;
import ar.edu.unju.fi.apu.dao.IFacturaDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.DetalleFacturaDAOImp;
import ar.edu.unju.fi.apu.dao.imp.mysql.FacturaDAOImp;
import ar.edu.unju.fi.apu.dao.imp.mysql.ProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.DetalleFactura;
import ar.edu.unju.fi.apu.modelo.dominio.Factura;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@ViewScoped
public class FacturaFormBean {

    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;
    private Producto producto;
    private List<DetalleFactura> listaDetalles;
    private BigDecimal total;

    /**
     * Creates a new instance of FacturaFormBean
     */
    public FacturaFormBean() {
        this.producto = new Producto();
        this.listaDetalles = new ArrayList<>();
        this.total = new BigDecimal("0");
    }

    public void agregarListaDetalle(int codigo) {
        ProductoDAOImp productoDAO = new ProductoDAOImp();
        this.producto = productoDAO.obtenerProducto(codigo);
        this.listaDetalles.add(new DetalleFactura(null, producto, new BigDecimal("0"), 1));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto agregado"));
        RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
        RequestContext.getCurrentInstance().update("frmRealizarVentas:mensajeGeneral");
    }

    public void retirarListaDetalle(int codigo) {
        int i = 0;
        for (DetalleFactura item : this.listaDetalles) {
            if (item.getProductos().getCodigo() == codigo) {
                this.listaDetalles.remove(i);
                break;
            }
            i++;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Producto retirado de la lista de venta"));
        RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
        RequestContext.getCurrentInstance().update("frmRealizarVentas:panelFinalVenta");
        RequestContext.getCurrentInstance().update("frmRealizarVentas:mensajeGeneral");
    }

    public void calcularTotal() {
        this.total = new BigDecimal("0");
        for (DetalleFactura item : this.listaDetalles) {
            BigDecimal totalVenta = item.getProductos().getPrecio().multiply(new BigDecimal(item.getCantidad()));
            item.setPrecioVenta(totalVenta);
            this.total = this.total.add(totalVenta);
        }
        RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
        RequestContext.getCurrentInstance().update("frmRealizarVentas:panelFinalVenta");
    }

    public void grabarFactura() {
        ProductoDAOImp productoDAO = new ProductoDAOImp();
        FacturaDAOImp facturaDAO = new FacturaDAOImp();
        DetalleFacturaDAOImp detalleDAO = new DetalleFacturaDAOImp();
        facturaDAO.agregarFactura(this.facturaBean.getFactura());
        this.facturaBean.setFactura(facturaDAO.getUltimoRegistro());
        for (DetalleFactura item : this.listaDetalles) {
            this.producto = productoDAO.obtenerProducto(item.getProductos().getCodigo());
            item.setFacturas(this.facturaBean.getFactura());
            item.setProductos(this.producto);
            detalleDAO.agregarDetalle(item);
        }
        this.listaDetalles = new ArrayList<>();
        this.facturaBean = new FacturaBean();
        RequestContext.getCurrentInstance().update("frmRealizarVentas:panelFinalVenta");
    }

    public List<Factura> obtenerFacturas() {
        IFacturaDAO facturaDAO = new FacturaDAOImp();
        return facturaDAO.obtenerTodos(facturaBean.getFactura().getCodigo());
    }

    public FacturaBean getFacturaBean() {
        return facturaBean;
    }

    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

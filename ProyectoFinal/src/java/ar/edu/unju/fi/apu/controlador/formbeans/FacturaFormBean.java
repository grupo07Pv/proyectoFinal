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
import java.util.Date;
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
public class FacturaFormBean implements java.io.Serializable {

    @ManagedProperty(value = "#{productoFormBean}")
    private ProductoFormBean productoFormBean;
    @ManagedProperty(value = "#{facturaBean}")
    private FacturaBean facturaBean;
    private Producto producto;
    private List<DetalleFactura> listaDetalles;
    private BigDecimal total;
    private Date fechaDesde;
    private Date fechaHasta;
    private List<Factura> algunasFacturas;

    /**
     * Creates a new instance of FacturaFormBean
     */
    public FacturaFormBean() {
        this.producto = new Producto();
        this.listaDetalles = new ArrayList<>();
        this.total = new BigDecimal("100");
    }

    // Metodos
    public void agregarListaDetalle(Producto prod) {
        boolean bandera = true;
        for (DetalleFactura item : listaDetalles) {
            if (item.getProductos().getCodigo() == prod.getCodigo()) {
                item.setCantidad(item.getCantidad() + 1);
                item.setPrecioVenta(item.getProductos().getPrecio().multiply(new BigDecimal(item.getCantidad())));
                bandera = false;
                break;
            }
        }
        if (bandera) {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setCantidad(1);
            detalle.setProductos(prod);
            detalle.setPrecioVenta(prod.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
            this.listaDetalles.add(detalle);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto agregado"));
        RequestContext.getCurrentInstance().update("frmListaCompra:tblListaCompra");
        RequestContext.getCurrentInstance().update(":mensajeGeneral");
    }

    public void buscarFacturas() {
        IFacturaDAO facturaDAO = new FacturaDAOImp();
        algunasFacturas = facturaDAO.obtenerAlgunas(fechaDesde, fechaHasta);
    }

    public void calcularTotal() {
        this.total = new BigDecimal("0");
        for (DetalleFactura item : listaDetalles) {
            setTotal(total.add(item.getPrecioVenta()));
        }
        RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
        RequestContext.getCurrentInstance().update("frmRealizarVentas:panelFinalVenta");
    }

    public void eliminarFactura() {
        this.facturaBean.getFactura().setEstado(false);
        IFacturaDAO facturaDAO = new FacturaDAOImp();
        facturaDAO.modificarFactura(this.facturaBean.getFactura());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion concretada", "Operacion concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaBajaFactura').hide()");
    }

    public Date getFechaActual() {
        return new Date(System.currentTimeMillis());
    }

    public void grabarFactura() {
        this.facturaBean.getFactura().setEstado(true);
        ProductoDAOImp productoDAO = new ProductoDAOImp();
        FacturaDAOImp facturaDAO = new FacturaDAOImp();
        DetalleFacturaDAOImp detalleDAO = new DetalleFacturaDAOImp();
        this.facturaBean.getFactura().setEstado(true);
        if (this.listaDetalles.size() > 0) {
            facturaDAO.agregarFactura(this.facturaBean.getFactura());
            this.facturaBean.setFactura(facturaDAO.getUltimoRegistro());
            for (DetalleFactura item : this.listaDetalles) {
                this.producto = productoDAO.obtenerProducto(item.getProductos().getCodigo());
                item.setFacturas(this.facturaBean.getFactura());
                item.setProductos(this.producto);
                detalleDAO.agregarDetalle(item);
                if ((item.getProductos().getStock() - item.getCantidad()) == 0) {
                    this.producto.setEstado(false);
                    productoDAO.modificarProducto(this.producto);
                }
            }
            this.listaDetalles = new ArrayList<>();
            this.facturaBean = new FacturaBean();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra Realizada", "Muchas Gracias"));
            RequestContext.getCurrentInstance().update("frmVentasProd:tblProductosDisponibles");
            RequestContext.getCurrentInstance().update("frmListaCompra:tblListaCompra");
            RequestContext.getCurrentInstance().update("mensajeGeneral");
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cargue un Detalle", "De la Lista"));
        RequestContext.getCurrentInstance().update("mensajeGeneral");
    }

    public void obtenerFactura(Factura factura) {
        facturaBean.setFactura(factura);
        //RequestContext.getCurrentInstance().update(null);
    }

    public List<Factura> obtenerFacturas() {
        IFacturaDAO facturaDAO = new FacturaDAOImp();
        return facturaDAO.obtenerTodos();
    }

    public void retirarListaDetalle(Producto prod) {
        int i = 0;
        for (DetalleFactura item : this.listaDetalles) {
            if (item.getProductos().getCodigo() == prod.getCodigo()) {
                this.listaDetalles.remove(i);
                break;
            }
            i++;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Correcto", "Producto retirado de la lista de venta"));
        RequestContext.getCurrentInstance().update("frmListaCompra:tblListaCompra");
        RequestContext.getCurrentInstance().update("mensajeGeneral");
    }

    // Getters & Setters
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

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public List<Factura> getAlgunasFacturas() {
        return algunasFacturas;
    }

    public void setAlgunasFacturas(List<Factura> algunasFacturas) {
        this.algunasFacturas = algunasFacturas;
    }

    /**
     * @return the productoFormBean
     */
    public ProductoFormBean getProductoFormBean() {
        return productoFormBean;
    }

    /**
     * @param productoFormBean the productoFormBean to set
     */
    public void setProductoFormBean(ProductoFormBean productoFormBean) {
        this.productoFormBean = productoFormBean;
    }

}

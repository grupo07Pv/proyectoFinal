package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.ProductoBean;
import ar.edu.unju.fi.apu.dao.IProductoDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.ProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
@ManagedBean
@SessionScoped
public class ProductoFormBean {
    @ManagedProperty (value = "#{tipoProductoFormBean}")
    TipoProductoFormBean tipoProducto;
    @ManagedProperty (value = "#{productoBean}")
    private ProductoBean productoBean;
    private UploadedFile archivo;
    private String precio;
    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
    }

    //Metodos
    public void actualizarProducto(){
        convertirPrecio();
        IProductoDAO productoDAO = new ProductoDAOImp();
        try{
            if (archivo.getFileName().isEmpty()==false){
                InputStream inputStream = this.archivo.getInputstream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] bytes = new byte[16384];
                while ((nRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                    buffer.write(bytes, 0, nRead);
                }
                buffer.flush();
                this.productoBean.getProducto().setFoto(buffer.toByteArray());
            }
        }catch(Exception e){
        }
        productoDAO.modificarProducto(this.productoBean.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Producto Modificado", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificaProducto').hide();PF('modificaProducto').hide()");
        RequestContext.getCurrentInstance().update("frmProductos:tblProductos");
        RequestContext.getCurrentInstance().update("frmGralProd:grwMensajeProducto");
    }
    
    public void agregarProducto (){
        convertirPrecio();
        productoBean.getProducto().setEstado(true);
        IProductoDAO productoDAO=new ProductoDAOImp();
        try{
            InputStream inputStream = this.archivo.getInputstream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] bytes = new byte [16384];
            while ((nRead = inputStream.read(bytes,0,bytes.length)) != -1){
                buffer.write(bytes, 0,nRead);
            }
            buffer.flush();
            this.productoBean.getProducto().setFoto(buffer.toByteArray());
            System.out.println(this.productoBean.getProducto().getFoto().length);
        }catch(Exception e){
        }
        
        productoDAO.agregarProducto(this.productoBean.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Producto Agregado", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaProducto').hide();PF('altaProducto').hide()");
        RequestContext.getCurrentInstance().update("frmProductos:tblProductos");
        RequestContext.getCurrentInstance().update("frmGralProd:grwMensajeProducto");
    }
    
    public void convertirPrecio(){
        try {
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
            otherSymbols.setDecimalSeparator(',');
            DecimalFormat df = new DecimalFormat("###,##", otherSymbols);
            Number numero2 = df.parse(precio);
            BigDecimal numero = new BigDecimal (numero2.toString());
            productoBean.getProducto().setPrecio(numero);
        } catch (ParseException ex) {
        }
    }
    
    public void eliminarProducto(){
        this.productoBean.getProducto().setEstado(false);
        IProductoDAO productoDAO = new ProductoDAOImp();
        productoDAO.bajaProducto(productoBean.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto Eliminado","Operacion concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaBajaProducto').hide()");
        RequestContext.getCurrentInstance().update("frmProductos:tblProductos");
        RequestContext.getCurrentInstance().update("frmGralProd:grwMensajeProducto");
    }
    
    public StreamedContent getArchivoFoto() throws IOException{
        IProductoDAO productoDAO = new ProductoDAOImp();
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
        }
        else{
            String codigo = context.getExternalContext().getRequestParameterMap().get("codigo");
            Producto producto = productoDAO.obtenerProducto(Integer.parseInt(codigo));
            if(producto.getFoto()==null){
                return null;
            }else{
                return new DefaultStreamedContent(new ByteArrayInputStream(producto.getFoto()));
            }
        }
    }
    public StreamedContent getArchivoFotoModif() throws IOException{
        return (new DefaultStreamedContent(new ByteArrayInputStream(this.productoBean.getProducto().getFoto())));
    }
    
    public void limpiarFormulario(){
        this.productoBean.setProducto(new Producto());
        this.precio="";
    }
    
    public void obtenerProducto (Producto producto){
        productoBean.setProducto(producto);
        ProductoFormBean.this.setPrecio(producto.getPrecio().toString());
        RequestContext.getCurrentInstance().update("frmModificaProducto:dlgModificaProducto");
    }
    
    public List<Producto> obtenerProductos(){
        IProductoDAO productoDAO =new ProductoDAOImp();
        return productoDAO.obtenerTodos();
    }
    
    // Getters & Setters

    public TipoProductoFormBean getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProductoFormBean tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    public ProductoBean getProductoBean() {
        return productoBean;
    }

    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }
    
    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}

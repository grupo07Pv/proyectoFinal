package ar.edu.unju.fi.apu.controlador.formbeans;

import ar.edu.unju.fi.apu.controlador.beans.ProductoBean;
import ar.edu.unju.fi.apu.dao.IProductoDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.ProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
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
    @ManagedProperty (value = "#{productoBean}")
    private ProductoBean productoBean;
    private UploadedFile archivo;
    private String precio;
    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
    }

    public ProductoBean getProductoBean() {
        return productoBean;
    }

    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }
    
    public List<Producto> obtenerProductos(){
        IProductoDAO productoDAO =new ProductoDAOImp();
        return productoDAO.obtenerTodos();
    }
    
    public void obtenerProducto (Producto producto){
        productoBean.setProducto(producto);
        RequestContext.getCurrentInstance().update("frmModificaProducto:dlgModificaProducto");
    }
    
    public void agregarProducto (){
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
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaAltaProducto').hide();PF('altaProducto').hide()");
    }
    
    public void eliminarProducto(){
        this.productoBean.getProducto().setEstado(false);
        IProductoDAO productoDAO = new ProductoDAOImp();
        productoDAO.bajaProducto(productoBean.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion concretada","Operacion concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaBajaProducto').hide()");
    }

    public void actualizarProducto(){
        IProductoDAO productoDAO = new ProductoDAOImp();
        try{
            if (archivo.getFileName().isEmpty()==false){
                InputStream inputStream = this.archivo.getInputstream();
                //voy leyendo el inputStream con el metodo read hasta que no haya mas datos
                //cuando llega al final .read retorna -1 y termina.
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] bytes = new byte[16384];
                while ((nRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                    buffer.write(bytes, 0, nRead);
                }
                //escribo fisicamente lo que pudiera quedar en almacen temporal
                buffer.flush();
                this.productoBean.getProducto().setFoto(buffer.toByteArray());
                //System.out.println(this.pacienteBean.getPaciente().getFoto().length);
            }
        }catch(Exception e){
        
        }
        //this.productoBean.getProducto().setEstado(true);
        productoDAO.modificarProducto(this.productoBean.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new  FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion Realizada", "Operacion Realizada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificaProducto').hide();PF('modificaProducto').hide()");
    }
    
    public void limpiarFormulario(){
        this.productoBean.setProducto(new Producto());
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
    
    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
}

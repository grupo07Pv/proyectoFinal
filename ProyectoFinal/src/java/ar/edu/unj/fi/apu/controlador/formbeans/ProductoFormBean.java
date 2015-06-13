/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.controlador.formbeans;

import ar.edu.unj.fi.apu.controlador.beans.ProductoBean;
import ar.edu.unj.fi.apu.dao.IProductoDAO;
import ar.edu.unj.fi.apu.dao.imp.mysql.ProductoDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Producto;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Ivan
 */
@ManagedBean
@RequestScoped
public class ProductoFormBean {
    @ManagedProperty (value = "#{productoBean}")
    private ProductoBean productoBean;
    private UploadedFile archivo;
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
    public void agregarProducto (){
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
    }
    
    public void eliminarProducto(){
        IProductoDAO productoDAO = new ProductoDAOImp();
        productoDAO.eliminarProducto(productoBean.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Operacion concretada","Operacion concretada"));
        RequestContext.getCurrentInstance().execute("PF('confirmaBajaProducto').hide()");
    }

    public void actualizarProducto(){
        IProductoDAO productoDAO = new ProductoDAOImp();
        try{
            InputStream inputStream = this.archivo.getInputstream();
        }catch(Exception e){
        
        }
    }
    
    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
}

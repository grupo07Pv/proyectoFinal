package ar.edu.unju.fi.apu.modelo.dominio;
// Generated 08/06/2015 18:13:05 by Hibernate Tools 4.3.1



/**
 *
 * @author Grupo 7 - VeGaMES
 */
public class Usuario  implements java.io.Serializable {


     private String nombreUsuario;
     private String password;
     private String nombreReal;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, String nombreReal) {
       this.nombreUsuario = nombreUsuario;
       this.password = password;
       this.nombreReal = nombreReal;
    }
   
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombreReal() {
        return this.nombreReal;
    }
    
    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }




}



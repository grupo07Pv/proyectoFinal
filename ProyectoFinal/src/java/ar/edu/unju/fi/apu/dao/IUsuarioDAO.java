package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Usuario;

/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IUsuarioDAO {
      public void agregarUsuario(Usuario usuario);
      public void modificarUsuario(Usuario usuario);     
      public Usuario obtenerUsuario(String nombreUsuario);
      public Usuario validarUsuario(String nombreUsuario, String password);
}

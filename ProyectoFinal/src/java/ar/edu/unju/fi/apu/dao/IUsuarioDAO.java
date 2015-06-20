package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Usuario;



/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IUsuarioDAO {
      public Usuario validarUsuario(String nombreUsuario, String password);
      public Usuario obtenerUsuario(String nombreUsuario);
}

package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Usuario;



/**
 *
 * @author Grupo 7 - VeGaMES
 */
public interface IUsuarioDAO {
      Usuario validarUsuario(String nombreUsuario, String password);
      Usuario obtenerUsuario(String nombreUsuario);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unj.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Usuario;



/**
 *
 * @author Ivan
 */
public interface IUsuarioDAO {
      Usuario validarUsuario(String nombreUsuario, String password);
      Usuario obtenerUsuario(String nombreUsuario);
}

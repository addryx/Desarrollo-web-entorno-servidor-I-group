package com.edix.eventos.modelo.repository;

import java.util.List;
import com.edix.eventos.modelo.beans.Usuario;


public interface IntUsuarioDao {
	
	List<Usuario> buscarTodos();
	Usuario findById(int idUsuario);
	
	int comprobarContraseña(String password);
	int comprobarUsuario (String usuario);
	int comprobarLogin (String password, String usuario);

}

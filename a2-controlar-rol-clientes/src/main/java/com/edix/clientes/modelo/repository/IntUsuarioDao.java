package com.edix.clientes.modelo.repository;

import java.util.List;
import com.edix.clientes.modelo.beans.Usuario;

public interface IntUsuarioDao {
	List<Usuario> buscarUsuarios();
	Usuario findById(int idUsuario);
	int comprobarLogin (String password, String usuario);
}

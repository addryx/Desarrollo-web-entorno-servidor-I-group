package com.edix.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.clientes.modelo.beans.Usuario;
/*
 * Con la etiqueta @Repository indicamos que es un repositorio de datos y que como lleva implicita la etiqueta
 * @Component estamos indicando que esta clase pasa a ser un componente de Spring
 */
@Repository
public class UsuarioDaoImpl implements IntUsuarioDao{

	private List<Usuario> listaUsuario;

	/*
	 * Creamos una lista con los usuarios, posteriormente la rellenamos con el método cargarDatos().
	 */
	public UsuarioDaoImpl() {
		listaUsuario = new ArrayList<>();
		cargarDatos();
	}
	//Creamos dos usuario para realizar las pruebas
	private void cargarDatos() {
		listaUsuario.add(new Usuario(1, "user1", "1234", "user1@gmail.com", "User1Prueba", "C/ del user1", 1, new Date()));
		listaUsuario.add(new Usuario(2, "user2", "5678", "user2@gmail.com", "User2Prueba", "C/ del user2", 1, new Date()));
	}
	
	@Override
	public List<Usuario> buscarUsuarios() {
		return listaUsuario;
	}
	
	public void setLista(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	/*
	 * Con este metodo retornamos un usario y le pasamos por parametros el idUsuario
	 * si el usuario no tiene valor retorna null, al contrario devuelve la listaUsuario
	 */
	@Override
	public Usuario findById(int idUsuario) {
		Usuario aux = new Usuario();
		aux.setIdUsuario(idUsuario);
		int pos = listaUsuario.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return (listaUsuario.get(pos));
		}
	}
	/*
	 * Con este metodo comprobamos el login del usuario. 
	 * le pasamos dos String (usuario y password), con un foreach recorremos la listaUsuario
	 * si el usuario y la contraseñas son validas devuelve '1', en caso contrario '0'
	 */
	// Tenemos dudas de si este método puede llegar a funcionar.
	@Override
    public int comprobarLogin(String password, String usuario) {
        for (Usuario user : listaUsuario) {
            if (user.getUsername().equals(usuario)) {
                if (user.getPassword().equals(password)) {
                    return 1;
                }
            }
        }
        return 0;
    }

}

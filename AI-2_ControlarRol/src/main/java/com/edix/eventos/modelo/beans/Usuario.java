package com.edix.eventos.modelo.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Usuario implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private String username;
	private String password;
	private String email;
	private String nombre;
	private String direccion;
	private int enabled;
	private Date fechaRegistro;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsuario, String username, String password, String email, String nombre, String direccion,
			int enabled, Date fechaRegistro) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.direccion = direccion;
		this.enabled = enabled;
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, email, enabled, fechaRegistro, idUsuario, nombre, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& enabled == other.enabled && Objects.equals(fechaRegistro, other.fechaRegistro)
				&& idUsuario == other.idUsuario && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", email="
				+ email + ", nombre=" + nombre + ", direccion=" + direccion + ", enabled=" + enabled
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
	
	

}

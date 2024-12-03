package com.educonecta.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id")
	private String usuarioId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="usu_apellidos")
	private String usuApellidos;

	@Column(name="usu_biografia")
	private String usuBiografia;

	@Column(name="usu_contrasena")
	private String usuContrasena;

	@Column(name="usu_correo")
	private String usuCorreo;

	@Lob
	@Column(name="usu_imgperfil")
	private byte[] usuImgperfil;

	@Column(name="usu_nombres")
	private String usuNombres;

	@Column(name="usu_status")
	private int usuStatus;



	public Usuario() {
	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsuApellidos() {
		return this.usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public String getUsuBiografia() {
		return this.usuBiografia;
	}

	public void setUsuBiografia(String usuBiografia) {
		this.usuBiografia = usuBiografia;
	}

	public String getUsuContrasena() {
		return this.usuContrasena;
	}

	public void setUsuContrasena(String usuContrasena) {
		this.usuContrasena = usuContrasena;
	}

	public String getUsuCorreo() {
		return this.usuCorreo;
	}

	public void setUsuCorreo(String usuCorreo) {
		this.usuCorreo = usuCorreo;
	}

	public byte[] getUsuImgperfil() {
		return this.usuImgperfil;
	}

	public void setUsuImgperfil(byte[] usuImgperfil) {
		this.usuImgperfil = usuImgperfil;
	}

	public String getUsuNombres() {
		return this.usuNombres;
	}

	public void setUsuNombres(String usuNombres) {
		this.usuNombres = usuNombres;
	}

	public int getUsuStatus() {
		return this.usuStatus;
	}

	public void setUsuStatus(int usuStatus) {
		this.usuStatus = usuStatus;
	}

	

}
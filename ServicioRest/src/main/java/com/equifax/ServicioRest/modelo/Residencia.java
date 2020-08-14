/**
 * 
 */
package com.equifax.ServicioRest.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

/**
 * Clase que representa la entidad Residencia
 * lugar donde vive
 * @author Sistemas nirvek
 *
 */
@Data
@Entity
@Table(name = "Residencia")
public class Residencia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idR;
	private String direccionR;
	private String numeroDeptR;
	private String casa_EdificioR;
	private String codigoResidencia;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idUsu")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;
	
	public Residencia() {
		// TODO Auto-generated constructor stub
	}

	
}

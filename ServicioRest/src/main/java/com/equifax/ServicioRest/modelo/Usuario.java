/**
 * 
 */
package com.equifax.ServicioRest.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

/**
 * Clase que representa la tabla Usuario
 * @author Sistemas nirvek
 *
 */


@Data
@Entity
@Table(name = "usuario")
//@NamedQuery(name = "Usuario.findByNombreU", query="Select u from Usuario u where u.nombreU = ?1")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idU;
	private String nombreU;
	private String rutU;
	
//	
//	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private Set<Residencia> residencia;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
}

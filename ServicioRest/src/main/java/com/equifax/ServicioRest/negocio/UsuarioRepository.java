/**
 * 
 */
package com.equifax.ServicioRest.negocio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equifax.ServicioRest.modelo.Usuario;

/**
 * interfaz que ofrece los metodos de crud en el negocio
 * @author Sistemas nirvek
 *
 */
public interface UsuarioRepository  extends JpaRepository<Usuario, String>{
	/**
	 * Definicion de metodo para buscar el usuario por su RUT
	 * @param rutU
	 * @return
	 */
	public Usuario findByRutU(String rutU);
	
	public Usuario findByNombreU(String nombreU);

}

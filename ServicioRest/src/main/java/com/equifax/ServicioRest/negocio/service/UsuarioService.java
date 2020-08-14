/**
 * 
 */
package com.equifax.ServicioRest.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equifax.ServicioRest.modelo.Usuario;
import com.equifax.ServicioRest.negocio.UsuarioRepository;

/**
 * Clase para definir los servicios del Usuario
 * @author Sistemas nirvek
 *
 */
@Service
@Transactional(readOnly = true)
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un usuario
	 * @param usuario
	 * @return
	 */
	@Transactional
	public Usuario create (Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	
	/**
	 * Metodo para realizar la operacion de actualizar un usuario
	 * @param usuario
	 * @return
	 */
	@Transactional
	public Usuario update (Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	/**
	 * Metodo para realizar la operacion de eliminar  un usuario
	 * @param usuario
	 * @return
	 */
	@Transactional
	public void delete (Usuario usuario) {
		this.usuarioRepository.delete(usuario);
	}
	
	
	/**
	 * Metodo para realizar la operacion de buscar  un usuario con el rut 
	 * @param usuario
	 * @return
	 */
	public Usuario findByRutU(String rutU){
		return this.usuarioRepository.findByRutU(rutU);
	}
	
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
}

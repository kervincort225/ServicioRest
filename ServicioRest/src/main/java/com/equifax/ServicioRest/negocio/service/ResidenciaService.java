/**
 * 
 */
package com.equifax.ServicioRest.negocio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equifax.ServicioRest.modelo.Residencia;
import com.equifax.ServicioRest.modelo.Usuario;
import com.equifax.ServicioRest.negocio.ResidenciaRepository;

/**
 * Clase para definir los servicios de Residencia
 * @author Sistemas nirvek
 *
 */
@Service
@Transactional(readOnly = true)
public class ResidenciaService {
	
	private final ResidenciaRepository residenciaRepository;
	
	public ResidenciaService(ResidenciaRepository residenciaRepository) {
		this.residenciaRepository = residenciaRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un residencia
	 * @param residencia
	 * @return
	 */
	@Transactional
	public Residencia create (Residencia residencia) {
		return this.residenciaRepository.save(residencia);
	}
	
	
	/**
	 * Metodo para realizar la operacion de actualizar un residencia
	 * @param residencia
	 * @return
	 */
	@Transactional
	public Residencia update (Residencia residencia) {
		return this.residenciaRepository.save(residencia);
	}
	
	/**
	 * Metodo para realizar la operacion de eliminar  un residencia
	 * @param residencia
	 * @return
	 */
	@Transactional
	public void delete (Residencia residencia) {
		this.residenciaRepository.delete(residencia);
	}
	
	
	/**
	 * Metodo para buscar una Residencia
	 * @param codigoResidencia
	 * @return
	 */
	public Residencia findByCodigoResidencia(String codigoResidencia){
		return this.residenciaRepository.findByCodigoResidencia(codigoResidencia);
	}
	
	
	public List<Residencia> findAll(){
		return this.residenciaRepository.findAll();
	}

}

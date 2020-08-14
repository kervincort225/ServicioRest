/**
 * 
 */
package com.equifax.ServicioRest.negocio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.equifax.ServicioRest.modelo.Residencia;
import com.equifax.ServicioRest.modelo.Usuario;

/**
 * 
 * interfaz que ofrece los metodos de crud en el negocio para residencia
 * @author Sistemas nirvek
 *
 */
public interface ResidenciaRepository extends JpaRepository<Residencia, String> {
	
//	/**
//	 * Método para consultar las reservas por cliente
//	 * 
//	 * @param cliente
//	 * @return
//	 */
//	@Query("Select r from Reserva r where r.usuario =:usuario")
//	public List<Residencia> findByUsuario(Usuario Usuario);
	

	
	/**
	 * Definición de método para buscar una reserva por su código
	 * @param codigoReserva
	 * @return
	 */
	public Residencia findByCodigoResidencia(String codigoResidencia);
	
}

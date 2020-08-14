/**
 * 
 */
package com.equifax.ServicioRest.vo;

import lombok.Data;

/**
 * CLASE VO de residencia que representa los datos visualmente 
 * @author Sistemas nirvek
 *
 */
@Data
public class ResidenciaVo {

	private String direccionR;
	private String numeroDeptR;
	private String casa_EdificioR;
	private String codigoResidencia;
	private PrimaryConsumer primaryConsumer;
	
	
}

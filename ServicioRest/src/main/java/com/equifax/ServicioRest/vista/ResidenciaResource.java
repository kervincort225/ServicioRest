/**
 * 
 */
package com.equifax.ServicioRest.vista;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equifax.ServicioRest.modelo.Residencia;
import com.equifax.ServicioRest.modelo.Usuario;
import com.equifax.ServicioRest.negocio.service.ResidenciaService;
import com.equifax.ServicioRest.negocio.service.UsuarioService;
import com.equifax.ServicioRest.vo.ResidenciaVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Sistemas nirvek
 *
 */

@RestController
@RequestMapping("/api/residencia")
@Api(tags = "residencia")
public class ResidenciaResource {
	
	private final ResidenciaService residenciaService;
	private final UsuarioService usuarioService;
	
	
	public ResidenciaResource(ResidenciaService residenciaService, UsuarioService usuarioService) {
		this.residenciaService  = residenciaService;
		this.usuarioService = usuarioService;
	}
	
//	@PutMapping("/{codigoResidencia}")
//	@ApiOperation(value = "Actualizar Reserva", notes = "Servicio para actualizar una reserva")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
//			@ApiResponse(code = 404, message = "Reserva no encontrada") })
//	public ResponseEntity<Residencia> updateResidencia(@PathVariable("codigoResidencia") String codigoResidencia,
//			ResidenciaVo residenciaVO) {
//
//		Residencia residencia = this.residenciaService.findByCodigoResidencia(codigoResidencia);
//		if (residencia == null) {
//			return new ResponseEntity<Residencia>(HttpStatus.NOT_FOUND);
//		} else {
//			Usuario usuario = usuarioService.findByIdentificacion(reservaVO.getCliente().getIdentificacionCli());
//			reserva.setCliente(cliente);
//			reserva.setCantidadPersonasRes(reservaVO.getCantidadPersonasRes());
//			reserva.setDescripcionRes(reservaVO.getDescripcionRes());
//		}
//		return new ResponseEntity<>(this.reservaService.update(reserva), HttpStatus.OK);
//	}

	@DeleteMapping("/{codigoResidencia}")
	@ApiOperation(value = "Eliminar Residencia", notes = "Servicio para eliminar una residencia")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "residencia eliminada correctamente"),
			@ApiResponse(code = 404, message = "residencia no encontrada") })
	public void removeResidencia(@PathVariable("codigoResidencia") String codigoResidencia) {
		Residencia residencia = this.residenciaService.findByCodigoResidencia(codigoResidencia);
		if (residencia != null) {
			this.residenciaService.delete(residencia);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Residencia", notes = "Servicio para listar todas las Residencia")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Residencias encontrados"),
			@ApiResponse(code = 404, message = "Residencia no encontrados") })
	public ResponseEntity<List<Residencia>> findAll() {
		return ResponseEntity.ok(this.residenciaService.findAll());
	}
	
	
	
	//LOGICA PARA INSERTAR UNA RESERVA SI EXISTE UN CLIENTE 
	@PostMapping("/{rutU}")
	@ApiOperation(value = "Crear Residencia", notes = "Servicio para crear un nueva residencia, con cliente creado")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Residencia creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Residencia> createResidencia( @PathVariable(value = "rutU") String rutU, @RequestBody ResidenciaVo residenciaVO){
		Usuario usuario = usuarioService.findByRutU(rutU.toString());
		if (usuario != null) {
			Residencia residencia = new Residencia();
			residencia.setUsuario(usuario);
			residencia.setCasa_EdificioR(residenciaVO.getCasa_EdificioR());
			residencia.setDireccionR(residenciaVO.getDireccionR());
			residencia.setNumeroDeptR(residenciaVO.getNumeroDeptR());
			residencia.setCodigoResidencia(residenciaVO.getCodigoResidencia());
			return new ResponseEntity<>(this.residenciaService.create(residencia), HttpStatus.CREATED);
		}
		return new ResponseEntity<Residencia>(HttpStatus.NOT_FOUND);		
	}
	

}

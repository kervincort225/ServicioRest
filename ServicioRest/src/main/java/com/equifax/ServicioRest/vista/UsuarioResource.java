/**
 * 
 */
package com.equifax.ServicioRest.vista;

import java.util.HashMap;
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

import com.equifax.ServicioRest.modelo.Usuario;
import com.equifax.ServicioRest.negocio.service.UsuarioService;
import com.equifax.ServicioRest.vo.UsuarioVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de usuario
 * @author Sistemas nirvek
 *
 */

@RestController
@RequestMapping("/api/usuario")
@Api(tags = "usuario")
public class UsuarioResource {

	
	private final UsuarioService usuarioService;
	
	public UsuarioResource(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	/**
	 * Metodo para insertar un usuario
	 * @param usuariovo
	 * @return
	 */
	@PostMapping
	@ApiOperation(value = "Crear Usuario", notes = "Servicio para crear un nuevo Usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Usuario> createUsuario (@RequestBody UsuarioVO usuariovo){
		Usuario usuario = new Usuario();
		usuario.setNombreU(usuariovo.getAplication().getPrimaryConsumer().getNombreU());
		usuario.setRutU(usuariovo.getAplication().getPrimaryConsumer().getRutU());
		
		return new ResponseEntity<>(this.usuarioService.create(usuario), HttpStatus.CREATED);
	}
	
	/**
	 * servicio web para actualizar un  usuario
	 * @param rut
	 * @param usuariovo
	 * @return
	 */
	@PutMapping("/{rut}")
	@ApiOperation(value = "Actualizar Usuario", notes = "Servicio para actualizar un Usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario actualizado correctamente"),
			@ApiResponse(code = 404, message = "Usuario no encontrado") })
	public ResponseEntity<Usuario> updateUsuario (@PathVariable("rut") String rut, UsuarioVO usuariovo){
		
		Usuario usuario = this.usuarioService.findByRutU(rut);	
		if(usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);		
		}else {
			usuario.setNombreU(usuariovo.getAplication().getPrimaryConsumer().getNombreU());
			usuario.setRutU(usuariovo.getAplication().getPrimaryConsumer().getRutU());
		}
		return new ResponseEntity<>(this.usuarioService.update(usuario), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{rut}")
	@ApiOperation(value = "Eliminar Usuario", notes = "Servicio para eliminar un Usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario eliminado correctamente"),
			@ApiResponse(code = 404, message = "Usuario no encontrado") })
	public void removeUsuario (@PathVariable("rut") String rut) {
		Usuario usuario = this.usuarioService.findByRutU(rut);
			if(usuario != null) {
				this.usuarioService.delete(usuario);
			}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Usuarios", notes = "Servicio para listar todos los usuarios")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "usuarios encontrados"),
			@ApiResponse(code = 404, message = "usuarios no encontrados") })
	public ResponseEntity<List<Usuario>> findAll(){
		return  ResponseEntity.ok(this.usuarioService.findAll());
	}
	
	
	@GetMapping("/{rut}")
	@ApiOperation(value = "Rut Usuario", notes = "Servicio encontrar el usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "usuario encontrado"),
			@ApiResponse(code = 404, message = "usuario no encontrado") })
	public ResponseEntity<Usuario> findByRutU(@PathVariable("rut") String rut){
		return  ResponseEntity.ok(this.usuarioService.findByRutU(rut));
	}
	
}

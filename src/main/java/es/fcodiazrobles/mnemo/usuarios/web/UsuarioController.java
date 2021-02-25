package es.fcodiazrobles.mnemo.usuarios.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.fcodiazrobles.mnemo.usuarios.business.UsuarioService;
import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.util.UsuariosException;
import es.fcodiazrobles.mnemo.usuarios.util.Utils;
import es.fcodiazrobles.mnemo.usuarios.web.dto.Response;
import es.fcodiazrobles.mnemo.usuarios.web.dto.ResponseHeader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Usuario Controller", produces = "application/json", tags = "Controlador para operaciones de Usuario")
public class UsuarioController extends AbstractController{

	@Autowired
	UsuarioService usuarioService;

	/**
	 * Obtener el usuario
	 * 
	 * @param idSolicitud
	 * @return documento obtenido
	 */

	@ApiOperation(value = "Consulta de usuarios", notes = "Obtiene una lista de usuarios pageable a partir de unos criterios")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario obtenido"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Error obteniendo Documento", response = UsuariosException.class) })
	@GetMapping("/usuario")
	public Response<List<Usuario>> getDocumentByIdSolicitud() {
		Response<List<Usuario>> response = Response.<List<Usuario>>builder().build();
		try {
			List<Usuario> result = null;
			response.setHeader(Utils.processHeader(result));
			response.setBody(result);
		} catch (Exception e) {
			response.setHeader(ResponseHeader.builder().http_code(HttpStatus.CONFLICT.value())
					.message("Error al obtener el documento " + e.getMessage()).error(Boolean.TRUE).build());
		}
		return response;
	}
}

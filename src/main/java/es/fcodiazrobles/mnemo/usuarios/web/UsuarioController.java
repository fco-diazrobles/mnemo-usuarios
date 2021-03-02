package es.fcodiazrobles.mnemo.usuarios.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.fcodiazrobles.mnemo.usuarios.business.UsuarioService;
import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.util.UsuariosException;
import es.fcodiazrobles.mnemo.usuarios.util.Utils;
import es.fcodiazrobles.mnemo.usuarios.web.dto.FiltroUsuarioDTO;
import es.fcodiazrobles.mnemo.usuarios.web.dto.Response;
import es.fcodiazrobles.mnemo.usuarios.web.dto.ResponseHeader;
import es.fcodiazrobles.mnemo.usuarios.web.dto.UsuarioDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Usuario Controller", produces = "application/json", tags = "Controlador para operaciones de Usuario")
public class UsuarioController extends AbstractController{

	@Autowired
	UsuarioService usuarioService;

	/**
	 * Obtener lista de usuarios
	 * 
	 * @param Filtro de la lista
	 * @return usuario obtenido
	 */

	@ApiOperation(value = "Consulta de usuarios", notes = "Obtiene una lista de usuarios paginada a partir de unos criterios")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario obtenido"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Error obteniendo Usuario", response = UsuariosException.class) })
	@GetMapping("/usuario")
	public Response<List<UsuarioDTO>> findAll(@ApiParam(name="filtro", example="{}") FiltroUsuarioDTO filtro) {
		Response<List<UsuarioDTO>> response = Response.<List<UsuarioDTO>>builder().build();
		try {
			List<UsuarioDTO> result = usuarioService.findAll(filtro);
			response.setHeader(Utils.processHeader(result));
			response.setBody(result);
		} catch (Exception e) {
			response.setHeader(ResponseHeader.builder().http_code(HttpStatus.CONFLICT.value())
					.message("Error al obtener la lista de usuarios " + e.getMessage()).error(Boolean.TRUE).build());
		}
		return response;
	}

    /**
     * Obtener el usuario por su ID
     * 
     * @param id ID del usuario
     * @return Usuario obtenido
     */

    @ApiOperation(value = "Consulta de usuario", notes = "Obtiene un un usuario por su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario obtenido"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Error obteniendo Usuario", response = UsuariosException.class) })
    @GetMapping("/usuario/{id}")
    public Response<UsuarioDTO> findById(@ApiParam(name = "id", example = "1") @PathVariable Long id) {
        Response<UsuarioDTO> response = Response.<UsuarioDTO>builder().build();
        try {
            UsuarioDTO result = usuarioService.findById(id);
            response.setHeader(Utils.processHeader(result));
            response.setBody(result);
        } catch (Exception e) {
            response.setHeader(ResponseHeader.builder().http_code(HttpStatus.CONFLICT.value())
                    .message("Error al obtener el usuario" + e.getMessage()).error(Boolean.TRUE).build());
        }
        return response;
    }
}

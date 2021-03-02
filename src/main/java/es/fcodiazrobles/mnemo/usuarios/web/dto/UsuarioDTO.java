package es.fcodiazrobles.mnemo.usuarios.web.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import es.fcodiazrobles.mnemo.usuarios.domain.Grupo;
import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.util.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * DTO de Usuario
 * 
 * @author Francisco José Díaz Robles
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    /**
     * ID identificador numérico
     */
    private Long id;

    /**
     * Nombre del usuario
     */
    @Size(max = Constantes.MAX_LENGTH_USUARIO_USERNAME)
    private String username;
    
    /**
     * Apellidos del usuario
     */
    @Size(max = Constantes.MAX_LENGTH_USUARIO_LASTNAME)
    private String lastname;
    
    /**
     * Identificador personal alfanumérico
     */
    @Size(max = Constantes.MAX_LENGTH_USUARIO_CODE)
    private String code;
    
    /**
     * Grupos a los que pertenece el usuario
     */
    private List<GrupoDTO> grupos;

}
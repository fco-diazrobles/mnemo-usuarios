package es.fcodiazrobles.mnemo.usuarios.web.dto;

import java.util.List;

import es.fcodiazrobles.mnemo.usuarios.domain.Grupo;
import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
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
    private String username;
    
    /**
     * Apellidos del usuario
     */
    private String lastname;
    
    /**
     * Identificador personal alfanumérico
     */
    private String code;
    
    /**
     * Grupos a los que pertenece el usuario
     */
    private List<GrupoDTO> grupos;

}
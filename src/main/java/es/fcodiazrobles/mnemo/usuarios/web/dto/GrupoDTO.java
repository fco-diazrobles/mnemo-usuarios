package es.fcodiazrobles.mnemo.usuarios.web.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import es.fcodiazrobles.mnemo.usuarios.util.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * DTO de Grupo
 * 
 * @author Francisco José Díaz Robles
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDTO {
    /**
     * ID identificador numérico
     */
    private Long id;

   /**
    * Nombre del grupo
    */
    @Max(Constantes.MAX_LENGTH_GRUPO_NOMBRE)
    private String name;
}
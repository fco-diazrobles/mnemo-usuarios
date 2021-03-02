package es.fcodiazrobles.mnemo.usuarios.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.fcodiazrobles.mnemo.usuarios.util.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entidad de la tabla USUARIO
 * 
 * @author Francisco José Díaz Robles
 */
@Entity
@Table(name = "GRUPO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupo implements Serializable{
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 5376769370030265931L;

    /**
     * ID identificador numérico
     */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Nombre del grupo
     */
    @Column(name = "NOMBRE")
    @Size(max = Constantes.MAX_LENGTH_GRUPO_NOMBRE)
    private String name;    
    
    @JsonIgnore
    @ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

}
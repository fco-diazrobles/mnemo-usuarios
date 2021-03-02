package es.fcodiazrobles.mnemo.usuarios.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

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
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -625333449278461526L;

    /**
     * ID identificador numérico
     */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Nombre del usuario
     */
    @Size(max = Constantes.MAX_LENGTH_USUARIO_USERNAME)
    @Column(name = "USERNAME")
    private String username;
    
    /**
     * Apellidos del usuario
     */
    @Size(max = Constantes.MAX_LENGTH_USUARIO_LASTNAME)
    @Column(name = "LASTNAME")
    private String lastname;
    
    /**
     * Identificador personal alfanumérico
     */
    @Size(max = Constantes.MAX_LENGTH_USUARIO_CODE)
    @Column(name = "CODE")
    private String code;
    
    /**
     * Grupos a los que pertenece el usuario
     */
    
    @JoinTable(
            name = "USUARIO_GRUPO",
            joinColumns = @JoinColumn(name = "id_grupo", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_usuario", nullable = false)
        )
    @ManyToMany
    private List<Grupo> grupos;

}
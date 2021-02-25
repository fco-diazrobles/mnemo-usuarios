package es.fcodiazrobles.mnemo.usuarios.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
public class Usuario {
    /**
     * ID identificador numérico
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * Nombre del usuario
     */
    @Column(name = "USERNAME")
    private String username;
    
    /**
     * Apellidos del usuario
     */
    @Column(name = "LASTNAME")
    private String lastname;
    
    /**
     * Identificador personal alfanumérico
     */
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
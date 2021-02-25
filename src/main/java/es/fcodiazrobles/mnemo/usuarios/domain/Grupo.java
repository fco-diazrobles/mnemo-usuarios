package es.fcodiazrobles.mnemo.usuarios.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "GRUPO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {
    /**
     * ID identificador numérico
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * Nombre del grupo
     */
    @Column(name = "NOMBRE")
    private String name;
    
    @ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

}
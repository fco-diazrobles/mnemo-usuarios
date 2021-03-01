package es.fcodiazrobles.mnemo.usuarios.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@ApiModel(value = "Filtro del objeto usuario", description = "Contiene los valores del filtro en la busqueda de usuarios")
public class FiltroUsuarioDTO extends AbstractFiltroDTO implements Specification<Usuario>{
    
    @ApiModelProperty("ID del usuario")
    private Long id;
    @ApiModelProperty("Nombre de usuario")
    private String username;
    @ApiModelProperty("Apellidos del usuario")
    private String lastname; 
    @ApiModelProperty("Código del usuario")
    private String code;
    
    @Override
    public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> filters = new ArrayList<>();

        if(id != null) {
            filters.add(criteriaBuilder.equal(root.get("id"), id));
        }
        
        
//        if (criteria != null) {
//            if (criteria.getNif() != null && !criteria.getNif().isEmpty()) {
//                filters.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("nif")),
//                        "%" + criteria.getNif().toUpperCase() + "%"));
//            }
//
//            if (criteria.getNombreCompleto() != null && !criteria.getNombreCompleto().isEmpty()) {
//                filters.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("nombreCompleto")),
//                        "%" + criteria.getNombreCompleto().toUpperCase() + "%"));
//            }
//        }

        return criteriaBuilder.and(filters.toArray(new Predicate[filters.size()]));
    }    
    
}

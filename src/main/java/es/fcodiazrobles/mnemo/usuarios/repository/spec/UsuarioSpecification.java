package es.fcodiazrobles.mnemo.usuarios.repository.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;

public class UsuarioSpecification implements Specification<Usuario>{
    
    @Override
    public Predicate toPredicate(Root<Usuario> root, CriteriaQuery query, CriteriaBuilder cb) {
        return cb.equal(root.get("id"), 1L);
    }
  
  }
package es.fcodiazrobles.mnemo.usuarios.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.repository.spec.Specification;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    public List<Usuario> findAll(Specification<Usuario> filtro, Pageable page);
}

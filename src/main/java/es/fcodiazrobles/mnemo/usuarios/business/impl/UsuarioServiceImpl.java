package es.fcodiazrobles.mnemo.usuarios.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.fcodiazrobles.mnemo.usuarios.business.UsuarioService;
import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.repository.UsuarioRepository;
import es.fcodiazrobles.mnemo.usuarios.web.dto.FiltroUsuarioDTO;

/**
 * Implementanción de UsuarioService
 * 
 * @author Francisco José Díaz Robles
 *
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll(FiltroUsuarioDTO filtro) {        
        Pageable page = PageRequest.of(filtro.getOffset(), filtro.getLimit(), Sort.Direction.fromString(filtro.getDirectionSort()), filtro.getCampoSort());
        return usuarioRepository.findAll(filtro, page).toList();
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> result = usuarioRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }
   
}

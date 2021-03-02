package es.fcodiazrobles.mnemo.usuarios.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.fcodiazrobles.mnemo.usuarios.business.UsuarioService;
import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.repository.UsuarioRepository;
import es.fcodiazrobles.mnemo.usuarios.util.ValidationException;
import es.fcodiazrobles.mnemo.usuarios.web.dto.FiltroUsuarioDTO;
import es.fcodiazrobles.mnemo.usuarios.web.dto.UsuarioDTO;

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
    
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<UsuarioDTO> findAll(FiltroUsuarioDTO filtro) {        
        Pageable page = PageRequest.of(filtro.getOffset(), filtro.getLimit(), Sort.Direction.fromString(filtro.getDirectionSort()), filtro.getCampoSort());
        
        List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
        for(Usuario u : usuarioRepository.findAll(filtro, page).toList()) {
            usuariosDTO.add(mapper.convertValue(u, UsuarioDTO.class));
        }
       
        return usuariosDTO;
    }

    @Override
    public UsuarioDTO findById(Long id) {
        Optional<Usuario> result = usuarioRepository.findById(id);
        if(result.isPresent()) {
            return mapper.convertValue(result.get(), UsuarioDTO.class);
        }
        return null;
    }
    
    public UsuarioDTO create(UsuarioDTO usuario) throws ValidationException {
        if(usuario.getId() != null) {
            throw new ValidationException("EL usuario a crear debe tener la ID a null");
        }
        return save(usuario);
    }    
    
    
    /**
     * PRIVATE METHODS
     */
    
    private UsuarioDTO save(UsuarioDTO usuario){
        return mapper.convertValue(usuarioRepository.save(mapper.convertValue(usuario, Usuario.class)), UsuarioDTO.class);
    }
   
}

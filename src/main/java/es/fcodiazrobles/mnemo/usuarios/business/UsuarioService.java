package es.fcodiazrobles.mnemo.usuarios.business;

import java.util.List;

import org.springframework.stereotype.Service;

import es.fcodiazrobles.mnemo.usuarios.domain.Usuario;
import es.fcodiazrobles.mnemo.usuarios.web.dto.FiltroUsuarioDTO;
import es.fcodiazrobles.mnemo.usuarios.web.dto.UsuarioDTO;

/**
 * Service para operaciones en BD de la Tabla Usuario
 * 
 * @author Francisco José Díaz Robles
 *
 */
@Service
public interface UsuarioService {

    List<UsuarioDTO> findAll(FiltroUsuarioDTO filtro);
    
    UsuarioDTO findById(Long id);
    
}

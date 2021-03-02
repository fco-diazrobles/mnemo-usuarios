package es.fcodiazrobles.mnemo.usuarios.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import es.fcodiazrobles.mnemo.usuarios.web.dto.ResponseHeader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("Utils")
public class Utils {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Obtiene un texto del fichero de propiedades de mensajes, incluye argumentos
     * 
     * @param texto  Key del mensaje
     * @param params argumentos del mensaje
     * @return Mensaje
     */
    public static String getText(String texto, Object[] params) {
        try {
            return messageSource.getMessage(texto, params, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            log.error(e.getMessage());
            return "???" + texto + "???";
        }
    }

    /**
     * Obtiene un texto del fichero de propiedes de mensajes
     * 
     * @param texto Key del mensaje
     * @return Mensaje
     */
    public static String getText(String texto) {
        return getText(texto, null);
    }

    /**
     * Procesa el resultado para obtener una cabecera de respuesta
     * 
     * @param result resultado de la operacion de negocio
     * @return header para el response
     */
    public static ResponseHeader processHeader(Object result) {
        if (result == null) {
            return ResponseHeader.builder().http_code(HttpStatus.NOT_FOUND.value()).message("").error(Boolean.TRUE)
                    .build();
        } else if (result instanceof List && ((List) result).size() == 0) {
            return ResponseHeader.builder().http_code(HttpStatus.NOT_FOUND.value()).message("").error(Boolean.TRUE)
                    .build();
        } else if(result.getClass().equals(char.class) && (char)result == Constantes.OP_VOID_DELETE) {
            return ResponseHeader.builder().http_code(HttpStatus.OK.value()).message("").error(Boolean.FALSE).build();
        }else {
            return ResponseHeader.builder().http_code(HttpStatus.OK.value()).message("").error(Boolean.FALSE).build();
        }
    }
    
    /**
     * Procesa los errores al validar beans de Java en el Controller de Spring
     * @param errors Erores del controlador de Spring
     * @throws ValidationException Devuelve una Excepcion de Validacion si existen errores.
     */
    public static void processValidationErrors(Errors errors) throws ValidationException {
        if(errors.hasErrors()) {
            String errores = "";
            for(ObjectError e : errors.getAllErrors()) {
                errores= errores.concat("El campo " + ((DefaultMessageSourceResolvable) e.getArguments()[0]).getDefaultMessage() + " "+ e.getDefaultMessage() + ". ");
            }
          throw new ValidationException(errores);   
        }
    }

}

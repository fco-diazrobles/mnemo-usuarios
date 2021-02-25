package es.fcodiazrobles.mnemo.usuarios.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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
        } else {
            return ResponseHeader.builder().http_code(HttpStatus.OK.value()).message("").error(Boolean.FALSE).build();
        }
    }

}

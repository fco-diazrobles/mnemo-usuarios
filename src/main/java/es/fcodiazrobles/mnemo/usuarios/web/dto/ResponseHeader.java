package es.fcodiazrobles.mnemo.usuarios.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Cabecera de la respuesta de la peticion", description = "Cabecera de la respuesta de la peticion que contiene los mensajes si los hubiera")
public class ResponseHeader {
    @ApiModelProperty("Indica si existen errores en la peticion")
    private Boolean error;
    @ApiModelProperty("Indica el mensaje en caso de error")
    private String message;
    @ApiModelProperty("Indica el codigo de respuesta")
    private Integer http_code;
}

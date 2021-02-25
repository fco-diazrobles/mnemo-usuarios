package es.fcodiazrobles.mnemo.usuarios.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Respuesta de la peticion", description = "Contiene los datos de la respuesta de la peticion en una cabecera y un body")
public class Response<T> {
    @ApiModelProperty("Cabecera de la respuesta")
    private ResponseHeader header;
    @ApiModelProperty("Cuerpo de la respuesta")
    private T body;
}

package es.fcodiazrobles.mnemo.usuarios.web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Filtro general", description = "Contiene los valores del filtro en las busquedas")
public abstract class AbstractFiltroDTO {
    @ApiModelProperty(name="offset", value = "Numero de pagina de los resultados", example = "0", required = true)
    @NotBlank
    @Min(0)
    private Integer offset;
    @ApiModelProperty(name="limit", value = "Tamaño de la pagina de los resultados", example = "01", required = true)
    @NotBlank
    @Min(1)
    private Integer limit;
    @ApiModelProperty(name= "directionSort", value = "Direction en la que se ordena", example = "ASC", required = true)
    @NotBlank
    private String directionSort;
    @ApiModelProperty(name = "campoSort", value = "Campo en el que se ordena", example = "id", required = true)
    @NotBlank
    private String campoSort;
}

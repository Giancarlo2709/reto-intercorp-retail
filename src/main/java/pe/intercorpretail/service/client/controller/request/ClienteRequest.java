package pe.intercorpretail.service.client.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClienteRequest {
	
	@NotNull
	@ApiModelProperty(notes="Nombre", required = true)
	private String nombre;
	
	@NotNull
	@ApiModelProperty(notes="Apellido", required = true)
	private String apellido;
	
	@NotNull
	@Past
	@ApiModelProperty(notes="Fecha de nacimiento debe ser menor a la fecha actual y en formato yyyy-MM-dd", required = true)
	private LocalDate fechaNacimiento;

}

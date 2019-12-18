package pe.intercorpretail.service.client.controller.request;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClienteRequest {
	
	private String nombre;
	private String apellido;
	
	@ApiModelProperty(notes="Fecha de nacimiento debe ser menor a la fecha actual y en formato yyyy-MM-dd")
	private LocalDate fechaNacimiento;

}

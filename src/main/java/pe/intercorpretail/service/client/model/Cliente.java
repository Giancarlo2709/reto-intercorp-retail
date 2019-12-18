package pe.intercorpretail.service.client.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ApiModel(description = "Informacion del cliente")
@JsonInclude(value = Include.NON_NULL)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ApiModelProperty(notes = "Nombre")
	private String nombre;
	
	@NotNull
	@ApiModelProperty(notes = "Apellido")
	private String apellido;
	
	@NotNull
	@ApiModelProperty(notes="Edad")
	private Integer edad;
	
	@Past
	@ApiModelProperty(notes="Fecha de nacimiento debe ser menor a la fecha actual")
	@Column(name="fecha_nacimiento")
	@NotNull
	private LocalDate fechaNacimiento;
	
	@Transient
	@ApiModelProperty(notes="Fecha de probable de fallecimiento")
	private LocalDate fechaProbableFallecimiento;

}

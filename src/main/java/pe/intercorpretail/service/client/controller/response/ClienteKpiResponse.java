package pe.intercorpretail.service.client.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteKpiResponse {
	
	private double promedioEdad;
	private double desviacionEstandar;

}

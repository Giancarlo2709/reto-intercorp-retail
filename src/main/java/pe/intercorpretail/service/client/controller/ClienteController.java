package pe.intercorpretail.service.client.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.intercorpretail.service.client.controller.request.ClienteRequest;
import pe.intercorpretail.service.client.controller.response.ClienteKpiResponse;
import pe.intercorpretail.service.client.model.Cliente;
import pe.intercorpretail.service.client.service.ClienteService;
import pe.intercorpretail.service.client.util.AppUtil;
import pe.intercorpretail.service.client.util.Constantes;
import pe.intercorpretail.service.client.util.DateUtil;
import pe.intercorpretail.service.client.util.ModelMapperUtil;

@RestController
public class ClienteController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping("/creacliente")
	public ResponseEntity<Cliente> creaCliente(@Valid @RequestBody ClienteRequest clienteRequest){
		LOGGER.info("guardando cliente: " + clienteRequest.toString());
		Cliente clienteBd = this.clienteService.crearCliente(ModelMapperUtil.map(clienteRequest, Cliente.class));
		return new ResponseEntity<Cliente>(clienteBd, HttpStatus.CREATED);
	}
	
	@GetMapping("/kpideclientes")
	public ClienteKpiResponse getClienteKpi(){
		
		List<Cliente> clientes = this.clienteService.listarClientes();
		
		if(Objects.nonNull(clientes) && !clientes.isEmpty()) {		
			double promedioEdades = AppUtil.calcularPromedio(clientes);
			double desviacionEstandar = AppUtil.calcularDesviacionEstandar(clientes, promedioEdades);
			
			return ClienteKpiResponse.builder()
					.promedioEdad(promedioEdades)
					.desviacionEstandar(desviacionEstandar)
					.build();
		}
		
		return ClienteKpiResponse.builder().build();
	}
	
	@GetMapping("/listclientes")
	public List<Cliente> getListClientes(){
		
		List<Cliente> clientes = this.clienteService.listarClientes();
		
		clientes.forEach(cliente -> 
			cliente.setFechaProbableFallecimiento(DateUtil.calcularFechaDeceso(cliente.getEdad(), Constantes.ESPERANZA_VIDA))
		);
		
		return clientes;
	}

}

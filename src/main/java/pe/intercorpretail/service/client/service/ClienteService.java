package pe.intercorpretail.service.client.service;

import java.util.List;

import pe.intercorpretail.service.client.model.Cliente;

public interface ClienteService {
	
	Cliente crearCliente(Cliente cliente);
	
	List<Cliente> listarClientes();

}

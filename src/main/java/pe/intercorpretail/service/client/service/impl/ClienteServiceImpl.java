package pe.intercorpretail.service.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.intercorpretail.service.client.model.Cliente;
import pe.intercorpretail.service.client.repository.ClienteRepository;
import pe.intercorpretail.service.client.service.ClienteService;
import pe.intercorpretail.service.client.util.DateUtil;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		cliente.setEdad(DateUtil.calcularEdad(cliente.getFechaNacimiento()));
		return this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		return this.clienteRepository.findAll();
	}

}

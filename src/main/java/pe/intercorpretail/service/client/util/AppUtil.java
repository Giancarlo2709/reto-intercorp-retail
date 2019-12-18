package pe.intercorpretail.service.client.util;

import java.util.List;

import pe.intercorpretail.service.client.model.Cliente;

public class AppUtil {
	
	private AppUtil() {
		super();
	}
	
	public static double calcularPromedio(List<Cliente> clientes) {
		return clientes.stream().mapToInt(Cliente::getEdad).average().getAsDouble();
	}
	
	public static double calcularDesviacionEstandar(List<Cliente> clientes, double promedio) {
		
		double desviacionEstandar = 0.0;
		
		for (Cliente cliente : clientes) {
			desviacionEstandar += Math.pow(cliente.getEdad() - promedio, 2);
		}
		
		return Math.sqrt(desviacionEstandar / clientes.size());
	}

}

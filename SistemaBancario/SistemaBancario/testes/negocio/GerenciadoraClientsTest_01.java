package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientsTest_01 {
	
	@Test
	public void testPesquisaCliente() {
		//criando alguns clientes
		Cliente cliente01 = new Cliente(1, "David Teixeira de Masin", 29, "davidteixeira.info@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(3, "Felipe Jubileu", 24, "felipejubileu@gmail.com", 2, true);
	
		//inserindo os clientes criados numa lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		
		//instanciando a GerenciadoraClientes
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//acionando o método pesquisaCliente() da GerenciadoraClientes
		Cliente cliente = gerClientes.pesquisaCliente(2); 
		
		//Verificações
		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getEmail(), is("felipeaugusto@gmail.com"));
		
	}

}


package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientsTest_07 {
	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	private int idCliente03 = 3;
	
	//Este m�todo ocorre antes dos m�todos de teste
	@Before
	public void setUp() {
		/* ======== MONTAGEM DO CEN�RIO ======== */
		
		//criando alguns clientes
				
		Cliente cliente01 = new Cliente(idCliente01, "David Teixeira de Masin", 29, "davidteixeira.info@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Jubileu da Silva Xablau", 34, "xablau@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(idCliente03, "Irineu Silva", 24, "irineu@gmail.com", 2, true);
	
		//inserindo os clientes criados numa lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		
		//instanciando a classe GerenciadoraClientes
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}
	
	@After
	public void tearDown() {
		gerClientes.limpa();
	}	
	
	
	
	/*
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author David Teixeira 
	 * @date 25/11/21
	 */
	
	@Test
	public void testPesquisaCliente() {
			
		
		/* ======== EXECU��O ======== */
		
		//acionando o m�todo pesquisaCliente() da GerenciadoraClientes
		Cliente cliente = gerClientes.pesquisaCliente(idCliente02); 
		
		
		/* ======== VERIFICA��ES ======== */
		
		assertThat(cliente.getId(), is(idCliente02));
		assertThat(cliente.getEmail(), is("xablau@gmail.com"));
			
		
	}
	
	/*
	 * Teste b�sico da remo��o de um cliente a partir do seu ID
	 * 
	 * @author David Teixeira 
	 * @date 25/11/21
	 */
	
	@Test
	public void testRemoveCliente() {
		
		/* ======== EXECU��O ======== */
		
		//acionando o m�todo removeCliente() da GerenciadoraClientes
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02); 
		
		/* ======== VERIFICA��ES ======== */
		
		assertThat(clienteRemovido, is(true)); 
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		assertNull(gerClientes.pesquisaCliente(2));
	}
	
				
	
}


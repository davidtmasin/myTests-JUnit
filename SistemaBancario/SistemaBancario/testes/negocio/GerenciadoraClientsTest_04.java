package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientsTest_04 {
	
	/*
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author David Teixeira 
	 * @date 25/11/21
	 */
	
	@Test
	public void testPesquisaCliente() {
		
		/* ======== MONTAGEM DO CEN�RIO ======== */
		
		//criando alguns clientes
		Cliente cliente01 = new Cliente(1, "David Teixeira de Masin", 29, "davidteixeira.info@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Jubileu da Silva Xablau", 34, "xablau@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(3, "Irineu Silva", 24, "irineu@gmail.com", 2, true);
	
		//inserindo os clientes criados numa lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
		
		//instanciando a classe GerenciadoraClientes
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		
		/* ======== EXECU��O ======== */
		
		//acionando o m�todo pesquisaCliente() da GerenciadoraClientes
		Cliente cliente = gerClientes.pesquisaCliente(2); 
		
		
		/* ======== VERIFICA��ES ======== */
		
		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getEmail(), is("felipeaugusto@gmail.com"));
			
		
	}
	
	/*
	 * Teste b�sico da remo��o de um cliente a partir do seu ID
	 * 
	 * @author David Teixeira 
	 * @date 25/11/21
	 */
	
	@Test
	public void testRemoveCliente() {
		 
		/* ======== MONTAGEM DO CEN�RIO ======== */
		
		Cliente cliente01 = new Cliente(1, "David Teixeira de Masin", 29, "davidteixeira.info@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		Cliente cliente03 = new Cliente(3, "Felipe Jubileu", 24, "felipejubileu@gmail.com", 2, true);
		
		//inserindo os clientes criados numa lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		clientesDoBanco.add(cliente03);
				
		//instanciando a classe GerenciadoraClientes
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ======== EXECU��O ======== */
		
		//acionando o m�todo removeCliente() da GerenciadoraClientes
		boolean clienteRemovido = gerClientes.removeCliente(2); 
		
		/* ======== VERIFICA��ES ======== */
		
		assertThat(clienteRemovido, is(true)); 
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		assertNull(gerClientes.pesquisaCliente(2));
	}
	
	/*
	 * Teste b�sico da transfer�ncia de um valor da conta de um cliente para outro,
	 * estando ambos os clientes ativos e havendo saldo suficiente para tal transfer�ncia
	 * ocorrer com sucesso.
	 * 
	 * @author David Teixeira 
	 * @date 25/11/21
	 */
	
	@Test
	public void testTransfereValor() {
		
		/* ======== MONTAGEM DO CEN�RIO ======== */
		
		//criando contas correntes
		ContaCorrente cc01 = new ContaCorrente(1, 3067, true);
		ContaCorrente cc02 = new ContaCorrente(2, 500, true);
		ContaCorrente cc03 = new ContaCorrente(3, 300, true);
		
		//inserindo os clientes criados numa lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(cc01);
		contasDoBanco.add(cc02);
		contasDoBanco.add(cc03);
				
		//instanciando a classe GerenciadoraClientes
		GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);	
		
				
		/* ======== EXECU��O ======== */
		gerContas.transfereValor(1, 1100, 2);
		
		
		
		/* ======== VERIFICA��ES ======== */
		assertThat(cc02.getSaldo(), is(1600.0));
		assertThat(cc01.getSaldo(), is(1967.0));
		
				
	}
		
	
}


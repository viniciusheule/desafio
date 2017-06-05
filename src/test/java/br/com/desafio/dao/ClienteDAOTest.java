package br.com.desafio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.desafio.domain.Cidade;
import br.com.desafio.domain.Cliente;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoCidade = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		Cliente cliente = new Cliente();
		cliente.setRazaoSocial("Empresa de TI");
		cliente.setCnpj("12121212121212");
		cliente.setEmail("shaushaush@gmail.com");
		cliente.setTelefone("(14)3714-1259");
		cliente.setRua("Avenida");
		cliente.setBairro("Bairro 1");
		cliente.setNumero("25");
		cliente.setComplemento("");
		cliente.setCidade(cidade);
		cliente.setCep("18760-000");
		cliente.setTipoCliente("Ouro");

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
	}

	@Test
	@Ignore
	public void listar() {

		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			System.out.println("Razão Social: " + cliente.getRazaoSocial());
			System.out.println("CNPJ: " + cliente.getCnpj());
			System.out.println("E-mail: " + cliente.getEmail());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Rua: " + cliente.getRua());
			System.out.println("Bairro: " + cliente.getBairro());
			System.out.println("Numero: " + cliente.getNumero());
			System.out.println("Complemento: " + cliente.getComplemento());
			System.out.println("Cidade: " + cliente.getCidade().getNome());
			System.out.println("CEP: " + cliente.getCep());
			System.out.println("Tipo Cliente: " + cliente.getTipoCliente());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		System.out.println("Razão Social: " + cliente.getRazaoSocial());
		System.out.println("CNPJ: " + cliente.getCnpj());
		System.out.println("E-mail: " + cliente.getEmail());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Rua: " + cliente.getRua());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("Numero: " + cliente.getNumero());
		System.out.println("Complemento: " + cliente.getComplemento());
		System.out.println("Cidade: " + cliente.getCidade().getNome());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Tipo Cliente: " + cliente.getTipoCliente());

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 3L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		clienteDAO.excluir(cliente);

		System.out.println("Cliente excluido: ");
		System.out.println("Razão Social: " + cliente.getRazaoSocial());
		System.out.println("CNPJ: " + cliente.getCnpj());
		System.out.println("E-mail: " + cliente.getEmail());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Rua: " + cliente.getRua());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("Numero: " + cliente.getNumero());
		System.out.println("Complemento: " + cliente.getComplemento());
		System.out.println("Cidade: " + cliente.getCidade().getNome());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Tipo Cliente: " + cliente.getTipoCliente());

	}

	@Test
	@Ignore
	public void editar() {

		Long codigoCliente = 2L;
		Long codigoCidade = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Código do Estado: " + cidade.getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getNome());
		System.out.println("Nome do Estado: " + cidade.getEstado());
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		System.out.println("Cliente a ser Editado: ");
		System.out.println("Razão Social: " + cliente.getRazaoSocial());
		System.out.println("CNPJ: " + cliente.getCnpj());
		System.out.println("E-mail: " + cliente.getEmail());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Rua: " + cliente.getRua());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("Numero: " + cliente.getNumero());
		System.out.println("Complemento: " + cliente.getComplemento());
		System.out.println("Cidade: " + cliente.getCidade().getNome());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Tipo Cliente: " + cliente.getTipoCliente());
		
		cliente.setRazaoSocial("Empresa 1");
		cliente.setCnpj("1111111111111");
		cliente.setEmail("aaaaa@gmail.com");
		cliente.setTelefone("(14)3714-1111");
		cliente.setRua("Avenida 1");
		cliente.setBairro("Bairro 2");
		cliente.setNumero("30");
		cliente.setComplemento("AP");
		cliente.setCidade(cidade);
		cliente.setCep("18760-000");
		cliente.setTipoCliente("Prata");
		
		clienteDAO.editar(cliente);
		
		System.out.println("Cliente Editado: ");
		System.out.println("Razão Social: " + cliente.getRazaoSocial());
		System.out.println("CNPJ: " + cliente.getCnpj());
		System.out.println("E-mail: " + cliente.getEmail());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Rua: " + cliente.getRua());
		System.out.println("Bairro: " + cliente.getBairro());
		System.out.println("Numero: " + cliente.getNumero());
		System.out.println("Complemento: " + cliente.getComplemento());
		System.out.println("Cidade: " + cliente.getCidade().getNome());
		System.out.println("CEP: " + cliente.getCep());
		System.out.println("Tipo Cliente: " + cliente.getTipoCliente());
		
	}
}

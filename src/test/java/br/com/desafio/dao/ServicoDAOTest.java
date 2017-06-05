package br.com.desafio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.desafio.domain.Servico;

public class ServicoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Servico servico = new Servico();
		servico.setDescricao("Site de vendas de eletronicos");
		servico.setTipoServico("Site E-commerce");

		ServicoDAO servicoDAO = new ServicoDAO();
		servicoDAO.salvar(servico);
	}

	@Test
	@Ignore
	public void listar() {
		ServicoDAO servicoDAO = new ServicoDAO();
		List<Servico> resultado = servicoDAO.listar();
		for (Servico servico : resultado) {
			System.out.println(servico.getTipoServico() + " - " + servico.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ServicoDAO servicoDAO = new ServicoDAO();
		Servico servico = servicoDAO.buscar(codigo);

		if (servico == null) {
			System.out.println("Nenhum Registro Encontrado!!");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(servico.getTipoServico() + " - " + servico.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 3L;

		ServicoDAO servicoDAO = new ServicoDAO();
		Servico servico = servicoDAO.buscar(codigo);

		if (servico == null) {
			System.out.println("Nenhum Registro Encontrado!!");
		} else {
			servicoDAO.excluir(servico);
			System.out.println("Registro excluido:");
			System.out.println(servico.getTipoServico() + " - " + servico.getDescricao());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		ServicoDAO servicoDAO = new ServicoDAO();
		Servico servico = servicoDAO.buscar(codigo);

		if (servico == null) {
			System.out.println("Nenhum Registro Encontrado!!");
		} else {
			System.out.println("Registro Editado Antes:");
			System.out.println(servico.getTipoServico() + " - " + servico.getDescricao());

			servico.setTipoServico("One Page");
			servico.setDescricao("Site com uma pagina de informações");
			;
			servicoDAO.editar(servico);

			System.out.println("Registro Editado Depois:");
			System.out.println(servico.getTipoServico() + " - " + servico.getDescricao());
		}
	}

}

package br.com.desafio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.desafio.dao.EstadoDAO;
import br.com.desafio.domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Minas Gerais");
		estado.setSigla("MG");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum Registro Encontrado!!");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {

		Long codigo = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum Registro Encontrado!!");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro excluido:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum Registro Encontrado!!");
		} else {
			System.out.println("Registro Editado Antes:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());

			estado.setNome("Cerqueira");
			estado.setSigla("SP");
			estadoDAO.editar(estado);

			System.out.println("Registro Editado Depois:");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
}

package br.com.desafio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.desafio.dao.CidadeDAO;
import br.com.desafio.dao.EstadoDAO;
import br.com.desafio.dao.ClienteDAO;
import br.com.desafio.domain.Cidade;
import br.com.desafio.domain.Estado;
import br.com.desafio.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;

	private Estado estado;
	private List<Estado> estados;

	private List<Cidade> cidades;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("razaoSocial");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os clientes");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			cliente = new Cliente();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");
			
			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo cliente");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionada");

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
			Messages.addGlobalInfo("Cliente editado com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um cliente!");
			erro.printStackTrace();
		}

	}

	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);
			
			clientes = clienteDAO.listar("razaoSocial");
			
			cliente = new Cliente();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

			cidades = new ArrayList<>();
			Messages.addGlobalInfo("Cliente salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cliente");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		
		
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionada");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			clientes = clienteDAO.listar();

			Messages.addGlobalInfo("Cliente excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao excluir o cliente");
			erro.printStackTrace();
		}
	}

	public void popular() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as cidades");
			erro.printStackTrace();
		}
	}
}

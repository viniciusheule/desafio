package br.com.desafio.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.desafio.dao.ClienteDAO;
import br.com.desafio.dao.ServicoContratadoDAO;
import br.com.desafio.dao.ServicoDAO;
import br.com.desafio.domain.Cliente;
import br.com.desafio.domain.Servico;
import br.com.desafio.domain.ServicoContratado;
import br.com.desafio.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ServicoContratadoBean implements Serializable{

	
	private ServicoContratado servicoContratado; 
	
	private List<ServicoContratado> servicoContratados;
	private List<Cliente> clientes;
	private List<Servico> servicos;
	public ServicoContratado getServicoContratado() {
		return servicoContratado;
	}
	public void setServicoContratado(ServicoContratado servicoContratado) {
		this.servicoContratado = servicoContratado;
	}
	public List<ServicoContratado> getServicoContratados() {
		return servicoContratados;
	}
	public void setServicoContratados(List<ServicoContratado> servicoContratados) {
		this.servicoContratados = servicoContratados;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	@PostConstruct
	public void listar(){
		try{
			ServicoContratadoDAO servicoContratadoDAO = new ServicoContratadoDAO();
			servicoContratados = servicoContratadoDAO.listar();
		} catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os serviços contratados");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		try {
			servicoContratado = new ServicoContratado();
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("razaoSocial");
			
			ServicoDAO servicoDAO = new ServicoDAO();
			servicos = servicoDAO.listar("tipoServico");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo serviço contratado");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			ServicoContratadoDAO servicoContratadoDAO = new ServicoContratadoDAO();
			servicoContratadoDAO.merge(servicoContratado);
			
			servicoContratado = new ServicoContratado();
			
			servicoContratados = servicoContratadoDAO.listar("dtContratacao");
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("razaoSocial");
			
			ServicoDAO servicoDAO = new ServicoDAO();
			servicos = servicoDAO.listar("tipoServico");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um novo serviço contratado");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try{
			servicoContratado = (ServicoContratado) evento.getComponent().getAttributes().get("servicoContratadoSelecionado");
			
			ServicoContratadoDAO servicoContratadoDAO = new ServicoContratadoDAO();
			servicoContratadoDAO.excluir(servicoContratado);
			
			servicoContratados = servicoContratadoDAO.listar();
		} catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao excluir o serviço contratado");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try{
			servicoContratado = (ServicoContratado) evento.getComponent().getAttributes().get("servicoContratadoSelecionado");
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("razaoSocial");
			
			ServicoDAO servicoDAO = new ServicoDAO();
			servicos = servicoDAO.listar("tipoServico");
			
			
		} catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao editar o serviço contratado");
			erro.printStackTrace();
		}
	}
	
	public void imprimir(){
		try{
		String caminho = Faces.getRealPath("/reports/servicoContratado.jasper");
		
		Map<String, Object> parametros = new HashMap<>();
		
		Connection conexao = HibernateUtil.getConexao();
		
		JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
		
		JasperPrintManager.printReport(relatorio, true);
		} catch (JRException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}
}

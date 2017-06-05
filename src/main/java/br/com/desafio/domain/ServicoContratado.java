package br.com.desafio.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class ServicoContratado extends GenericDomain {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Servico servico;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtContratacao;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtInicio;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtFim;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtPagamento;

	@Column(nullable = false, precision = 9, scale = 2)
	private BigDecimal valor;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getDtContratacao() {
		return dtContratacao;
	}

	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}

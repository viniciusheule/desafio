package br.com.desafio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String razaoSocial;
	
	@Column(length = 18, nullable = false)
	private String cnpj;

	@Column(length = 50, nullable = false)
	private String rua;
	
	@Column(nullable = false)
	private String numero;

	@Column(length = 50, nullable = false)
	private String bairro;

	@Column(length = 10, nullable = false)
	private String cep;

	@Column(length = 10)
	private String complemento;

	@Column(length = 13, nullable = false)
	private String telefone;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 50, nullable = false)
	private String tipoCliente;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}

package br.com.fornow.solicitacao.application.pessoa.dto;

import java.util.List;

public class PessoaDto {
	
	private long id;
	private String codigo;
	private String nome;
	private String documento;
	private String tipo;
	private String email;
	private String rg;
	private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private boolean isentoImposto; 
	private EnderecoDto endereco;
	private List<ContatoDto> contatos;
	private List<String> tiposFiliacao;
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public boolean isIsentoImposto() {
		return isentoImposto;
	}
	public void setIsentoImposto(boolean isentoImposto) {
		this.isentoImposto = isentoImposto;
	}
	public EnderecoDto getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}
	public List<ContatoDto> getContatos() {
		return contatos;
	}
	public void setContatos(List<ContatoDto> contatos) {
		this.contatos = contatos;
	}
	public List<String> getTiposFiliacao() {
		return tiposFiliacao;
	}
	public void setTiposFiliacao(List<String> tiposFiliacao) {
		this.tiposFiliacao = tiposFiliacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

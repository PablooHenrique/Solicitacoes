package br.com.fornow.solicitacao;

import java.util.List;

import br.com.fornow.solicitacao.controller.ContatoDto;

public class PessoaDto {
	private long id;
	private String nome;
	private String documento;
	private String tipo;
	private String email;
	private List<ContatoDto> contatos;
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<ContatoDto> getContatos() {
		return contatos;
	}
	public void setContatos(List<ContatoDto> contatos) {
		this.contatos = contatos;
	}
}

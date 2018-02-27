package br.com.fornow.solicitacao.model;

public class Contato {
	
	private long id;
	private String pessoaContato;
	private String numero;
	private String tipo;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPessoaContato() {
		return pessoaContato;
	}

	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

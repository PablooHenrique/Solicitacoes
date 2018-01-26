package br.com.fornow.solicitacao.controller;

public class ContatoDto {
	private String numero;
	private String tipo;
	
	public String getNumero_contato() {
		return numero;
	}
	public void setNumero_contato(String numero_contato) {
		this.numero = numero_contato;
	}
	public String getTipo_contato() {
		return tipo;
	}
	public void setTipo_contato(String tipo_contato) {
		this.tipo = tipo_contato;
	}
}

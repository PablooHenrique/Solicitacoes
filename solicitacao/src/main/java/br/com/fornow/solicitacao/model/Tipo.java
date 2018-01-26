package br.com.fornow.solicitacao.model;

public enum Tipo {
	FORNECEDOR(1, "Fornecedor"), CLIENTE(2, "Cliente");
	
	private int codigo;
	private String descricao;
	
	private Tipo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

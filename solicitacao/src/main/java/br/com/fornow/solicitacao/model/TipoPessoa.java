package br.com.fornow.solicitacao.model;

public enum TipoPessoa {
	FISICA(1, "Fisica"), JURIDICA(2, "Juridica");
	
	private int codigo;
	private String descricao;
	
	private TipoPessoa(int codigo, String descricao) {
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

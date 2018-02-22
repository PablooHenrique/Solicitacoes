package br.com.fornow.solicitacao.application.produto.dto;

public class EmbalagemDto {
	
	private long id;
	private String descricao;
	private Double quantidadeUnidadesPorEmbalagem;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getQuantidadeUnidadesPorEmbalagem() {
		return quantidadeUnidadesPorEmbalagem;
	}
	public void setQuantidadeUnidadesPorEmbalagem(Double quantidadeUnidadesPorEmbalagem) {
		this.quantidadeUnidadesPorEmbalagem = quantidadeUnidadesPorEmbalagem;
	}
}

package br.com.fornow.solicitacao.application.produto.dto;

public class VolumeDto {
	
	private long id;
	private String descricao;
	private Double quantidadeDeUnidadesPorVolume;
	
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
	public Double getQuantidadeDeUnidadesPorVolume() {
		return quantidadeDeUnidadesPorVolume;
	}
	public void setQuantidadeDeUnidadesPorVolume(Double quantidadeDeUnidadesPorVolume) {
		this.quantidadeDeUnidadesPorVolume = quantidadeDeUnidadesPorVolume;
	}
}

package br.com.fornow.solicitacao.application.produto.dto;

public class VolumeDto {
	
	private long id;
	private String codigo;
	private String descricao;
	private Double unidadesPorVolume;
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getUnidadesPorVolume() {
		return unidadesPorVolume;
	}
	public void setUnidadesPorVolume(Double unidadesPorVolume) {
		this.unidadesPorVolume = unidadesPorVolume;
	}
}

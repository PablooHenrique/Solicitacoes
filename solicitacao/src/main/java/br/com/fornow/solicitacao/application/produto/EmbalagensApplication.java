package br.com.fornow.solicitacao.application.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fornow.solicitacao.application.produto.dto.EmbalagemDto;

public class EmbalagensApplication {
	private static ArrayList<EmbalagemDto> embalagens = new ArrayList<EmbalagemDto>();
	
	
	public EmbalagensApplication() {
		if (embalagens.isEmpty()) {
			EmbalagemDto embalagem = new EmbalagemDto();
			embalagem.setId(1);
			embalagem.setDescricao("Embalagem Plastica Para Borracha");
			embalagem.setUnidadesPorEmbalagem((double) 6.0);
			embalagens.add(embalagem);
			
			embalagem = new EmbalagemDto();
			embalagem.setId(2);
			embalagem.setDescricao("Embalagem Plastica Coretivo");
			embalagem.setUnidadesPorEmbalagem((double) 10.0);
			embalagens.add(embalagem);
		}
	}
	
	public List<EmbalagemDto> listar() {
		return embalagens;
	}

	public void salvar(EmbalagemDto embalagem) {
		EmbalagensApplication.embalagens.add(embalagem);
	}

	public void editar(long id, EmbalagemDto embalagem) {
		List<EmbalagemDto> collect = EmbalagensApplication.embalagens.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			EmbalagensApplication.embalagens.remove(collect.get(0));
			EmbalagensApplication.embalagens.add(embalagem);
		}
	}

	public void deletar(long id) {
		List<EmbalagemDto> collect = EmbalagensApplication.embalagens.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			EmbalagensApplication.embalagens.remove(collect.get(0));
		}
	}

	public EmbalagemDto listarPorId(long id) {
		List<EmbalagemDto> collect = EmbalagensApplication.embalagens.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			return collect.get(0);
		}
		
		return null;
	}
}

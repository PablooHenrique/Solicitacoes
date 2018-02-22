package br.com.fornow.solicitacao.application.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fornow.solicitacao.application.produto.dto.UnidadeDto;

public class UnidadeApplication {
	private static ArrayList<UnidadeDto> unidades = new ArrayList<UnidadeDto>();
	
	public UnidadeApplication() {
		if (unidades.isEmpty()) {
			UnidadeDto unidade = new UnidadeDto();
			unidade.setId(1);
			unidade.setCodigo("584LT");
			unidade.setDescricao("LT");
			unidades.add(unidade);
			
			unidade = new UnidadeDto();
			unidade.setId(2);
			unidade.setCodigo("5545UN");
			unidade.setDescricao("UN");
			unidades.add(unidade);
		}
	}
	
	public List<UnidadeDto> listar() {
		return unidades;
	}

	public void salvar(UnidadeDto unidade) {
		UnidadeApplication.unidades.add(unidade);
	}

	public void editar(long id, UnidadeDto unidade) {
		List<UnidadeDto> collect = UnidadeApplication.unidades.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			UnidadeApplication.unidades.remove(collect.get(0));
			UnidadeApplication.unidades.add(unidade);
		}
	}

	public void deletar(long id) {
		List<UnidadeDto> collect = UnidadeApplication.unidades.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			UnidadeApplication.unidades.remove(collect.get(0));
		}
	}

	public UnidadeDto listarPorId(long id) {
		List<UnidadeDto> collect = UnidadeApplication.unidades.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			return collect.get(0);
		}
		
		return null;
	}
}

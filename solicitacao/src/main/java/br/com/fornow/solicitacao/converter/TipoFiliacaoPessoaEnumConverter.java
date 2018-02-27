package br.com.fornow.solicitacao.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.fornow.solicitacao.model.TipoFiliacaoPessoa;

@Converter
public class TipoFiliacaoPessoaEnumConverter implements AttributeConverter<TipoFiliacaoPessoa, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoFiliacaoPessoa filiacao) {
		return filiacao.getCodigo();
	}

	@Override
	public TipoFiliacaoPessoa convertToEntityAttribute(Integer index) {
		TipoFiliacaoPessoa[] values = TipoFiliacaoPessoa.values();
		List<TipoFiliacaoPessoa> list = Arrays.asList(values);
		List<TipoFiliacaoPessoa> collect = list.stream().filter(x->x.getCodigo() == index).collect(Collectors.toList());
		return collect.get(0);
	}
}

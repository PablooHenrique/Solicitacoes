package br.com.fornow.solicitacao.application.pessoa;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.fornow.solicitacao.PessoaService.PessoaService;
import br.com.fornow.solicitacao.application.pessoa.dto.PessoaDto;
import br.com.fornow.solicitacao.model.Pessoa;

public class PessoaApplication {

    public List<PessoaDto> listar() {
	List<Pessoa> pessoas = new PessoaService().listar();
	ModelMapper mapper = new ModelMapper();
	PessoaDto[] map = mapper.map(pessoas, PessoaDto[].class);
	List<PessoaDto> pessoasDto = Arrays.asList(map);
	return pessoasDto;
    }

    public void salvar(PessoaDto pessoa) {
	ModelMapper mapper = new ModelMapper();
	Pessoa p = mapper.map(pessoa, Pessoa.class);
	new PessoaService().salvarPessoa(p);
    }

    public void atualizar(long id, PessoaDto pessoa) {
	ModelMapper mapper = new ModelMapper();
	Pessoa p = mapper.map(pessoa, Pessoa.class);
	new PessoaService().atualizar(id, p);
    }

    public void deletar(long id) {
	new PessoaService().deletar(id);
    }
}

package br.com.fornow.solicitacao.PessoaService;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fornow.solicitacao.model.Pessoa;
import br.com.fornow.solicitacao.model.TipoFiliacaoPessoa;
import br.com.fornow.solicitacao.repository.PessoaRepository;

public class PessoaService {

	public void salvarPessoa(Pessoa p) {
		new PessoaRepository().salvar(p);
	}

	public List<Pessoa> listar() {
		List<Pessoa> pessoas = new PessoaRepository().listar();
		return pessoas;
	}
	
	public List<Pessoa> listarClientes(){
		List<Pessoa> pessoas = listar();
		pessoas = pessoas.stream().filter(x->x.getTiposFiliacao().contains(TipoFiliacaoPessoa.CLIENTE)).collect(Collectors.toList());
		return pessoas;
	}
	
	public List<Pessoa> listarFornecedores(){
		List<Pessoa> pessoas = listar();
		pessoas = pessoas.stream().filter(x->x.getTiposFiliacao().contains(TipoFiliacaoPessoa.FORNECEDOR)).collect(Collectors.toList());
		return pessoas;
	}

	public void atualizar(long id, Pessoa pessoa) {
//		Pessoa p = new PessoaRepository().procurarPessoaPorId(id);
		new PessoaRepository().atualizarPessoa(pessoa);
	}

	public void deletar(long id) {
		new PessoaRepository().deletarPessoa(id);
	}

	public Pessoa listarPorId(long id) {
		Pessoa pessoa = new PessoaRepository().listarPorId(id);
		return pessoa;
	}
}

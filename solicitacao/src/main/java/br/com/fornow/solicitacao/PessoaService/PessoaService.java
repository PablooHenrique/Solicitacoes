package br.com.fornow.solicitacao.PessoaService;

import java.util.List;

import br.com.fornow.solicitacao.PessoaDto;
import br.com.fornow.solicitacao.model.Pessoa;
import br.com.fornow.solicitacao.repository.PessoaRepository;

public class PessoaService {
	
	public void salvarPessoa(PessoaDto p){
//		new PessoaRepository().salvar(p);
		System.out.println("Pessoa Salvo: ");
		System.out.println("Nome: " + p.getNome());
		System.out.println("Documento: " + p.getDocumento());
		System.out.println("Tipo: " + p.getTipo());
		System.out.println("Email: " + p.getEmail());
	}

	public List<Pessoa> listar() {
		System.out.println("Listando...");
		List<Pessoa> pessoas = new PessoaRepository().listar();
		return pessoas;
	}

	public Pessoa atualizar(long id, Pessoa pDto) {
		Pessoa p = new PessoaRepository().procurarPessoaPorId(id);
		new PessoaRepository().atualizarPessoa(p);
		System.out.println("Atualizado");
		return null;
	}

	public void deletar(long id) {
		new PessoaRepository().deletarPessoa(id);
		System.out.println("Deletado");
	}
}

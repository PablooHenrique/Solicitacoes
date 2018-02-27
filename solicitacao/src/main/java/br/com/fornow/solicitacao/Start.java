package br.com.fornow.solicitacao;

import java.util.ArrayList;
import java.util.List;

import br.com.fornow.solicitacao.PessoaService.PessoaService;
import br.com.fornow.solicitacao.model.Contato;
import br.com.fornow.solicitacao.model.Endereco;
import br.com.fornow.solicitacao.model.Pessoa;
import br.com.fornow.solicitacao.model.Status;
import br.com.fornow.solicitacao.model.TipoFiliacaoPessoa;
import br.com.fornow.solicitacao.model.TipoPessoa;

public class Start {
	public static void main(String[] args) {
		
		boolean naoExecutar = false;
		if (naoExecutar) {
			List<Pessoa> fornecedores = new PessoaService().listarFornecedores();
			fornecedores.stream().forEach(x-> System.out.println(x.getNome()));
		}
		testeCriarPessoas();
	}

	private static void testeCriarPessoas() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCnpj("");
		pessoa.setCpf("04129153161");
		pessoa.setCodigo("AAA1");
		pessoa.setInscricaoEstadual("");
		pessoa.setInscricaoMunicipal("");
		pessoa.setIsentoImposto(false);
		pessoa.setNome("Pablo Henrique Reis Carvalho");
		pessoa.setRg("5625449");
		pessoa.setStatus(Status.ATIVA);
		pessoa.setEmail("email@gmail.com");
		
		List<TipoFiliacaoPessoa> tiposFiliacaoPessoas = new ArrayList<TipoFiliacaoPessoa>();
		tiposFiliacaoPessoas.add(TipoFiliacaoPessoa.CLIENTE);
		pessoa.setTiposFiliacao(tiposFiliacaoPessoas);
		
		pessoa.setTipoPessoa(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Pontal Sul");
		endereco.setCep("74955530");
		endereco.setCidade("Goiania");
		endereco.setComplemento("Complemento");
		endereco.setNumero("1");
		endereco.setRua("Viterita");
		endereco.setUf("GO");
		pessoa.setEndereco(endereco);
		
		List<Contato> listContato = new ArrayList<Contato>();
		
		Contato contato = new Contato();
		contato.setNumero("6282825400");
		contato.setPessoaContato("Pessoa Contato");
		contato.setTipo("CELULAR");
		listContato.add(contato);
//		pessoa.setContatos(listContato);
		
		
		
		
		new PessoaService().salvarPessoa(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setCnpj("13566916000155");
		pessoa.setCpf("");
		pessoa.setCodigo("AAA2");
		pessoa.setInscricaoEstadual("59685865");
		pessoa.setInscricaoMunicipal("5684856");
		pessoa.setIsentoImposto(false);
		pessoa.setNome("Nogueira Nobre");
		pessoa.setEmail("email@gmail.com");
		pessoa.setRg("");
		pessoa.setStatus(Status.ATIVA);
		
		tiposFiliacaoPessoas = new ArrayList<TipoFiliacaoPessoa>();
		tiposFiliacaoPessoas.add(TipoFiliacaoPessoa.FORNECEDOR);
		pessoa.setTiposFiliacao(tiposFiliacaoPessoas);
		
		pessoa.setTipoPessoa(TipoPessoa.JURIDICA);
		
		endereco = new Endereco();
		endereco.setBairro("Coimbra");
		endereco.setCep("74955530");
		endereco.setCidade("Goiania");
		endereco.setComplemento("Complemento");
		endereco.setNumero("1");
		endereco.setRua("AUGUSTA");
		endereco.setUf("GO");
		pessoa.setEndereco(endereco);
		
		listContato = new ArrayList<Contato>();
		
		contato = new Contato();
		contato.setNumero("6282825400");
		contato.setPessoaContato("Pessoa Contato");
		contato.setTipo("CELULAR");
		listContato.add(contato);
		
		contato = new Contato();
		contato.setNumero("6282825400");
		contato.setPessoaContato("Pessoa Contato");
		contato.setTipo("CELULAR");
		listContato.add(contato);
		
//		pessoa.setContatos(listContato);
		new PessoaService().salvarPessoa(pessoa);
	}
}

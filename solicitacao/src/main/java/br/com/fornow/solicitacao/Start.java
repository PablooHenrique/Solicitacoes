package br.com.fornow.solicitacao;

import br.com.fornow.solicitacao.application.pessoa.dto.ContatoDto;
import br.com.fornow.solicitacao.application.pessoa.dto.PessoaDto;

public class Start {
	public static void main(String[] args) {
		PessoaDto pessoa = new PessoaDto();
		
		pessoa.setNome("Pablo Henrique Reis Carvalho");
		pessoa.setDocumento("04129153161");
		pessoa.setTipo("FISICA");
		pessoa.setEmail("pabloohenrique32@gmail.com");
		
//		ContatoDto contato = new ContatoDto();
//		contato.setNumero_contato(numero_contato);
//		pessoa.setContatos(contatos);
		
		
	}
}

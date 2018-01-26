package br.com.fornow.solicitacao.application.pessoa.fs;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fornow.solicitacao.application.pessoa.PessoaApplication;
import br.com.fornow.solicitacao.application.pessoa.dto.PessoaDto;
import br.com.fornow.solicitacao.model.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listaPessoas() {
	List<PessoaDto> pessoas = new PessoaApplication().listar();
	if (pessoas.isEmpty()) {
	    return new ResponseEntity<List<Pessoa>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<PessoaDto>>(pessoas, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvaPessoa(@RequestBody PessoaDto pessoa, UriComponentsBuilder ucBuilder) {
	new PessoaApplication().salvar(pessoa);
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(ucBuilder.path("/lancamentos/{id}").buildAndExpand(pessoa.getId()).toUri());
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaPessoa(@PathVariable("id") long id, @RequestBody PessoaDto pessoa) {
	new PessoaApplication().atualizar(id, pessoa);
	return new ResponseEntity<PessoaDto>(pessoa, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletaPessoa(@PathVariable("id") long id) {
	new PessoaApplication().deletar(id);
	return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT);
    }
}

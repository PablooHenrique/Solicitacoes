package br.com.fornow.solicitacao.application.produto.fs;

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

import br.com.fornow.solicitacao.application.produto.EmbalagensApplication;
import br.com.fornow.solicitacao.application.produto.dto.EmbalagemDto;

@RestController
@RequestMapping("/embalagens")
public class EmbalagemController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista(){
		List<EmbalagemDto> embalagens = new EmbalagensApplication().listar();
		if (embalagens.isEmpty()) {
			return new ResponseEntity<List<EmbalagemDto>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<EmbalagemDto>>(embalagens, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listaPorId(@PathVariable("id") long id) {
		EmbalagemDto embalagem = new EmbalagensApplication().listarPorId(id);
		if (embalagem == null) {
			return new ResponseEntity<List<EmbalagemDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EmbalagemDto>(embalagem, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salva(@RequestBody EmbalagemDto embalagem, UriComponentsBuilder ucBuilder){
		new EmbalagensApplication().salvar(embalagem);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/embalagens/{id}").buildAndExpand(embalagem.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> edita(@PathVariable("id") long id, @RequestBody EmbalagemDto embalagem){
		new EmbalagensApplication().editar(id, embalagem);
		return new ResponseEntity<EmbalagemDto>(embalagem, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleta(@PathVariable("id") long id){
		new EmbalagensApplication().deletar(id);
		return new ResponseEntity<EmbalagemDto>(HttpStatus.NO_CONTENT);	
	}
}

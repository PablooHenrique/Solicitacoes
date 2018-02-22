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
import br.com.fornow.solicitacao.application.produto.UnidadeApplication;
import br.com.fornow.solicitacao.application.produto.dto.EmbalagemDto;
import br.com.fornow.solicitacao.application.produto.dto.UnidadeDto;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista(){
		List<UnidadeDto> unidades = new UnidadeApplication().listar();
		if (unidades.isEmpty()) {
			return new ResponseEntity<List<UnidadeDto>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<UnidadeDto>>(unidades, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listaPorId(@PathVariable("id") long id) {
		UnidadeDto unidade = new UnidadeApplication().listarPorId(id);
		if (unidade == null) {
			return new ResponseEntity<List<UnidadeDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UnidadeDto>(unidade, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salva(@RequestBody UnidadeDto unidade, UriComponentsBuilder ucBuilder){
		System.out.println("Chegando aq POST");
		new UnidadeApplication().salvar(unidade);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/unidades/{id}").buildAndExpand(unidade.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> edita(@PathVariable("id") long id, @RequestBody UnidadeDto unidade){
		System.out.println("Chegando aq PUT");
		new UnidadeApplication().editar(id, unidade);
		return new ResponseEntity<UnidadeDto>(unidade, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleta(@PathVariable("id") long id){
		System.out.println("Chegando aq DELETE");
		new UnidadeApplication().deletar(id);
		return new ResponseEntity<UnidadeDto>(HttpStatus.NO_CONTENT);	
	}
}

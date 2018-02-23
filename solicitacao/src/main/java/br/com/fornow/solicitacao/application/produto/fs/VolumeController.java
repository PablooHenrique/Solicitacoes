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

import br.com.fornow.solicitacao.application.produto.VolumeApplication;
import br.com.fornow.solicitacao.application.produto.dto.VolumeDto;

@RestController
@RequestMapping("/volumes")
public class VolumeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista(){
		List<VolumeDto> volume = new VolumeApplication().listar();
		if (volume.isEmpty()) {
			return new ResponseEntity<List<VolumeDto>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<VolumeDto>>(volume, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listaPorId(@PathVariable("id") long id) {
		VolumeDto volume = new VolumeApplication().listarPorId(id);
		if (volume == null) {
			return new ResponseEntity<List<VolumeDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<VolumeDto>(volume, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salva(@RequestBody VolumeDto volume, UriComponentsBuilder ucBuilder){
		new VolumeApplication().salvar(volume);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/volumes/{id}").buildAndExpand(volume.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> edita(@PathVariable("id") long id, @RequestBody VolumeDto volume){
		new VolumeApplication().editar(id, volume);
		return new ResponseEntity<VolumeDto>(volume, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleta(@PathVariable("id") long id){
		new VolumeApplication().deletar(id);
		return new ResponseEntity<VolumeDto>(HttpStatus.NO_CONTENT);	
	}
}

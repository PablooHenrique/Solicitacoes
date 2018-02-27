package br.com.fornow.solicitacao.application.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.fornow.solicitacao.PessoaService.PessoaService;
import br.com.fornow.solicitacao.application.pessoa.dto.PessoaDto;
import br.com.fornow.solicitacao.model.Pessoa;
import br.com.fornow.solicitacao.model.TipoPessoa;

public class PessoaApplication {
	
//	PessoaDto[] map = mapper.map(pessoas, PessoaDto[].class);
//	List<PessoaDto> pessoasDto = Arrays.asList(map);
	
	public List<PessoaDto> listar() {
		List<Pessoa> pessoas = new PessoaService().listar();
		List<PessoaDto> mapList = converterListaPessoaParaListaPessoaDto(pessoas);
		return mapList;
	}
	
	public List<PessoaDto> listarClientes(){
		List<Pessoa> clientes = new PessoaService().listarClientes();
		List<PessoaDto> clientesDto = converterListaPessoaParaListaPessoaDto(clientes);
		return clientesDto;
	}
	
	public List<PessoaDto> listarFornecedores(){
		List<Pessoa> fornecedores = new PessoaService().listarFornecedores();
		List<PessoaDto> fornecedoresDto = converterListaPessoaParaListaPessoaDto(fornecedores);
		return fornecedoresDto;
	}

	private List<PessoaDto> converterListaPessoaParaListaPessoaDto(List<Pessoa> pessoas) {
		
		ModelMapper mapper = new ModelMapper();
		
		List<PessoaDto> mapList = new ArrayList<PessoaDto>();
				
		for (Pessoa pessoa : pessoas) {
			PessoaDto map = mapper.map(pessoa, PessoaDto.class);
			if(pessoa.getTipoPessoa().equals(TipoPessoa.FISICA)){
				map.setDocumento(pessoa.getCpf());
			}else{
				map.setDocumento(pessoa.getCnpj());
			}
			
			mapList.add(map);
		}
		return mapList;
	}

	public void salvar(PessoaDto pessoa) {
		ModelMapper mapper = new ModelMapper();
		Pessoa p = mapper.map(pessoa, Pessoa.class);
		if (p.getTipoPessoa().equals(TipoPessoa.FISICA)) {
			p.setCpf(pessoa.getDocumento());
		}else{
			p.setCnpj(pessoa.getDocumento());
		}
		new PessoaService().salvarPessoa(p);
	}

	public void atualizar(long id, PessoaDto pessoa) {
		ModelMapper mapper = new ModelMapper();
		Pessoa p = mapper.map(pessoa, Pessoa.class);
		if (p.getTipoPessoa().equals(TipoPessoa.FISICA)) {
			p.setCpf(pessoa.getDocumento());
		}else{
			p.setCnpj(pessoa.getDocumento());
		}
		new PessoaService().atualizar(id, p);
	}

	public void deletar(long id) {
		new PessoaService().deletar(id);
	}

	public PessoaDto listarPorId(long id) {
		Pessoa pessoa = new PessoaService().listarPorId(id);
		
		ModelMapper mapper = new ModelMapper();
		PessoaDto pessoaDto = mapper.map(pessoa, PessoaDto.class);
		if (pessoa.getTipoPessoa().equals(TipoPessoa.FISICA)) {
			pessoaDto.setDocumento(pessoa.getCpf());
		}else{
			pessoaDto.setDocumento(pessoa.getCnpj());
		}
		return pessoaDto;
	}
}

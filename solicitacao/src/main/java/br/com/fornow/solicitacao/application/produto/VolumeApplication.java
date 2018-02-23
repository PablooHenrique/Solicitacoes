package br.com.fornow.solicitacao.application.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fornow.solicitacao.application.produto.dto.VolumeDto;

public class VolumeApplication {
	private static ArrayList<VolumeDto> volumes = new ArrayList<VolumeDto>();
	
	public VolumeApplication() {
		if (volumes.isEmpty()) {
			VolumeDto volume = new VolumeDto();
			volume.setId(1);
			volume.setDescricao("Volume Um");
			volume.setUnidadesPorVolume((double) 6.0);
			volumes.add(volume);
			
			volume = new VolumeDto();
			volume.setId(2);
			volume.setDescricao("Embalagem Plastica Coretivo");
			volume.setUnidadesPorVolume((double) 10.0);
			volumes.add(volume);
		}
	}
	
	public List<VolumeDto> listar() {
		return volumes;
	}

	public void salvar(VolumeDto volume) {
		VolumeApplication.volumes.add(volume);
	}

	public void editar(long id, VolumeDto volume) {
		List<VolumeDto> collect = VolumeApplication.volumes.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			VolumeApplication.volumes.remove(collect.get(0));
			VolumeApplication.volumes.add(volume);
		}
	}

	public void deletar(long id) {
		List<VolumeDto> collect = VolumeApplication.volumes.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			VolumeApplication.volumes.remove(collect.get(0));
		}
	}

	public VolumeDto listarPorId(long id) {
		List<VolumeDto> collect = VolumeApplication.volumes.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		if (!collect.isEmpty()) {
			return collect.get(0);
		}
		
		return null;
	}
}

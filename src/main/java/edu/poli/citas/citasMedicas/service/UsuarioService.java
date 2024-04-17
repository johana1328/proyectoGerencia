package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import edu.poli.citas.citasMedicas.dto.UsuarioDto;
import edu.poli.citas.citasMedicas.mapper.UsuarioMapper;
import edu.poli.citas.citasMedicas.model.UsuarioModel;
import edu.poli.citas.citasMedicas.repository.UsuarioRepository;

public class UsuarioService  implements CrudService<UsuarioDto, Long>{
	
	@Autowired
	private UsuarioMapper mapper;

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<UsuarioDto> getList() {
		List<UsuarioModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public Optional<UsuarioDto> getById(Long id) {
		Optional<UsuarioModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<UsuarioDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public UsuarioDto create(UsuarioDto dto) {
		UsuarioModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public UsuarioDto update(UsuarioDto dto, Long id) throws Exception {
		Optional<UsuarioModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			UsuarioModel model = mapper.merge(oprioalResult.get(), dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error usuario no valido");
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<UsuarioModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error usuario no valido");
		
	}

}

package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import edu.poli.citas.citasMedicas.dto.NovedadDto;
import edu.poli.citas.citasMedicas.mapper.NovedadMapper;
import edu.poli.citas.citasMedicas.model.NovedadModel;
import edu.poli.citas.citasMedicas.repository.NovedadRepository;

public class NovedadService implements CrudService<NovedadDto, Long>{
	
	@Autowired
	private NovedadMapper mapper;

	@Autowired
	private NovedadRepository repository;

	@Override
	public List<NovedadDto> getList() {
		List<NovedadModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	
	}

	@Override
	public Optional<NovedadDto> getById(Long id) {
		Optional<NovedadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<NovedadDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public NovedadDto create(NovedadDto dto) {
		NovedadModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public NovedadDto update(NovedadDto dto, Long id) throws Exception {
		Optional<NovedadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			NovedadModel model = mapper.merge(oprioalResult.get(), dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error novedad no valida");
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<NovedadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error novedad no valida");
		
	}
	
	

}

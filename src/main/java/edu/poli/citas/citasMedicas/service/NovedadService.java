package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.NovedadDto;
import edu.poli.citas.citasMedicas.mapper.NovedadMapper;
import edu.poli.citas.citasMedicas.model.NovedadModel;
import edu.poli.citas.citasMedicas.repository.NovedadRepository;

@Service
public class NovedadService {

	@Autowired
	private NovedadMapper mapper;

	@Autowired
	private NovedadRepository repository;

	
	public List<NovedadDto> getList() {
		List<NovedadModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());

	}

	
	public Optional<NovedadDto> getById(Long id) {
		Optional<NovedadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<NovedadDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}


	public NovedadDto create(NovedadDto dto, Long idCita) {
		NovedadModel model = mapper.toModel(dto, idCita);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	
	public NovedadDto update(NovedadDto dto, Long id) throws Exception {
		Optional<NovedadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			NovedadModel model = oprioalResult.get();
			mapper.merge(model, dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error novedad no valida");
	}

	
	public void delete(Long id) throws Exception {
		Optional<NovedadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error novedad no valida");

	}

}

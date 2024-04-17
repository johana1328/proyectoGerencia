package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.ExamenDto;
import edu.poli.citas.citasMedicas.mapper.ExamenMapper;
import edu.poli.citas.citasMedicas.model.ExamenModel;
import edu.poli.citas.citasMedicas.repository.ExamenRespository;

@Service
public class ExamenService implements CrudService<ExamenDto, Long>{
	
	@Autowired
	private ExamenMapper mapper;
	
	@Autowired
	private ExamenRespository repository;

	@Override
	public List<ExamenDto> getList() {
		List<ExamenModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public Optional<ExamenDto> getById(Long id) {
		Optional<ExamenModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<ExamenDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public ExamenDto create(ExamenDto dto) {
		ExamenModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public ExamenDto update(ExamenDto dto, Long id) throws Exception {
		Optional<ExamenModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			ExamenModel model = mapper.merge(oprioalResult.get(), dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error examen no valido");
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<ExamenModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error examen no valido");

		
	}

}

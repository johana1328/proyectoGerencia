package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.PacienteDto;
import edu.poli.citas.citasMedicas.mapper.PacienteMapper;
import edu.poli.citas.citasMedicas.model.PacienteModel;
import edu.poli.citas.citasMedicas.repository.PacienteRepository;

@Service
public class PacienteService implements CrudService<PacienteDto, Long> {

	@Autowired
	private PacienteRepository repository;

	@Autowired
	private PacienteMapper mapper;

	@Override
	public List<PacienteDto> getList() {
		List<PacienteModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public Optional<PacienteDto> getById(Long id) {
		Optional<PacienteModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<PacienteDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public PacienteDto create(PacienteDto dto) {
		PacienteModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public PacienteDto update(PacienteDto dto, Long id) throws Exception {
		Optional<PacienteModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			PacienteModel model = oprioalResult.get();
			mapper.merge(model, dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error especialidad no valida");
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<PacienteModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error especialidad no valida");

	}

}

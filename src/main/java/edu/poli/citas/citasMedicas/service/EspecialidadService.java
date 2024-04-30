package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.EspecialidadDto;
import edu.poli.citas.citasMedicas.mapper.EspecialidadMapper;
import edu.poli.citas.citasMedicas.model.EspecialidadModel;
import edu.poli.citas.citasMedicas.repository.EspecialidadRepository;

@Service
public class EspecialidadService implements CrudService<EspecialidadDto, Long> {

	@Autowired
	private EspecialidadMapper mapper;

	@Autowired
	private EspecialidadRepository repository;

	@Override
	public List<EspecialidadDto> getList() {
		List<EspecialidadModel> resultList = repository.getEspecialidadesByDoctor();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public Optional<EspecialidadDto> getById(Long id) {
		Optional<EspecialidadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<EspecialidadDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public EspecialidadDto create(EspecialidadDto dto) {
		EspecialidadModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public EspecialidadDto update(EspecialidadDto dto, Long id) throws Exception{
		Optional<EspecialidadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			EspecialidadModel model = mapper.merge(oprioalResult.get(), dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error especialidad no valida");
	}

	@Override
	public void delete(Long id) throws Exception{
		Optional<EspecialidadModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error especialidad no valida");

	}

}

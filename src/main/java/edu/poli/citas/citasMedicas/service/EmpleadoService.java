package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.EmpleadoDto;
import edu.poli.citas.citasMedicas.mapper.EmpleadoMapper;
import edu.poli.citas.citasMedicas.model.EmpleadoModel;
import edu.poli.citas.citasMedicas.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements CrudService<EmpleadoDto, Long> {

	@Autowired
	private EmpleadoRepository repository;

	@Autowired
	private EmpleadoMapper mapper;

	@Override
	public List<EmpleadoDto> getList() {
		List<EmpleadoModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}
	

	@Override
	public Optional<EmpleadoDto> getById(Long id) {
		Optional<EmpleadoModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<EmpleadoDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public EmpleadoDto create(EmpleadoDto dto) {
		EmpleadoModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public EmpleadoDto update(EmpleadoDto dto, Long id) throws Exception {
		Optional<EmpleadoModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			EmpleadoModel model = oprioalResult.get();
			mapper.merge(model, dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error especialidad no valida");
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<EmpleadoModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error especialidad no valida");

	}
	
	public List<EmpleadoDto> getListMedicos() {
		List<EmpleadoModel> resultList = repository.listMedicos();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

}

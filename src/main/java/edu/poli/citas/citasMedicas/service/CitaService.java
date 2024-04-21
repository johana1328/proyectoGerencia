package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.CitaDto;
import edu.poli.citas.citasMedicas.mapper.CitaMapper;
import edu.poli.citas.citasMedicas.model.CitaModel;
import edu.poli.citas.citasMedicas.model.EmpleadoModel;
import edu.poli.citas.citasMedicas.repository.CitaRepository;
import edu.poli.citas.citasMedicas.repository.EmpleadoRepository;

@Service
public class CitaService implements CrudService<CitaDto, Long> {

	@Autowired
	private CitaRepository repository;

	@Autowired
	private CitaMapper mapper;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<CitaDto> getList() {
		List<CitaModel> resultList = repository.findAll();

		return resultList.stream().map(cita -> {
			CitaDto citadto = mapper.toDto(cita);
			Optional<EmpleadoModel>  empleado = empleadoRepository.findById(cita.getDoctor().getId());
			citadto.setEspecialidad(empleado.get().getEspecialidad().getDescropcion());
			return citadto;
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<CitaDto> getById(Long id) {
		Optional<CitaModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<CitaDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public CitaDto create(CitaDto dto) {
		CitaModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public CitaDto update(CitaDto dto, Long id) throws Exception {
		Optional<CitaModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			CitaModel model = oprioalResult.get();
			mapper.merge(model, dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error especialidad no valida");
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<CitaModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error especialidad no valida");

	}

}

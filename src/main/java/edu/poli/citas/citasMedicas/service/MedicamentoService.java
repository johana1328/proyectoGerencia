package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.poli.citas.citasMedicas.dto.MedicamentoDto;
import edu.poli.citas.citasMedicas.mapper.MedicamentoMapper;
import edu.poli.citas.citasMedicas.model.AutorizacionModel;
import edu.poli.citas.citasMedicas.model.MedicamentoModel;
import edu.poli.citas.citasMedicas.repository.AutorizacionRepository;
import edu.poli.citas.citasMedicas.repository.MedicamentoRepository;

@Service
public class MedicamentoService implements CrudService<MedicamentoDto, Long> {

	@Autowired
	private MedicamentoMapper mapper;

	@Autowired
	private MedicamentoRepository repository;

	@Autowired
	private AutorizacionRepository autorizacionRepository;

	@Override
	public List<MedicamentoDto> getList() {
		List<MedicamentoModel> resultList = repository.findAll();
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());

	}

	@Override
	public Optional<MedicamentoDto> getById(Long id) {
		Optional<MedicamentoModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			Optional<MedicamentoDto> response = Optional.of(mapper.toDto(oprioalResult.get()));
			return response;
		}
		return Optional.empty();
	}

	@Override
	public MedicamentoDto create(MedicamentoDto dto) {
		MedicamentoModel model = mapper.toModel(dto);
		model = repository.save(model);
		return mapper.toDto(model);
	}

	public MedicamentoDto create(MedicamentoDto dto, long idAutorizacion) {
		MedicamentoModel model = mapper.toModel(dto);
		Optional<AutorizacionModel> autModel = autorizacionRepository.findById(idAutorizacion);
		model.setAutorizacion(autModel.get());
		model = repository.save(model);
		return mapper.toDto(model);
	}

	@Override
	public MedicamentoDto update(MedicamentoDto dto, Long id) throws Exception {
		Optional<MedicamentoModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			MedicamentoModel model = mapper.merge(oprioalResult.get(), dto);
			repository.save(model);
			return mapper.toDto(model);
		}
		throw new Exception("Error medicamento no valido");
	}

	@Override
	@Transactional
	public void delete(Long id) throws Exception {

	}

	public List<MedicamentoDto> listByAutorizacionId(Long idAutroizacion) {
		List<MedicamentoModel> resultList = repository.listByAutorizacionId(idAutroizacion);
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

}

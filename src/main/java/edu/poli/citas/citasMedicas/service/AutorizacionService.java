package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.dto.AutorizacionDto;
import edu.poli.citas.citasMedicas.mapper.AutorizacionMapper;
import edu.poli.citas.citasMedicas.model.AutorizacionModel;
import edu.poli.citas.citasMedicas.model.CitaModel;
import edu.poli.citas.citasMedicas.repository.AutorizacionRepository;
import edu.poli.citas.citasMedicas.repository.CitaRepository;

@Service
public class AutorizacionService {

	@Autowired
	private AutorizacionRepository repository;

	@Autowired
	private CitaRepository citaRepository;

	@Autowired
	private AutorizacionMapper mapper;

	public AutorizacionDto create(AutorizacionDto dto, Long idCita) {
		AutorizacionModel model = mapper.toModel(dto);
		Optional<CitaModel> citaop = citaRepository.findById(idCita);
		model.setCita(citaop.get());
		model = repository.save(model);
		return mapper.toDto(model);
	}

	public void delete(Long id) throws Exception {
		Optional<AutorizacionModel> oprioalResult = repository.findById(id);
		if (oprioalResult.isPresent()) {
			repository.delete(oprioalResult.get());
			return;
		}
		throw new Exception("Error novedad no valida");
	}

	public List<AutorizacionDto> listByCita(Long citsId) {
		List<AutorizacionModel> resultList = repository.listBycitaId(citsId);
		return resultList.stream().map(mapper::toDto).collect(Collectors.toList());
	}

}

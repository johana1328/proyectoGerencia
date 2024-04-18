package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.CitaDto;
import edu.poli.citas.citasMedicas.model.CitaModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class CitaMapper {

	@Mapping(target = "idDoctor", ignore = true)
	@Mapping(target = "idPaciente", ignore = true)
	@Mapping(target = "fecha", dateFormat = "dd/MM/yyyy")
	@Mapping(target = "hora", dateFormat = "HH:mm:ss")
	@Mapping(target = "doctor.citas",ignore = true)
	@Mapping(target = "paciente.citas",ignore = true)
	public abstract CitaDto toDto(CitaModel source);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "autorizacion", ignore = true)
	@Mapping(target = "novedades", ignore = true)
	@Mapping(target = "fecha", dateFormat = "dd/MM/yyyy")
	@Mapping(target = "hora", dateFormat = "HH:mm:ss")
	@Mapping(target = "doctor.id", source = "idDoctor")
	@Mapping(target = "paciente.id", source = "idPaciente")
	public abstract CitaModel toModel(CitaDto source);
	
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "autorizacion", ignore = true)
	@Mapping(target = "novedades", ignore = true)
	@Mapping(target = "doctor.id", source = "idDoctor")
	@Mapping(target = "paciente.id", source = "idPaciente")
	@Mapping(target = "fecha", dateFormat = "dd/MM/yyyy")
	@Mapping(target = "hora", dateFormat = "HH:mm:ss")
	public abstract void merge(@MappingTarget  CitaModel model, CitaDto dto);

}

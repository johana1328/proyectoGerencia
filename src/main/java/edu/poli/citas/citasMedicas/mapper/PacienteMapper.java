package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.PacienteDto;
import edu.poli.citas.citasMedicas.model.PacienteModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PacienteMapper {

	@Mapping(target = "citas", ignore = true)
	public abstract PacienteDto toDto(PacienteModel source);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	public abstract PacienteModel toModel(PacienteDto source);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	public abstract void merge(@MappingTarget PacienteModel model, PacienteDto dto);

}

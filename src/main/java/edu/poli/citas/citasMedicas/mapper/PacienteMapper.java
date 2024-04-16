package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.PacienteDto;
import edu.poli.citas.citasMedicas.model.PacienteModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PacienteMapper {
	public abstract PacienteDto toDto(PacienteModel source);
	
	@Mapping(target = "id", ignore = true)
	public abstract PacienteDto toModel(PacienteDto source);

}

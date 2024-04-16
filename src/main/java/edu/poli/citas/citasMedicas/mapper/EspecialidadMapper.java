package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.EspecialidadDto;
import edu.poli.citas.citasMedicas.model.EspecialidadModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EspecialidadMapper {
	
	public abstract EspecialidadDto toDto(EspecialidadModel source);

	@Mapping(target = "id", ignore = true)
	public abstract EspecialidadModel toModel(EspecialidadDto source);

}

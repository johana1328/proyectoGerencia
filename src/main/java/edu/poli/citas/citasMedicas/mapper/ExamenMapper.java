package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.ExamenDto;
import edu.poli.citas.citasMedicas.model.ExamenModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ExamenMapper {
	
	public abstract ExamenDto toDto(ExamenModel source);

	@Mapping(target = "id", ignore = true)
	public abstract ExamenModel toModel(ExamenDto source);


}

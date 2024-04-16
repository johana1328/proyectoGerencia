package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.AutorizacionDto;
import edu.poli.citas.citasMedicas.model.AutorizacionModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class AutorizacionMapper {
	
	public abstract AutorizacionDto toDto(AutorizacionModel source);
	
	@Mapping(target = "id", ignore = true)
	public abstract AutorizacionModel toModel(AutorizacionDto source);

}

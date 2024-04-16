package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.EmpleadoDto;
import edu.poli.citas.citasMedicas.model.EmpleadoModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EmpleadoMapper {
	
	public abstract EmpleadoDto toDto(EmpleadoModel source);
	
	@Mapping(target = "id", ignore = true)
	public abstract EmpleadoModel toModel(EmpleadoDto source);


}

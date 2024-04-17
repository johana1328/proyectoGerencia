package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.EmpleadoDto;
import edu.poli.citas.citasMedicas.model.EmpleadoModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EmpleadoMapper {
	

	@Mapping(target = "citas", ignore = true)
	public abstract EmpleadoDto toDto(EmpleadoModel model);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	public abstract EmpleadoModel toModel(EmpleadoDto source);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	public abstract EmpleadoModel merge(@MappingTarget  EmpleadoModel model, EmpleadoDto dto);


}

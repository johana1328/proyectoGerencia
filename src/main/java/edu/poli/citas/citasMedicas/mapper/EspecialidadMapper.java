package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.EspecialidadDto;
import edu.poli.citas.citasMedicas.model.EspecialidadModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EspecialidadMapper {
	
	@Mapping(target = "empleados", ignore = true)
	public abstract EspecialidadDto toDto(EspecialidadModel model);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "empleados", ignore = true)
	public abstract EspecialidadModel toModel(EspecialidadDto source);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "empleados", ignore = true)
	public abstract EspecialidadModel merge(@MappingTarget  EspecialidadModel model, EspecialidadDto dto);

}

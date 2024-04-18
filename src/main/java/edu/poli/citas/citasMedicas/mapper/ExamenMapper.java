package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.ExamenDto;
import edu.poli.citas.citasMedicas.model.ExamenModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ExamenMapper {
	
	@Mapping(target = "autorizacion", ignore = true)
	public abstract ExamenDto toDto(ExamenModel model);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "autorizacion", ignore = true)
	public abstract ExamenModel toModel(ExamenDto source);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "autorizacion", ignore = true)
	public abstract ExamenModel merge(@MappingTarget  ExamenModel model, ExamenDto dto);



}

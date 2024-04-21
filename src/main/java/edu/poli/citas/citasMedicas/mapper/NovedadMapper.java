package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.NovedadDto;
import edu.poli.citas.citasMedicas.model.NovedadModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class NovedadMapper {

	@Mapping(target = "cita", ignore = true)
	@Mapping(target = "idCita", ignore = true)
	public abstract NovedadDto toDto(NovedadModel source);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "cita.id", source = "idCita")
	public abstract NovedadModel toModel(NovedadDto source);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "cita.id", ignore = true)
	public abstract void merge(@MappingTarget NovedadModel model, NovedadDto dto);

}

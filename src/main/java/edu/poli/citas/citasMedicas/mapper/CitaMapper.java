package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.poli.citas.citasMedicas.dto.CitaDto;
import edu.poli.citas.citasMedicas.model.CitaModel;

@Mapper(componentModel = "spring")
public  abstract class CitaMapper {
	
	public abstract CitaDto toDto(CitaModel source);
	
	@Mapping(target = "id", ignore = true)
	public abstract CitaModel toModel(CitaDto source);

}

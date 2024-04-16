package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.UsuarioDto;
import edu.poli.citas.citasMedicas.model.UsuarioModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UsuarioMapper {
	
	public abstract UsuarioDto toDto(UsuarioModel source);
	
	@Mapping(target = "id", ignore = true)
	public abstract UsuarioModel toModel(UsuarioDto source);


}

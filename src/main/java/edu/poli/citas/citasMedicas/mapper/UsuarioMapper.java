package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.ExamenDto;
import edu.poli.citas.citasMedicas.dto.UsuarioDto;
import edu.poli.citas.citasMedicas.model.ExamenModel;
import edu.poli.citas.citasMedicas.model.UsuarioModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UsuarioMapper {
	
	@Mapping(target = "citas", ignore = true)
	public abstract UsuarioDto toDto(UsuarioModel model);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	public abstract UsuarioModel toModel(UsuarioDto source);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	public abstract UsuarioModel merge(@MappingTarget  UsuarioModel model, UsuarioDto dto);


}

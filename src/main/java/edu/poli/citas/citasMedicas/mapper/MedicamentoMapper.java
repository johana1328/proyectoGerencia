package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.MedicamentoDto;
import edu.poli.citas.citasMedicas.model.MedicamentoModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class MedicamentoMapper {
	
	@Mapping(target = "autorizacion", ignore = true)
	public abstract MedicamentoDto toDto(MedicamentoModel model);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "autorizacion", ignore = true)
	public abstract MedicamentoModel toModel(MedicamentoDto source);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "autorizacion", ignore = true)
	public abstract MedicamentoModel merge(@MappingTarget  MedicamentoModel model, MedicamentoDto dto);

}

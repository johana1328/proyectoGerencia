package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.MedicamentoDto;
import edu.poli.citas.citasMedicas.model.MedicamentoModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class MedicamentoMapper {
	
	public abstract MedicamentoDto toDto(MedicamentoModel source);

	@Mapping(target = "id", ignore = true)
	public abstract MedicamentoModel toModel(MedicamentoDto source);

}

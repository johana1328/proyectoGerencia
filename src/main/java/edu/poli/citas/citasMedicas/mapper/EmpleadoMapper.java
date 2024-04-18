package edu.poli.citas.citasMedicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import edu.poli.citas.citasMedicas.dto.EmpleadoDto;
import edu.poli.citas.citasMedicas.dto.EspecialidadDto;
import edu.poli.citas.citasMedicas.model.EmpleadoModel;
import edu.poli.citas.citasMedicas.model.EspecialidadModel;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EmpleadoMapper {

	@Mapping(target = "citas", ignore = true)
	@Mapping(target = "especialidad.empleados", ignore = true)
	public abstract EmpleadoDto toDto(EmpleadoModel model);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	@Mapping(target = "especialidad.empleados", ignore = true)
	@Mapping(target = "especialidad.descropcion", ignore = true)
	public abstract EmpleadoModel toModel(EmpleadoDto source);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "citas", ignore = true)
	@Mapping(target = "especialidad", qualifiedByName = "setEspecialidad")
	public abstract void merge(@MappingTarget  EmpleadoModel model, EmpleadoDto dto);

	@Named("setEspecialidad")
	public EspecialidadModel setEspecialidad(EspecialidadDto especialidadDto) {
		EspecialidadModel especialidad = new EspecialidadModel();
		especialidad.setId(especialidadDto.getId());
		return especialidad;
	}

}

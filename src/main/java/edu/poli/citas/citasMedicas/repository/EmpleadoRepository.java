package edu.poli.citas.citasMedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.EmpleadoModel;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {

	@Query(value = "select * from EMPLEADO e "
			+ "inner join usuario u on u.id  = e.id "
			+ "where e.tipo_empleado = 'MEDICO'", nativeQuery = true)
	List<EmpleadoModel> listMedicos();

}

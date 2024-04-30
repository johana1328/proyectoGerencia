package edu.poli.citas.citasMedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.EspecialidadModel;

public interface EspecialidadRepository extends JpaRepository<EspecialidadModel, Long> {
	
	@Query(value="select * from ESPECIALIDAD e where e.id > 1", nativeQuery = true)
	List<EspecialidadModel> getEspecialidadesByDoctor();

}

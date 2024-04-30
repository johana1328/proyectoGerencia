package edu.poli.citas.citasMedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.NovedadModel;

public interface NovedadRepository extends JpaRepository<NovedadModel, Long> {

	@Query(value = "select n from NovedadModel n join n.cita as c  where c.id =?1 ")
	List<NovedadModel> listBycitaId(Long idCita);

}

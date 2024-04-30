package edu.poli.citas.citasMedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.AutorizacionModel;

public interface AutorizacionRepository extends JpaRepository<AutorizacionModel, Long> {

	@Query(value = "select n from AutorizacionModel n join n.cita as c  where c.id =?1 ")
	List<AutorizacionModel> listBycitaId(Long idCita);

}

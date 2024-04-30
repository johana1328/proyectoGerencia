package edu.poli.citas.citasMedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.ExamenModel;

public interface ExamenRespository extends JpaRepository<ExamenModel, Long> {

	@Query(value = "select e from ExamenModel e join e.autorizacion as a  where a.id =?1 ")
	List<ExamenModel> listByAutorizacionId(Long idAutorizacion);

	@Modifying
	@Query(value="DELETE FROM examen WHERE id = ?1", nativeQuery = true)
	void deleteByidOpt(long id);
}

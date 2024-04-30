package edu.poli.citas.citasMedicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.MedicamentoModel;

public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {
	
	@Query(value = "select m from MedicamentoModel m join m.autorizacion as a  where a.id =?1 ")
	List<MedicamentoModel> listByAutorizacionId(Long idAutorizacion);

	@Modifying
	@Query(value="DELETE FROM medicamento WHERE id = ?1", nativeQuery = true)
	void deleteByidOpt(long id);

}

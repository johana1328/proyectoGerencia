package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.MedicamentoModel;

public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {

}

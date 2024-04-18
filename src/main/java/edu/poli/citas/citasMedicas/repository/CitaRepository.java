package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.CitaModel;

public interface CitaRepository  extends JpaRepository<CitaModel, Long>{

}

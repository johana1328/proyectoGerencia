package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.PacienteModel;

public interface PacienteRepository  extends JpaRepository<PacienteModel, Long>  {

}

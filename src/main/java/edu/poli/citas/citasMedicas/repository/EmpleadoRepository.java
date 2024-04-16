package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.EmpleadoModel;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {

}

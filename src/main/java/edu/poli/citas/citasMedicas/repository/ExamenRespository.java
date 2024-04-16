package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.ExamenModel;

public interface ExamenRespository extends JpaRepository<ExamenModel, Long>  {

}

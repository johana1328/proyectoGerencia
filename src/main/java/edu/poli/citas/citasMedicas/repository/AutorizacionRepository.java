package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.AutorizacionModel;

public interface AutorizacionRepository extends JpaRepository<AutorizacionModel, Long>  {

}

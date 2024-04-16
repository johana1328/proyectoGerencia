package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.NovedadModel;

public interface NovedadRepository extends JpaRepository<NovedadModel, Long>  {

}

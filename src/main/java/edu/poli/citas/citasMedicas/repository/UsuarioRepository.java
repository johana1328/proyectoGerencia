package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poli.citas.citasMedicas.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}

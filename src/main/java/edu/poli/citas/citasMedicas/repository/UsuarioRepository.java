package edu.poli.citas.citasMedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poli.citas.citasMedicas.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	@Query(value = "select (nombre || ' ' || apellido) AS Nombre_Completo, tipo_empleado, password "
			+ " from  usuario u "
			+ "	left join empleado e on e.id = u.id " 
			+ "	where u.documento = ?1", nativeQuery = true)
	Object[] findByDocumento(String documento);

}

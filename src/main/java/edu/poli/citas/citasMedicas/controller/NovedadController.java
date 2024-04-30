package edu.poli.citas.citasMedicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poli.citas.citasMedicas.dto.NovedadDto;
import edu.poli.citas.citasMedicas.service.NovedadService;

@Controller
@RequestMapping("/cita/{id_cita}/novedades")
public class NovedadController {

	@Autowired
	private NovedadService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@RequestBody NovedadDto novedad, @PathVariable(name = "id_cita") Long idCita) {
		service.create(novedad, idCita);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(path = "/{id_novedad}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@RequestBody NovedadDto novedad, @PathVariable(name = "id_cita") Long idCita,
			@PathVariable(name = "id_novedad") Long idNovedad) throws Exception {
		service.update(novedad, idCita);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping(path = "/{id_novedad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable(name = "id_cita") Long idCita,
			@PathVariable(name = "id_novedad") Long idNovedad) throws Exception {
		service.delete(idNovedad);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}

package edu.poli.citas.citasMedicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poli.citas.citasMedicas.dto.AutorizacionDto;
import edu.poli.citas.citasMedicas.service.AutorizacionService;

@Controller
@RequestMapping("/cita/{id_cita}/autorizaciones")
public class AutorizacionController {

	@Autowired
	private AutorizacionService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@RequestBody AutorizacionDto autorizacion,
			@PathVariable(name = "id_cita") Long idCita) {
		service.create(autorizacion, idCita);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}

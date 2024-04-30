package edu.poli.citas.citasMedicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poli.citas.citasMedicas.dto.MedicamentoDto;
import edu.poli.citas.citasMedicas.service.MedicamentoService;

@Controller
@RequestMapping("/autorizacion/{id_autorizacion}/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crear(@RequestBody MedicamentoDto medicamento,
			@PathVariable(name = "id_autorizacion") Long idAutorizacion) {
		service.create(medicamento, idAutorizacion);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping(path = "/{id_examen}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable(name = "id_autorizacion") Long idAutorizacion,
			@PathVariable(name = "id_examen") Long idExamen) throws Exception {
		service.delete(idExamen);
		return ResponseEntity.status(HttpStatus.OK).build();
	}


}

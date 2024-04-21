package edu.poli.citas.citasMedicas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poli.citas.citasMedicas.service.NovedadService;

@Controller
@RequestMapping("/cita/{id_cita}/novedades")
public class NovedadController {

	@Autowired
	private NovedadService service;
	



}

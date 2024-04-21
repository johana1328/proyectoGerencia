package edu.poli.citas.citasMedicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poli.citas.citasMedicas.dto.CitaDto;
import edu.poli.citas.citasMedicas.service.NovedadService;

@Controller
@RequestMapping("/cita/{id_cita}/novedades")
public class NovedadController {

	@Autowired
	private NovedadService service;
	



}

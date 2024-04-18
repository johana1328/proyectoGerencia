package edu.poli.citas.citasMedicas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poli.citas.citasMedicas.dto.PacienteDto;
import edu.poli.citas.citasMedicas.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private PacienteService service;

	@GetMapping({ "", "/" })
	public String viewListar(Model model, @RequestParam(name = "accionOk", defaultValue = "NA") String accionOK) {
		List<PacienteDto> pacientes = service.getList();
		model.addAttribute("accionOk", accionOK);
		model.addAttribute("pacientes", pacientes);
		return "paciente/listarPaciente";
	}

	@GetMapping("/create")
	public String viewCrear(Model model) {
		PacienteDto paciente = new PacienteDto();
		model.addAttribute("paciente", paciente);
		return "paciente/pacienteForm";
	}

	@GetMapping("/update/{id}")
	public String viewUpdate(@PathVariable Long id, Model model) {
		Optional<PacienteDto> paciente = service.getById(id);
		model.addAttribute("paciente", paciente.get());
		return "paciente/pacienteForm";
	}

	@PostMapping("/create")
	public String crear(Model model, @ModelAttribute("paciente") PacienteDto paciente) {
		service.create(paciente);
		return "redirect:/paciente?accionOk=create";
	}

	@PostMapping("/update/{id}")
	public String update(Model model, @PathVariable Long id, @ModelAttribute("paciente") PacienteDto paciente) {
		try {
			service.update(paciente, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/paciente?accionOk=update";
	}

	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/paciente?accionOk=delete";
	}
}

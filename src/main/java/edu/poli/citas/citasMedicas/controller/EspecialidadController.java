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

import edu.poli.citas.citasMedicas.dto.EspecialidadDto;
import edu.poli.citas.citasMedicas.service.EspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadService service;

	@GetMapping({ "", "/" })
	public String viewListar(Model model, @RequestParam(name = "accionOk",defaultValue = "NA") String accionOK) {
		List<EspecialidadDto> especialidades = service.getList();
		model.addAttribute("accionOk", accionOK);
		model.addAttribute("especialidades", especialidades);
		return "especialidad/listarEspecialidades";
	}

	@GetMapping("/create")
	public String viewCrear(Model model) {
		EspecialidadDto especialidad = new EspecialidadDto();
		model.addAttribute("especialidad", especialidad);
		return "especialidad/especialidadForm";
	}

	@GetMapping("/update/{id}")
	public String viewUpdate(@PathVariable Long id, Model model) {
		Optional<EspecialidadDto> especialidad = service.getById(id);
		model.addAttribute("especialidad", especialidad.get());
		return "especialidad/especialidadForm";
	}

	@PostMapping("/create")
	public String crear(Model model, @ModelAttribute("especialidad") EspecialidadDto especialidad) {
		service.create(especialidad);
		return "redirect:/especialidad?accionOk=create";
	}

	@PostMapping("/update/{id}")
	public String update(Model model, @PathVariable Long id,
			@ModelAttribute("especialidad") EspecialidadDto especialidad) {
		try {
			service.update(especialidad, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/especialidad?accionOk=update";
	}

	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/especialidad?accionOk=delete";
	}

}

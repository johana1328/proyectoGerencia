package edu.poli.citas.citasMedicas.controller;

import java.util.ArrayList;
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

import edu.poli.citas.citasMedicas.dto.CitaDto;
import edu.poli.citas.citasMedicas.dto.EmpleadoDto;
import edu.poli.citas.citasMedicas.dto.PacienteDto;
import edu.poli.citas.citasMedicas.service.CitaService;
import edu.poli.citas.citasMedicas.service.EmpleadoService;
import edu.poli.citas.citasMedicas.service.PacienteService;
import edu.poli.citas.citasMedicas.service.UsuarioService;

@Controller
@RequestMapping("/cita")
public class CitaController {

	@Autowired
	private CitaService service;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private PacienteService pacienteService;

	@GetMapping({ "", "/" })
	public String viewListar(Model model, @RequestParam(name = "accionOk", defaultValue = "NA") String accionOK) {
		List<CitaDto> citas = service.getList();
		model.addAttribute("accionOk", accionOK);
		model.addAttribute("citas", citas);
		return "cita/listarCitas";
	}

	@GetMapping({ "/create/{pacienteId}", "/create" })
	public String viewCrear(Model model, @PathVariable Optional<Long> pacienteId) {
		CitaDto cita = new CitaDto();
		List<PacienteDto> pacientes = new ArrayList<>();
		if (pacienteId.isPresent()) {
			Optional<PacienteDto> pacienteOP =  pacienteService.getById(pacienteId.get());
			model.addAttribute("paciente", pacienteOP.get());
			model.addAttribute("mode", "USER");
		}else {
			pacientes = pacienteService.getList();
			model.addAttribute("pacientes", pacientes);
			model.addAttribute("mode", "ASESOR");
		}
		List<EmpleadoDto> medicos = empleadoService.getListMedicos();
		model.addAttribute("medicos", medicos);
		model.addAttribute("cita", cita);
		return "cita/citaForm";
	}

	@GetMapping({"/update/{id}"})
	public String viewUpdate(@PathVariable Long id, Model model,  @PathVariable Optional<Long> pacienteId) {
		Optional<CitaDto> cita = service.getById(id);
		List<EmpleadoDto> medicos = empleadoService.getListMedicos();
		model.addAttribute("mode", "USER");
		model.addAttribute("medicos", medicos);
		model.addAttribute("cita", cita.get());
		model.addAttribute("paciente", cita.get().getPaciente());
		return "cita/citaForm";
	}

	@PostMapping("/create")
	public String crear(Model model, @ModelAttribute("cita") CitaDto cita) {
		service.create(cita);
		return "redirect:/cita?accionOk=create";
	}

	@PostMapping("/update/{id}")
	public String update(Model model, @PathVariable Long id, @ModelAttribute("cita") CitaDto cita) {
		try {
			service.update(cita, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/cita?accionOk=update";
	}

	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/cita?accionOk=delete";
	}

}

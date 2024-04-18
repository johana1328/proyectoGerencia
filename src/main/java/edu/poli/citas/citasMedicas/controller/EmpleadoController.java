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

import edu.poli.citas.citasMedicas.dto.EmpleadoDto;
import edu.poli.citas.citasMedicas.dto.EspecialidadDto;
import edu.poli.citas.citasMedicas.service.EmpleadoService;
import edu.poli.citas.citasMedicas.service.EspecialidadService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;
	
	@Autowired
	private EspecialidadService especialidadService;

	@GetMapping({ "", "/" })
	public String viewListar(Model model, @RequestParam(name = "accionOk", defaultValue = "NA") String accionOK) {
		List<EmpleadoDto> empleados = service.getList();
		model.addAttribute("accionOk", accionOK);
		model.addAttribute("empleados", empleados);
		return "empleado/listarEmpleados";
	}
 
	@GetMapping("/create/{mode}")
	public String viewCrear(Model model, @PathVariable String mode) {
		EmpleadoDto especialidad = new EmpleadoDto();
		List<EspecialidadDto> especialidades = especialidadService.getList();
		model.addAttribute("mode",mode);
		model.addAttribute("especialidades",especialidades);
		model.addAttribute("empleado", especialidad);
		return "empleado/empleadoForm";
	}

	@GetMapping("/update/{id}")
	public String viewUpdate(@PathVariable Long id, Model model) {
		Optional<EmpleadoDto> empleado = service.getById(id);
		List<EspecialidadDto> especialidades = especialidadService.getList();
		model.addAttribute("especialidades",especialidades);
		model.addAttribute("empleado", empleado.get());
		return "empleado/empleadoForm";
	}

	@PostMapping("/create")
	public String crear(Model model, @ModelAttribute("especialidad") EmpleadoDto empleado) {
		service.create(empleado);
		return "redirect:/empleado?accionOk=create";
	}

	@PostMapping("/update/{id}")
	public String update(Model model, @PathVariable Long id, @ModelAttribute("empleado") EmpleadoDto empleado) {
		try {
			service.update(empleado, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/empleado?accionOk=update";
	}

	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/empleado?accionOk=delete";
	}

}

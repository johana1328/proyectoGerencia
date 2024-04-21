package edu.poli.citas.citasMedicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class LoginController {

	@GetMapping({ "", "/" })
	public String viewLogin() {

		return "login/login";
	}

}

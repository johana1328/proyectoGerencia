package edu.poli.citas.citasMedicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping({ "", "/" })
	public String viewLogin() {

		return "login/login";
	}

}

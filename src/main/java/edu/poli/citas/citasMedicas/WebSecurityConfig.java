package edu.poli.citas.citasMedicas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import edu.poli.citas.citasMedicas.service.LoginService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private LoginService authProvider;

	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(authProvider);
		return authenticationManagerBuilder.build();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/", "/public/**").permitAll().anyRequest().authenticated())
				.formLogin((form) -> form.loginPage("/login").permitAll().defaultSuccessUrl("/inicio"))
				.logout((logout) -> logout.permitAll());
		return http.build();
	}

}

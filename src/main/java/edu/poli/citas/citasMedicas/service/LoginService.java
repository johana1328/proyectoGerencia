package edu.poli.citas.citasMedicas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import edu.poli.citas.citasMedicas.repository.UsuarioRepository;

@Service
public class LoginService implements AuthenticationProvider {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		Object[] usuarioModelList = repository.findByDocumento(username);
		if (usuarioModelList != null && usuarioModelList.length == 1) {
			Object[] usuarioModel = (Object[]) usuarioModelList[0];
			String passwordBd =  (String)usuarioModel[2];
			String nombreCompleto = (String)usuarioModel[0];
			if (passwordBd.equals(password)) {
				String tipoUsuario = (String) usuarioModel[1];
				tipoUsuario = (tipoUsuario == null) ? "PACIENTE" : tipoUsuario;
				return authenticateAgainstThirdPartyAndGetAuthentication(nombreCompleto, password, tipoUsuario);
			}
		}
		return null;

	}

	private UsernamePasswordAuthenticationToken authenticateAgainstThirdPartyAndGetAuthentication(String name,
			String password, String tipoUsuario) {
		final List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority(tipoUsuario));
		final UserDetails principal = new User(name, password, grantedAuths);
		return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
	}

}

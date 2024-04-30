package edu.poli.citas.citasMedicas;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.poli.citas.citasMedicas.model.UsuarioModel;

public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioModel usuario;
	private String userType;

	public UserPrincipal(UsuarioModel usuario, String userType) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority(this.userType));
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getNombre() + " " + usuario.getApellido();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

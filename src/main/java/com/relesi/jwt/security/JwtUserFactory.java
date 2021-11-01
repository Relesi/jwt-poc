package com.relesi.jwt.security;



import java.util.ArrayList;
import java.util.List;

import com.relesi.jwt.domain.User;
import com.relesi.jwt.enums.ProfileEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;





public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converts and generates a JwtUser based on data from a User.
	 * 
	 * @param user
	 * @return JwtUser
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getSenha(),
				mapToGrantedAuthorities(user.getProfile()));

	}

	/**
	 * Converts the user profile to the format used by Spring Security.
	 * 
	 * @param profileEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}

}

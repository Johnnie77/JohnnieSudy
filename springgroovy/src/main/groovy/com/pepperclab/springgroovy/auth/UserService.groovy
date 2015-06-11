package com.pepperclab.springgroovy.auth

import com.pepperclab.springgroovy.user.UserRepository
import com.pepperclab.springgroovy.user.UserRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by johney on 15. 6. 10..
 */
@Service
@Qualifier("userService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		com.pepperclab.springgroovy.user.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

		return buildUserForAuthentication(user, authorities);

	}

	private User buildUserForAuthentication(com.pepperclab.springgroovy.user.User user,
											List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}

		return authorities;
	}
}

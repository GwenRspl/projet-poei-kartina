package com.ajc.kartina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ajc.kartina.model.User;
import com.ajc.kartina.repository.UserRepository;
import com.ajc.kartina.security.model.UserPrinciple;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository	.findByEmail(email)
									.orElseThrow(() -> new UsernameNotFoundException(
											"User not found with email : " + email));
		return UserPrinciple.build(user);
	}

	public User save(User user) {
		System.out.println(user);
		User newUser = user;
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

}

package com.musc.kanban.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musc.kanban.model.Rol;
import com.musc.kanban.model.User;
import com.musc.kanban.payload.request.SignUpRequest;
import com.musc.kanban.repository.RoleRepository;
import com.musc.kanban.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository rolRepository;

	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {

		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {

		}

		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<Rol> roles = new HashSet<>();
		Optional<Rol> userRol = rolRepository.findByName("ROLE_USER");
		if (!userRol.isPresent()) {

		}

		roles.add(userRol.get());

		user.setRoles(roles);

		userRepository.save(user);

		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
}

package com.ratemygame.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.entity.CustomUserDetails;
import com.ratemygame.entity.Role;
import com.ratemygame.entity.User;
import com.ratemygame.repository.UserRepository;
import com.ratemygame.wrapper.UserWrapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private UserWrapper userMapper;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userRepository.findByUsername(username);
		
		optionalUser.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
		return optionalUser.map(CustomUserDetails::new).get();
	}
	
	public void createUser (UserDTO userDTO) {
		User user = userMapper.getUser(userDTO);
		Set<Role> roles = new HashSet<Role>();
		roles.add(new Role("USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}
	
	public User emailExists(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		return optional.orElse(null);
	}
	
	public User usernameExists(String username) {
		Optional<User> optional = userRepository.findByUsername(username);
		return optional.orElse(null);
	}

}

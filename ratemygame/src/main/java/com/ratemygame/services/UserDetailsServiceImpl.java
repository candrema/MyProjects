package com.ratemygame.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	public UserDTO transformUserToDTO(User user) {
		return userMapper.getUserDTO(user);
	}
	
	public User emailExists(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		return optional.orElse(null);
	}
	
	public User usernameExists(String username) {
		Optional<User> optional = userRepository.findByUsername(username);
		return optional.orElse(null);
	}
	
    public UserDTO getLoginUserDTO() {
    	if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
    		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		return transformUserToDTO(user);
    	}
    	
    	return new UserDTO();
    }
    
    public User getLoginUser() {
    	if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
    		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		return user;
    	}
    	
    	return new User();
    }
    
    @Transactional
    public UserDTO registerUser(UserDTO userDTO) {
    	try {
    		userRepository.save(userMapper.getUser(userDTO));
    	} catch (Exception ex) {
    		return null;
    	}
    	return userDTO;
    }

}

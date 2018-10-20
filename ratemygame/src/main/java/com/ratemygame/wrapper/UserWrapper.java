package com.ratemygame.wrapper;

import org.modelmapper.ModelMapper;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.entity.User;

public class UserWrapper extends ModelMapper{
	
	public UserDTO getUserDTO(User user) {
		return map(user, UserDTO.class);
	}
	
	public User getUser(UserDTO userDTO) {
		return map(userDTO, User.class);
	}
}

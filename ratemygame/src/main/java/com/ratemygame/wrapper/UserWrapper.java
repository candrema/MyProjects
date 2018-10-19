package com.ratemygame.wrapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.entity.User;

public class UserWrapper {

	@Autowired
    private static ModelMapper modelMapper;
	
	public static UserDTO getUserDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}
	
	public static User getUser(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}
}

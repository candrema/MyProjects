package com.ratemygame.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ratemygame.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByUsername(String username);
}
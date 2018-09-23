package com.ratemygame.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ratemygame.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByName(String username);
}

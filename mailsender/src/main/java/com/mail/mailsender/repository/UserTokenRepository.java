package com.mail.mailsender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.mailsender.entity.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, String>{

	public Optional<UserToken> findByIdAndUserId(String id, long userId);
}

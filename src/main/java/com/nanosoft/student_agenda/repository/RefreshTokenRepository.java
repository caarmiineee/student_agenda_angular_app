package com.nanosoft.student_agenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanosoft.student_agenda.model.RefreshToken;
import com.nanosoft.student_agenda.model.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	@Override
    Optional<RefreshToken> findById(Long id);
	
    Optional<RefreshToken> findByToken(String token);

	Integer deleteByUser(Optional<User> findById);
	
}

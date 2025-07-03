package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 // ✅ Only return user if not soft-deleted
    Optional<User> findByEmailAndDeletedFalse(String email);

    // ✅ Find by ID only if not deleted
    Optional<User> findByIdAndDeletedFalse(Long id);

    // ✅ Return all users who are not soft-deleted
    List<User> findAllByDeletedFalse();
}
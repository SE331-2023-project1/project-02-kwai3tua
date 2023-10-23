package com.se331.kwai3tua.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
  Optional<User> findById(Long id);
  boolean existsByUsername(String username);
  List<User> findAll();
}

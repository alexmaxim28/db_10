package com.example.tema_10.repository;

import com.example.tema_10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

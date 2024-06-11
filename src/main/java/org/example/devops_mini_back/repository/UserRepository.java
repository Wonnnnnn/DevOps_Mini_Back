package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

package org.example.devops_mini_back.repository;

import org.example.devops_mini_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< Updated upstream
public interface UserRepository extends JpaRepository<User, Integer> {
=======
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsById(String userid);
>>>>>>> Stashed changes
}

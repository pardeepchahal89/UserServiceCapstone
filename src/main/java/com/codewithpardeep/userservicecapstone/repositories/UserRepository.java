package com.codewithpardeep.userservicecapstone.repositories;

import com.codewithpardeep.userservicecapstone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);
    Optional<User> findByEmail(String email);
}

package com.codewithpardeep.userservicecapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpardeep.userservicecapstone.models.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Token save(Token token);
}

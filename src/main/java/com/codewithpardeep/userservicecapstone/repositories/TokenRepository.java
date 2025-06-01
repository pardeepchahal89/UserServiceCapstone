package com.codewithpardeep.userservicecapstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpardeep.userservicecapstone.models.Token;

import java.util.Date;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Token save(Token token);

    Optional<Token> findByTokenValueAndDeletedAndExpireAtGreaterThan(String tokenValue, boolean deleted, Date expireAt);
}

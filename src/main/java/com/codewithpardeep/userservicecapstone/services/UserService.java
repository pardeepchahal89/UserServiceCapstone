package com.codewithpardeep.userservicecapstone.services;


import com.codewithpardeep.userservicecapstone.models.Token;
import com.codewithpardeep.userservicecapstone.models.User;


public interface UserService {
    User signup(String name, String email, String password);

    Token login(String email, String password);

    void logout(Token token);

    User validateToken(String token);

}

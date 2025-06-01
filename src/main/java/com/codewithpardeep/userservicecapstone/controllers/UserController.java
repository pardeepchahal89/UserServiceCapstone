package com.codewithpardeep.userservicecapstone.controllers;


import com.codewithpardeep.userservicecapstone.dtos.LoginRequestDto;
import com.codewithpardeep.userservicecapstone.dtos.LoginResponseDto;
import com.codewithpardeep.userservicecapstone.dtos.SignupRequestDto;
import com.codewithpardeep.userservicecapstone.dtos.UserDto;
import com.codewithpardeep.userservicecapstone.models.User;
import com.codewithpardeep.userservicecapstone.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.codewithpardeep.userservicecapstone.models.Token;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        User user = userService.signup(signupRequestDto.getName(), signupRequestDto.getEmail(), signupRequestDto.getPassword());
        return UserDto.from(user);
    }


    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        Token token = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setTokenValue(token.getTokenValue());
        return loginResponseDto;
    }

    public void logout() {
    }

    public void validateToken(String token) {
    }
}

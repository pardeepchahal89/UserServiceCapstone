package com.codewithpardeep.userservicecapstone.controllers;


import com.codewithpardeep.userservicecapstone.dtos.*;
import com.codewithpardeep.userservicecapstone.models.User;
import com.codewithpardeep.userservicecapstone.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codewithpardeep.userservicecapstone.models.Token;


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

    @PostMapping("/logout")
    public RequestEntity<Void> logout(@RequestBody LogoutRequestDto logoutRequestDto) {
        return null;
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable("token") String tokenValue) {
        User user = userService.validateToken(tokenValue);
        ResponseEntity<Boolean> responseEntity;
        if(user != null) {
            responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}

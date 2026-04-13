package com.todesco.gamehub.controller;

import com.todesco.gamehub.config.TokenConfig;
import com.todesco.gamehub.dtos.request.LoginRequest;
import com.todesco.gamehub.dtos.request.UserRequest;
import com.todesco.gamehub.dtos.response.LoginResponse;
import com.todesco.gamehub.dtos.response.UserResponse;
import com.todesco.gamehub.entity.User;
import com.todesco.gamehub.exception.UserNameOrPasswordInvalidException;
import com.todesco.gamehub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamehub/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        try {
            UsernamePasswordAuthenticationToken userAndPass =
                    new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

            Authentication authentication = authenticationManager.authenticate(userAndPass);
            User user = (User) authentication.getPrincipal();
            String token = tokenConfig.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException e){
            throw new UserNameOrPasswordInvalidException("Usuário ou senha inválido");
        }
    }
}

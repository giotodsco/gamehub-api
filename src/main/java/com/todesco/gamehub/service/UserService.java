package com.todesco.gamehub.service;

import com.todesco.gamehub.dtos.request.UserRequest;
import com.todesco.gamehub.dtos.response.UserResponse;
import com.todesco.gamehub.entity.User;
import com.todesco.gamehub.mapper.UserMapper;
import com.todesco.gamehub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserRequest userRequest){
        User user = UserMapper.toRequest(userRequest);

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
        return UserMapper.toResponse(user);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest){
        User userById = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));

        userById.setEmail(userRequest.email());
        userById.setPassword(userRequest.password());
        userById.setName(userRequest.name());

        userRepository.save(userById);
        return UserMapper.toResponse(userById);
    }

}

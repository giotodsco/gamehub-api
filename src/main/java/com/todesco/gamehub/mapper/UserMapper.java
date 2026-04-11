package com.todesco.gamehub.mapper;

import com.todesco.gamehub.dtos.request.UserRequest;
import com.todesco.gamehub.dtos.response.UserResponse;
import com.todesco.gamehub.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static User toRequest(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }


}

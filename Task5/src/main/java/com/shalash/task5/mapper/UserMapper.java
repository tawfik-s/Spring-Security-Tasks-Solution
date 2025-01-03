package com.shalash.task5.mapper;


import com.shalash.task5.enitity.UserDetailsImpl;
import com.shalash.task5.model.UserRequest;
import com.shalash.task5.model.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserDetailsImpl toEntity(UserRequest userRequest) {
        return UserDetailsImpl.builder()
                .name(userRequest.getUserName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role("ROLE_USER").build();
    }

    public UserResponse toResponse(UserDetailsImpl userDetailsImpl) {
        return UserResponse.builder()
                .username(userDetailsImpl.getName())
                .email(userDetailsImpl.getEmail())
                .id(userDetailsImpl.getId())
                .build();
    }
}

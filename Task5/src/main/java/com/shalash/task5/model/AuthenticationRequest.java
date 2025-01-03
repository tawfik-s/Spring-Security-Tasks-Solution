package com.shalash.task5.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotNull
    @Size(min=5,max=32,
            message = "password size should be between" +
                      " 5 and 32 digit or character")
    private String email;

    @NotNull(message = "can't be null to signIn with knew user")
    @Size(min=5,max=32,
            message = "password size should be between" +
                      " 5 and 32 digit or character")
    private String password;
}

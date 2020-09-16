package com.javabegin.bookslibrary.security;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthenticationRequestDTO {
    private String username;
    private String password;
}

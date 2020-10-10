package com.javabegin.bookslibrary.config;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;


@Getter
public class JwtAuthenticationException extends AuthenticationException {

    private HttpStatus status;
    public JwtAuthenticationException(String msg, HttpStatus unauthorized) {
        super(msg);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
	//super(msg);
    }
}

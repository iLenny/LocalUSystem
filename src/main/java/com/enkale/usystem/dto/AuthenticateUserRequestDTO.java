package com.enkale.usystem.dto;

public class AuthenticateUserRequestDTO {
    private String email;
    private String password;

    public AuthenticateUserRequestDTO() {
    }

    public AuthenticateUserRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public AuthenticateUserRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthenticateUserRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }


}

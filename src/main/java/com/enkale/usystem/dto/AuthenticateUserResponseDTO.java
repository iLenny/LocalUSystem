package com.enkale.usystem.dto;

import com.enkale.usystem.domain.User;

public class AuthenticateUserResponseDTO extends ResponseDTO {
    private User user;

    public User getUser() {
        return user;
    }

    public AuthenticateUserResponseDTO setUser(User user) {
        this.user = user;
        return this;
    }
}

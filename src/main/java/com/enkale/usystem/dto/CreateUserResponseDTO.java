package com.enkale.usystem.dto;

import com.enkale.usystem.domain.User;

public class CreateUserResponseDTO extends ResponseDTO{
    private User user;
    public CreateUserResponseDTO() {
    }

    public CreateUserResponseDTO(ResponseStatus status, String message) {
        super(status, message);
    }

    public User getUser() {
        return user;
    }

    public CreateUserResponseDTO setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "CreateUserResponseDTO{" +
                "status=" + super.getStatus() +
                ", message=" + super.getMessage() +
                ", reason=" + super.getReason() +
                ", user=" + user +
                '}';
    }
}

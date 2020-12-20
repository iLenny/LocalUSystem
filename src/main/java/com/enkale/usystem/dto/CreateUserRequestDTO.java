package com.enkale.usystem.dto;

import java.time.LocalDate;

public class CreateUserRequestDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String password;

    public CreateUserRequestDTO() {
    }

    public CreateUserRequestDTO(String firstName, String middleName, String lastName, LocalDate dob, String email, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateUserRequestDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public CreateUserRequestDTO setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateUserRequestDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public CreateUserRequestDTO setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserRequestDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserRequestDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "CreateUserRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

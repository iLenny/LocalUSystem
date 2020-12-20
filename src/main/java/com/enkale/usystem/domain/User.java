package com.enkale.usystem.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String password;
    private String saltKey;
    private LocalDateTime memberSince;
    private LocalDateTime lastUpdated;


    public User() {

    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public User setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public User setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSaltKey() {
         return saltKey;
    }

    public User setSaltKey(String saltKey) {
        this.saltKey = saltKey;
        return this;
    }

    public LocalDateTime getMemberSince() {
        return memberSince;
    }

    public User setMemberSince(LocalDateTime memberSince) {
        this.memberSince = memberSince;
        return this;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public User setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", saltKey='" + saltKey + '\'' +
                ", memberSince=" + memberSince +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

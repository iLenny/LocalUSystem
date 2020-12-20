package com.enkale.usystem.service;

import com.enkale.usystem.domain.User;
import com.enkale.usystem.dto.CreateUserRequestDTO;
import com.enkale.usystem.dto.CreateUserResponseDTO;
import com.enkale.usystem.dto.ResponseStatus;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class UserService {
    private static int id = 0;

    public CreateUserResponseDTO createUser(CreateUserRequestDTO requestDTO) {
        CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();

        if(requestDTO == null) {
            responseDTO.setStatus(ResponseStatus.ERROR);
            responseDTO.setMessage("Unable to create user");
            responseDTO.setReason("Request is null");
            return responseDTO;
        }

        // Get data from request
        String firstName = requestDTO.getFirstName();
        String middleName = requestDTO.getMiddleName();
        String lastName = requestDTO.getLastName();
        LocalDate dob = requestDTO.getDob();
        String email = requestDTO.getEmail();
        String password = requestDTO.getPassword();

        // Check for mandatory fields
        StringBuilder errorBuilder = new StringBuilder(); // To capture missing fields
        if(isNullOrEmpty(firstName)) errorBuilder.append("firstName ");
        if(isNullOrEmpty(lastName)) errorBuilder.append("lastName ");
        if(dob == null) errorBuilder.append("dob ");
        if(isNullOrEmpty(email)) errorBuilder.append("email ");
        if(isNullOrEmpty(password)) errorBuilder.append("password ");

        // If we got some errors
        if(!errorBuilder.toString().isEmpty()) {
            responseDTO.setStatus(ResponseStatus.ERROR);
            responseDTO.setMessage("Unable to process the fields: " + errorBuilder.toString());
            responseDTO.setReason("Field(s) are either empty or null");
            return responseDTO;
        }


        // Create User:
        LocalDateTime currentTimestamp = LocalDateTime.now();
        User user = new User()
                .setId(id++)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setDob(dob)
                .setEmail(email)
                .setSaltKey(generateSaltKey(10))
                .setMemberSince(currentTimestamp)
                .setLastUpdated(currentTimestamp);


        // Hash password
        String hashedPassword = new DigestUtils(MessageDigestAlgorithms.SHA_256)
                .digestAsHex(password + user.getSaltKey());

        user.setPassword(hashedPassword);


        responseDTO.setStatus(ResponseStatus.SUCCESS);
        responseDTO.setMessage("User created");
        responseDTO.setUser(user);


        return responseDTO;
    }

    private boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    private String generateSaltKey(int size) {
        String combinations="AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz012345679#$@&%";
        Random random = new Random();
        StringBuilder keyBuilder = new StringBuilder();
        for(int i = 0; i < size; i++) {
            keyBuilder.append(combinations.charAt(random.nextInt(combinations.length())));
        }

        return keyBuilder.toString();
    }



}

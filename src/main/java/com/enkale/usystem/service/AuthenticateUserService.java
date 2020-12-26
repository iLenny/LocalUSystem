package com.enkale.usystem.service;

import com.enkale.usystem.domain.User;
import com.enkale.usystem.dto.AuthenticateUserRequestDTO;
import com.enkale.usystem.dto.AuthenticateUserResponseDTO;
import com.enkale.usystem.dto.ResponseStatus;
import com.enkale.usystem.util.CommonMessages;
import com.enkale.usystem.util.CommonReasons;
import com.enkale.usystem.util.DB;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class AuthenticateUserService {

    public AuthenticateUserResponseDTO authenticateUser(AuthenticateUserRequestDTO requestDTO) {
        AuthenticateUserResponseDTO responseDTO = new AuthenticateUserResponseDTO();

        if(requestDTO == null) {
            responseDTO.setStatus(ResponseStatus.ERROR);
            responseDTO.setMessage(CommonMessages.UNABLE_TO_PROCESS_REQUEST);
            responseDTO.setReason(CommonReasons.REQUEST_IS_NULL);
            return responseDTO;
        }

        String email = requestDTO.getEmail();
        String password = requestDTO.getPassword();

        // Check if email and password are null or empty
        StringBuilder errorBuilder = new StringBuilder();
        if(isNullOrEmpty(email)) errorBuilder.append(" email");
        if(isNullOrEmpty(password)) errorBuilder.append(" password");

        // If email or password was found null or empty
        if(!errorBuilder.isEmpty()) {
            responseDTO.setStatus(ResponseStatus.ERROR);
            responseDTO.setMessage(CommonMessages.UNABLE_TO_PROCESS_FIELDS + errorBuilder.toString());
            responseDTO.setReason(CommonReasons.FIELDS_ARE_EMPTY_OR_NULL);
            return responseDTO;
        }

        // find user by email
        User user = null;
        for(User u : DB.users) {
            if(u.getEmail().equals(email)) {
                user = u;
                break;
            }
        }

        // If user not found due to email OR password is incorrect
        if (user == null || !isPasswordCorrect(user, password)) {
            responseDTO.setStatus(ResponseStatus.ERROR);
            responseDTO.setMessage(CommonMessages.ITEM_NOT_FOUND);
            responseDTO.setReason(CommonReasons.INCORRECT_EMAIL_OR_PASSWORD);
            return responseDTO;
        }

        responseDTO.setStatus(ResponseStatus.SUCCESS);
        responseDTO.setMessage(CommonMessages.ITEM_FOUND);
        responseDTO.setUser(user);
        return responseDTO;
    }

    private boolean isPasswordCorrect(User user, String password) {
        // Hash password
        String hashedPassword = new DigestUtils(MessageDigestAlgorithms.SHA_256)
                .digestAsHex(password + user.getSaltKey());
        return (user.getPassword().equals(hashedPassword));
    }

    private boolean isNullOrEmpty(String val) {
        return (val == null || val.isEmpty());
    }
}

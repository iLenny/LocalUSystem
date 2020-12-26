package com.enkale.usystem.service;

import com.enkale.usystem.dto.AuthenticateUserRequestDTO;
import com.enkale.usystem.dto.CreateUserRequestDTO;
import com.enkale.usystem.dto.ResponseStatus;
import com.enkale.usystem.util.CommonMessages;
import com.enkale.usystem.util.CommonReasons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticateUserServiceTest {
    private AuthenticateUserService service;

    @BeforeEach
    public void setup() {
        service = new AuthenticateUserService();
    }

    @Test
    public void authenticateUser_doesNotReturnNull_test() {
        AuthenticateUserRequestDTO requestDTO = new AuthenticateUserRequestDTO();
        assertNotNull(service.authenticateUser(requestDTO));
    }

    @Test
    public void  authenticateUser_whenRequestIsNull_returnErrorAsStatus_test() {
        assertEquals(ResponseStatus.ERROR, service.authenticateUser(null).getStatus());
    }

    @Test
    public void authenticateUser_whenFieldsNullOrEmpty_returnErrorAsStatus_test() {
        assertEquals(ResponseStatus.ERROR, service.authenticateUser(new AuthenticateUserRequestDTO()).getStatus());
    }

    @Test
    public void authenticateUser_whenFieldsNullOrEmpty_returnUnableToProcessFieldsAsMessage_test() {
        String expectedOutput = CommonMessages.UNABLE_TO_PROCESS_FIELDS + " email password";
        assertEquals(expectedOutput, service.authenticateUser(new AuthenticateUserRequestDTO()).getMessage());
    }

    @Test
    public void authenticateUser_whenEmailNullOrEmpty_returnUnableToProcessFieldsAsMessage_test() {
        AuthenticateUserRequestDTO requestDTO = null;
        String expectedOutput = CommonMessages.UNABLE_TO_PROCESS_FIELDS + " email";


        // When email is null
        requestDTO = new AuthenticateUserRequestDTO()
               .setEmail(null)
               .setPassword("test");
        assertEquals(expectedOutput, service.authenticateUser(requestDTO).getMessage());

        // When email is empty
        requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("")
                .setPassword("test");
        assertEquals(expectedOutput, service.authenticateUser(requestDTO).getMessage());
    }

    @Test
    public void authenticateUser_whenPasswordNullOrEmpty_returnUnableToProcessFieldsAsMessage_test() {
        AuthenticateUserRequestDTO requestDTO = null;
        String expectedOutput = CommonMessages.UNABLE_TO_PROCESS_FIELDS + " password";

        // When password is null
        requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("test@gmail.com")
                .setPassword(null);
        assertEquals(expectedOutput, service.authenticateUser(requestDTO).getMessage());

        // When password is empty
        requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("test@gmail.com")
                .setPassword("");
        assertEquals(expectedOutput, service.authenticateUser(requestDTO).getMessage());
    }


    @Test
    public void authenticateUser_whenFieldsNullOrEmpty_returnFieldsAreEmptyOrNullAsReason_test() {
        String expectedOutput = CommonReasons.FIELDS_ARE_EMPTY_OR_NULL;
        String actualOutput = service.authenticateUser(new AuthenticateUserRequestDTO()).getReason();
        assertEquals(expectedOutput, actualOutput );
    }

    @Test
    public void authenticateUser_whenCredentialsAreIncorrect_returnErrorAsStatus_test() {
        AuthenticateUserRequestDTO requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("test@test.com")
                .setPassword("test");
        assertEquals(ResponseStatus.ERROR, service.authenticateUser(requestDTO).getStatus());
    }

    @Test
    public void authenticateUser_whenCredentialsAreIncorrect_returnItemNotFoundAsMessage_test() {
        AuthenticateUserRequestDTO requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("test@test.com")
                .setPassword("test");
        String expectedOutput = CommonMessages.ITEM_NOT_FOUND;
        String actualOutput = service.authenticateUser(requestDTO).getMessage();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void authenticateUser_whenCredentialsAreIncorrect_returnIncorrectEmailOrPasswordAsReason_test() {
        AuthenticateUserRequestDTO requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("test@test.com")
                .setPassword("test");
        String expectedOutput = CommonReasons.INCORRECT_EMAIL_OR_PASSWORD;
        String actualOutput = service.authenticateUser(requestDTO).getReason();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void authenticateUser_whenPasswordIsIncorrect_returnIncorrectEmailOrPasswordAsReason_test() {
        // We need a user first:
        CreateUserService createUserService = new CreateUserService();
        CreateUserRequestDTO createUserRequestDTO = new CreateUserRequestDTO()
                .setFirstName("test")
                .setLastName("test")
                .setEmail("test@test.com")
                .setDob(LocalDate.now())
                .setPassword("test");

        createUserService.createUser(createUserRequestDTO);


        // Now let's create a request with correct email
        // but with incorrect password
        AuthenticateUserRequestDTO requestDTO = new AuthenticateUserRequestDTO()
                .setEmail("test@test.com")
                .setPassword("incorrect-password");
        String expectedOutput = CommonReasons.INCORRECT_EMAIL_OR_PASSWORD;
        String actualOutput = service.authenticateUser(requestDTO).getReason();
        assertEquals(expectedOutput, actualOutput);
    }
}
package com.enkale.usystem.service;

import com.enkale.usystem.domain.User;
import com.enkale.usystem.dto.CreateUserRequestDTO;
import com.enkale.usystem.dto.CreateUserResponseDTO;
import com.enkale.usystem.dto.ResponseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService service;
    private CreateUserRequestDTO oneEmptyFieldRequest;
    private CreateUserRequestDTO oneNullFieldRequest;
    private CreateUserRequestDTO someEmptyFieldRequest;
    private CreateUserRequestDTO someNullFieldRequest;
    private CreateUserRequestDTO allEmptyFieldRequest;
    private CreateUserRequestDTO allNullFieldRequest;
    private CreateUserRequestDTO allFieldsFilledRequest;

    @BeforeEach
    public void setupBeforeAll() {

        service = new UserService();

        // Please avoid making changes to the below request samples
        // as the test cases depends on it


        // One field empty only
        oneEmptyFieldRequest = new CreateUserRequestDTO();
        oneEmptyFieldRequest.setFirstName("");
        oneEmptyFieldRequest.setLastName("test");
        oneEmptyFieldRequest.setDob(LocalDate.now());
        oneEmptyFieldRequest.setEmail("test@test.com");
        oneEmptyFieldRequest.setPassword("test-test");

        // One field null only
        oneNullFieldRequest = new CreateUserRequestDTO();
        oneNullFieldRequest.setFirstName(null);
        oneNullFieldRequest.setLastName("test");
        oneNullFieldRequest.setDob(LocalDate.now());
        oneNullFieldRequest.setEmail("test@test.com");
        oneNullFieldRequest.setPassword("test-test");


        // Some fields empty only
        someEmptyFieldRequest = new CreateUserRequestDTO();
        someEmptyFieldRequest.setFirstName("");
        someEmptyFieldRequest.setLastName("");
        someEmptyFieldRequest.setDob(LocalDate.now());
        someEmptyFieldRequest.setEmail("");
        someEmptyFieldRequest.setPassword("test-test");

        // Some fields null only
        someNullFieldRequest = new CreateUserRequestDTO();
        someNullFieldRequest.setFirstName(null);
        someNullFieldRequest.setLastName(null);
        someNullFieldRequest.setDob(LocalDate.now());
        someNullFieldRequest.setEmail(null);
        someNullFieldRequest.setPassword("test-test");


        // All fields empty (except for DOB since its expecting an object)
        allEmptyFieldRequest = new CreateUserRequestDTO();
        allEmptyFieldRequest.setFirstName("");
        allEmptyFieldRequest.setLastName("");
        allEmptyFieldRequest.setDob(null);
        allEmptyFieldRequest.setEmail("");
        allEmptyFieldRequest.setPassword("");

        // All fields null
        allNullFieldRequest = new CreateUserRequestDTO();
        allNullFieldRequest.setFirstName(null);
        allNullFieldRequest.setLastName(null);
        allNullFieldRequest.setDob(null);
        allNullFieldRequest.setEmail(null);
        allNullFieldRequest.setPassword(null);

        // All fields are filled
        allFieldsFilledRequest = new CreateUserRequestDTO();
        allFieldsFilledRequest.setFirstName("test");
        allFieldsFilledRequest.setLastName("test");
        allFieldsFilledRequest.setDob(LocalDate.now());
        allFieldsFilledRequest.setEmail("test@test.com");
        allFieldsFilledRequest.setPassword("test");
    }

    @Test
    public void createUser_doesNotReturnNull_test() {
        assertNotNull(service.createUser(null));
    }

    @Test
    public void createUser_whenRequestIsNull_returnErrorAsStatus_test() {
        CreateUserResponseDTO responseDTO = service.createUser(null);
        assertEquals(ResponseStatus.ERROR, responseDTO.getStatus());
    }

    @Test
    public void createUser_whenRequestIsNull_returnUnableToCreateUserAsMessage_test() {
        CreateUserResponseDTO responseDTO = service.createUser(null);
        assertEquals("Unable to create user", responseDTO.getMessage());
    }

    @Test
    public void createUser_whenRequestIsNull_returnRequestIsNullAsReason_test() {
        CreateUserResponseDTO responseDTO = service.createUser(null);
        assertEquals("Request is null", responseDTO.getReason());
    }

    @Test
    public void createUser_whenRequestHasEmptyFields_returnErrorAsStatus_test() {
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        CreateUserResponseDTO responseDTO = service.createUser(requestDTO);
        assertEquals(ResponseStatus.ERROR, responseDTO.getStatus());
    }

    @Test
    public void createUser_whenRequestHasAllEmptyOrNullFields_returnAllMissingFieldsAsMessage_test() {
        CreateUserRequestDTO requestDTO = allEmptyFieldRequest;
        CreateUserResponseDTO responseDTO = service.createUser(requestDTO);
        StringBuilder expectedMessageBuilder = new StringBuilder();

        expectedMessageBuilder.append("Unable to process the fields: ");
        expectedMessageBuilder.append("firstName ");
        expectedMessageBuilder.append("lastName ");
        expectedMessageBuilder.append("dob ");
        expectedMessageBuilder.append("email ");
        expectedMessageBuilder.append("password ");
        assertEquals(expectedMessageBuilder.toString(), responseDTO.getMessage());

        requestDTO = allNullFieldRequest;
        responseDTO = service.createUser(requestDTO);
        assertEquals(expectedMessageBuilder.toString(), responseDTO.getMessage());
    }

    @Test
    public void createUser_whenRequestHasSomeEmptyOrNullFields_returnSomeMissingFieldAsMessage_test() {
        CreateUserRequestDTO requestDTO = someEmptyFieldRequest;
        CreateUserResponseDTO responseDTO = service.createUser(requestDTO);

        StringBuilder expectedMessageBuilder = new StringBuilder();

        expectedMessageBuilder.append("Unable to process the fields: ");
        expectedMessageBuilder.append("firstName ");
        expectedMessageBuilder.append("lastName ");
        expectedMessageBuilder.append("email ");

        assertEquals(expectedMessageBuilder.toString(), responseDTO.getMessage());

        requestDTO = someNullFieldRequest;
        responseDTO = service.createUser(requestDTO);
        assertEquals(expectedMessageBuilder.toString(), responseDTO.getMessage());
    }

    @Test
    public void createUser_whenRequestHasOneEmptyOrNullField_returnOneMissingFieldAsMessage_test() {
        CreateUserRequestDTO requestDTO = oneEmptyFieldRequest;
        CreateUserResponseDTO responseDTO = service.createUser(requestDTO);
        StringBuilder expectedMessageBuilder = new StringBuilder();

        expectedMessageBuilder.append("Unable to process the fields: ");
        expectedMessageBuilder.append("firstName ");
        assertEquals(expectedMessageBuilder.toString(), responseDTO.getMessage());

        requestDTO = oneNullFieldRequest;
        responseDTO = service.createUser(requestDTO);
        assertEquals(expectedMessageBuilder.toString(), responseDTO.getMessage());
    }

    @Test
    public void createUser_whenRequestHasEmptyOrNullFields_returnFieldsAreEitherEmptyOrNullAsReason_test() {
        CreateUserRequestDTO requestDTO = oneEmptyFieldRequest;
        CreateUserResponseDTO responseDTO = service.createUser(requestDTO);
        assertEquals("Field(s) are either empty or null", responseDTO.getReason());
    }

    @Test
    public void createUser_whenAllFieldsAreFilled_returnSuccessAsStatus_test() {
        CreateUserRequestDTO requestDTO = allFieldsFilledRequest;
        CreateUserResponseDTO responseDTO = service.createUser(requestDTO);
        assertEquals(ResponseStatus.SUCCESS, responseDTO.getStatus());
    }

    @Test
    public void createUser_noDuplicateUsers_test() {
        CreateUserRequestDTO requestDTO = allFieldsFilledRequest;
        User user1 = service.createUser(requestDTO).getUser();
        User user2 = service.createUser(requestDTO).getUser();
        assertNotEquals(user1.getId(), user2.getId());

    }

    @Test
    public void createUser_allUserDetailsAreFilled_test() {
        CreateUserRequestDTO requestDTO = allFieldsFilledRequest;
        User user = service.createUser(requestDTO).getUser();
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getEmail());
        assertNotNull(user.getPassword());
        assertNotNull(user.getSaltKey());
        assertNotNull(user.getLastUpdated());
        assertNotNull(user.getMemberSince());

    }

    @Test
    public void createUser_saltKeyMustbe10CharactersLong_test() {
        CreateUserRequestDTO requestDTO = allFieldsFilledRequest;
        User user = service.createUser(requestDTO).getUser();
        assertEquals(10, user.getSaltKey().length());
    }

    @Test
    public void createUser_passwordMustBeHashedand64CharactersLong_test() {
        CreateUserRequestDTO requestDTO = allFieldsFilledRequest;
        User user = service.createUser(requestDTO).getUser();
        assertEquals(64, user.getPassword().length());
    }
}
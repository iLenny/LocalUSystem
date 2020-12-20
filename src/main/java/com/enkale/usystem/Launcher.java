package com.enkale.usystem;

import com.enkale.usystem.dto.CreateUserRequestDTO;
import com.enkale.usystem.service.UserService;

import java.time.LocalDate;

public class Launcher {
    public static void main(String[] args) {
        UserService service = new UserService();
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO()
                .setFirstName("Leibniz")
                .setMiddleName("Husserl")
                .setLastName("Berihuete Nunez")
                .setDob(LocalDate.of(1991,5,23))
                .setEmail("Leibniz.Berihuete@gmail.com")
                .setPassword("nomelace");

        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
        System.out.println(service.createUser(requestDTO));
    }
}

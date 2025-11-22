package org.example.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String accountNumber;
    private int age;
    private String id;
    private String phoneNumber;

}

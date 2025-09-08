package org.example.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String email;
    private int accountNumber;

}

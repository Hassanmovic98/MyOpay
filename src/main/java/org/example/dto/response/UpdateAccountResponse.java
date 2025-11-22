package org.example.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String accountNumber;
}

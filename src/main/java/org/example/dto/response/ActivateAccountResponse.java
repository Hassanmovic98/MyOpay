package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivateAccountResponse {
    private String message;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String status;
}

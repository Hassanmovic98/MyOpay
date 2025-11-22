package org.example.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAccountRequest {

    private String accountId;
    private String firstName;
    private String lastName;
    private String emailAddress;

}


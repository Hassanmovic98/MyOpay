package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.example.data.model.Gender;

@Getter
@Setter
public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String emailAddress;
    private String phoneNumber;
    private int age;
}

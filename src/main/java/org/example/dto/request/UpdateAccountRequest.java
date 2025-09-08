package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountRequest {
    private String message;
    private String firstName;
    private String lastName;
}

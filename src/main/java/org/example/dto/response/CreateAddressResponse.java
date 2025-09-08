package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAddressResponse {
    private String id;
    private String message;
    private int houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
}

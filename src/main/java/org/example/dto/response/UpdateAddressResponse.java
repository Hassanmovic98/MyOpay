package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateAddressResponse {
    private String message;
    private String id;
    private int houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
}

package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAddressResponse {
    private String message;
    private int houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String id;



}

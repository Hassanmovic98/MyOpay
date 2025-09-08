package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateAddressRequest {
    private String Message;
    private String id;
    private int houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
}

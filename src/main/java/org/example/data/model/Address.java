package org.example.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Getter
@Setter
public class Address {
    @Id
    private String id;
    private int houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
}

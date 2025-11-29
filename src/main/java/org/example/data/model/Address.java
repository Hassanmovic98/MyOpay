package org.example.data.model;



import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@Document (collection = "Address")
public class Address {
    @Id
    private String id;

    private String accountId;
    
    private int houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
}

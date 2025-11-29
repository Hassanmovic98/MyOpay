package org.example.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document (collection ="account")
public class Account {
    @Id
    private String id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Gender gender;
    @DBRef
    private String addressId;
    private String emailAddress;
    private String phoneNumber;
    private int age;
}

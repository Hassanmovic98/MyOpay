package org.example.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document (collection ="account")
public class Account {
    @Id
    private String id;
    @Indexed(unique = true)
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Gender gender;

    private String addressId;
    @Indexed(unique = true)
    private String emailAddress;
    private String phoneNumber;
    private int age;
    private AccountStatus status =AccountStatus.ACTIVE;

    private String deactivationReason;
    private LocalDateTime deactivatedAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

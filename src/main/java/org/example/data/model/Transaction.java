package org.example.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.time.LocalDateTime;

@Setter
@Getter
public class Transaction {
    @Id
    private String id;
    private int transactionId;
    private Account account;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private double amount;
    @DBRef
    private String AccountId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

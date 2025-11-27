package org.example.dto.response;

import lombok.*;
import org.example.data.model.TransactionStatus;
import org.example.data.model.TransactionType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class CreateTransactionResponse {
    private String id;
    private int transactionId;
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private double amount;
    private String message;
}

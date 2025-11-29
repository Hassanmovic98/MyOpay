package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.model.TransactionType;
import org.example.data.model.TransactionStatus;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class GetTransactionResponse {
    private  String id;
    private int transactionId;
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private double amount;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;

}

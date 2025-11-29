package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.model.TransactionStatus;
import org.example.data.model.TransactionType;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private double amount;
}

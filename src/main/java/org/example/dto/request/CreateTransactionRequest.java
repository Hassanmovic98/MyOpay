package org.example.dto.request;

import org.example.data.model.TransactionType;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class CreateTransactionRequest {
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private double amount;
}

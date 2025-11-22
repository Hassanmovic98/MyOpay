package org.example.dto.request;

import org.example.data.model.TransactionStatus;
import org.example.data.model.TransactionType;

public class GetTransactionRequest {
    private String id;
    private Integer transactionId;
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
}

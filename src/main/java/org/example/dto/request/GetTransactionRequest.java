package org.example.dto.request;

import lombok.Data;
import org.example.data.model.TransactionStatus;
import org.example.data.model.TransactionType;

@Data
public class GetTransactionRequest {
    private String id;
    private Integer transactionId;
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
}

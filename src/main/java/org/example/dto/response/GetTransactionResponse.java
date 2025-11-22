package org.example.dto.response;

import org.example.data.model.TransactionType;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class GetTransactionResponse {
    private  String id;
    private int transactionId;
    private String accountId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private double amount;

}

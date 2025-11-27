package org.example.Mapper;


import org.example.data.model.Transaction;
import org.example.dto.response.CreateTransactionResponse;
import org.example.dto.response.GetTransactionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public GetTransactionResponse toGetTransactionResponse(Transaction transaction) {
        return GetTransactionResponse.builder()
                .id(transaction.getId())
                .transactionId(transaction.getTransactionId())
                .accountId(transaction.getAccountId())
                .transactionType(transaction.getTransactionType())
                .transactionStatus(transaction.getTransactionStatus())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();
    }

    public CreateTransactionResponse toCreateTransactionResponse(Transaction transaction, String message) {
        return CreateTransactionResponse.builder()
                .id(transaction.getId())
                .transactionId(transaction.getTransactionId())
                .accountId(transaction.getAccountId())
                .transactionType(transaction.getTransactionType())
                .transactionStatus(transaction.getTransactionStatus())
                .amount(transaction.getAmount())
                .message(message)
                .build();
    }
}

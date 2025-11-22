package org.example.data.repository;

import org.example.data.model.Transaction;
import org.example.data.model.TransactionStatus;
import org.example.data.model.TransactionType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByAccountId(String accountId);
    List<Transaction> findByAccountIdAndTransactionType(String accountId, TransactionType transactionType);
    List<Transaction> findByAccountIdAndTransactionStatus(String accountId, TransactionStatus transactionStatus);
    Optional<Transaction> findByTransactionId(int transactionId);
}

package org.example.TransactionRules;


import org.example.data.model.Account;
import org.example.data.model.Transaction;

public interface TransactionRule {
    ValidationResult validate(Transaction transaction, Account account);

    String getRuleName();
}
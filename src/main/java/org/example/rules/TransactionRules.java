package org.example.rules;

import org.example.Exceptions.DailyLimitExceededException;
import org.example.Exceptions.InsufficientBalanceException;
import org.example.Exceptions.InvalidTransactionException;
import org.example.data.model.Account;
import org.example.data.model.TransactionType;
import org.example.data.repository.AccountRepository;
import org.example.data.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TransactionRules {
    private static final BigDecimal Daily_Transaction_Limit = new BigDecimal("500,000");
    private static final BigDecimal Min_Transaction_Amount = new BigDecimal("10");
    private static final BigDecimal Max_Single_Transaction = new BigDecimal("100,000");
    private static final int Max_Daily_Transaction_Amount = 100;
    private static final int Min_Daily_Transaction_Amount = 0;


    public void validateTransactionAmount(BigDecimal amount) {
        if (amount.compareTo(Min_Transaction_Amount) > 0) {
            throw new InvalidTransactionException(
                    "Transaction amount must ba at least " + Min_Transaction_Amount);
        }
        if (amount.compareTo(Max_Single_Transaction) > 0) {
            throw new InvalidTransactionException("Transaction amount must ba at least " + Max_Single_Transaction);
        }
    }
    public void validateDaily_Transaction_Amount(String accountId, BigDecimal newAmount, TransactionRepository transactionRepository) {
        LocalDateTime BeginOfDay = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);

        // Get today's transactions
        BigDecimal dailyTotal = repository.getTotalAmountByAccountIdAndDate(
                accountId, startOfDay
        );

        if (dailyTotal.add(newAmount).compareTo(Daily_Transaction_Limit) > 0) {
            throw new DailyLimitExceededException(
                    "Daily transaction limit exceeded. Limit: " + Daily_Transaction_Limit
            );
        }

        // Check transaction count
        long todayCount = AccountRepository.countByAccountIdAndDate(accountId, startOfDay);
        if (todayCount >= Max_Daily_Transaction_Amount) {
            throw new DailyLimitExceededException(
                    "Maximum daily transactions (" + Max_Daily_Transaction_Amount + ") reached"
            );
        }
    }

    public void validateAccountStatus(Account account) {
        if (!account.isActive()) {
            throw new InvalidTransactionException("Account is not active");
        }

        if (account.isFrozen()) {
            throw new InvalidTransactionException("Account is frozen");
        }
    }

    public void validateSufficientBalance(Account account, BigDecimal amount,
                                          TransactionType type) {
        if (type == TransactionType.DEBIT || type == TransactionType.WITHDRAWAL) {
            if (account.getBalance().compareTo(amount) < 0) {
                throw new InsufficientBalanceException(
                        "Insufficient balance. Available: " + account.getBalance()
                );
            }
        }
    }
}



package org.example.service.serviceImplementation;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.model.Transaction;
import org.example.data.model.TransactionStatus;
import org.example.dto.request.CreateTransactionRequest;
import org.example.dto.request.GetTransactionRequest;
import org.example.dto.response.CreateTransactionResponse;
import org.example.dto.response.GetTransactionResponse;
import org.example.Exceptions.InvalidTransactionException;
import org.example.Exceptions.TransactionNotFoundException;
import org.example.Mapper.TransactionMapper;
import org.example.data.repository.TransactionRepository;
import org.example.service.serviceInterface.TransactionInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

    @Service
    @RequiredArgsConstructor
    @Slf4j
    public class TransactionImplementation implements TransactionInterface {

        private final TransactionRepository transactionRepository;
        private final TransactionMapper transactionMapper;

        @Override
        public CreateTransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest) {
            log.info("Creating transaction for account: {}", createTransactionRequest.getAccountId());

            // To Validate request
            validateCreateTransactionRequest(createTransactionRequest);

            // To Generate unique transaction ID
            Integer transactionId = generateUniqueTransactionId();

            // To Build transaction entity
            Transaction transaction = new Transaction();
            transaction.setTransactionId(transactionId);
            transaction.setAccountId(createTransactionRequest.getAccountId());
            transaction.setTransactionType(createTransactionRequest.getTransactionType());
            transaction.setTransactionStatus(TransactionStatus.PENDING); // Default status
            transaction.setAmount(createTransactionRequest.getAmount());
            transaction.setCreatedAt(LocalDateTime.now());
            transaction.setUpdatedAt(LocalDateTime.now());

            // to Save to database
            Transaction savedTransaction = transactionRepository.save(transaction);

            log.info("Transaction created successfully with ID: {}", savedTransaction.getId());

            // to  Map to response
            return transactionMapper.toCreateTransactionResponse(
                    savedTransaction,
                    "Transaction created successfully"
            );
        }

        @Override
        public GetTransactionResponse getTransactionById(GetTransactionRequest getTransactionRequest) {
            log.info("Fetching transaction by MongoDB ID: {}", getTransactionRequest.getId());

            if (getTransactionRequest.getId() == null || getTransactionRequest.getId().isEmpty()) {
                throw new InvalidTransactionException("Transaction ID cannot be null or empty");
            }

            Transaction transaction = transactionRepository.findById(getTransactionRequest.getId())
                    .orElseThrow(() -> new TransactionNotFoundException(
                            "Transaction not found with ID: " + getTransactionRequest.getId()
                    ));

            return transactionMapper.toGetTransactionResponse(transaction);
        }

        @Override
        public GetTransactionResponse getTransactionByTransactionId(GetTransactionRequest getTransactionRequest) {
            log.info("Fetching transaction by business transaction ID: {}", getTransactionRequest.getTransactionId());

            if (getTransactionRequest.getTransactionId() == null) {
                throw new InvalidTransactionException("Business transaction ID cannot be null");
            }

            Transaction transaction = transactionRepository.findByTransactionId(getTransactionRequest.getTransactionId())
                    .orElseThrow(() -> new TransactionNotFoundException(
                            "Transaction not found with transaction ID: " + getTransactionRequest.getTransactionId()
                    ));

            return transactionMapper.toGetTransactionResponse(transaction);
        }

        @Override
        public List<GetTransactionResponse> getTransactionsByAccountId(GetTransactionRequest getTransactionRequest) {
            log.info("Fetching all transactions for account ID: {}", getTransactionRequest.getAccountId());

            if (getTransactionRequest.getAccountId() == null || getTransactionRequest.getAccountId().isEmpty()) {
                throw new InvalidTransactionException("Account ID cannot be null or empty");
            }

            List<Transaction> transactions = transactionRepository.findByAccountId(getTransactionRequest.getAccountId());

            if (transactions.isEmpty()) {
                log.warn("No transactions found for account ID: {}", getTransactionRequest.getAccountId());
            }

            return transactions.stream()
                    .map(transactionMapper::toGetTransactionResponse)
                    .collect(Collectors.toList());
        }

        @Override
        public List<GetTransactionResponse> getTransactionsByTransactionIdAndType(GetTransactionRequest getTransactionRequest) {
            log.info("Fetching transactions by transaction ID: {} and type: {}",
                    getTransactionRequest.getTransactionId(),
                    getTransactionRequest.getTransactionType());

            if (getTransactionRequest.getTransactionId() == null) {
                throw new InvalidTransactionException("Transaction ID cannot be null");
            }

            if (getTransactionRequest.getTransactionType() == null) {
                throw new InvalidTransactionException("Transaction type cannot be null");
            }

            List<Transaction> transactions = transactionRepository.findByTransactionIdAndTransactionType(
                    getTransactionRequest.getTransactionId(),
                    getTransactionRequest.getTransactionType()
            );

            return transactions.stream()
                    .map(transactionMapper::toGetTransactionResponse)
                    .collect(Collectors.toList());
        }

        @Override
        public List<GetTransactionResponse> getTransactionsByAccountIdAndStatus(GetTransactionRequest getTransactionRequest) {
            log.info("Fetching transactions by account ID: {} and status: {}",
                    getTransactionRequest.getAccountId(),
                    getTransactionRequest.getTransactionStatus());

            if (getTransactionRequest.getAccountId() == null || getTransactionRequest.getAccountId().isEmpty()) {
                throw new InvalidTransactionException("Account ID cannot be null or empty");
            }

            if (getTransactionRequest.getTransactionStatus() == null) {
                throw new InvalidTransactionException("Transaction status cannot be null");
            }

            List<Transaction> transactions = transactionRepository.findByAccountIdAndTransactionStatus(
                    getTransactionRequest.getAccountId(),
                    getTransactionRequest.getTransactionStatus()
            );

            return transactions.stream()
                    .map(transactionMapper::toGetTransactionResponse)
                    .collect(Collectors.toList());
        }


        private void validateCreateTransactionRequest(CreateTransactionRequest request) {
            if (request.getAccountId() == null || request.getAccountId().isEmpty()) {
                throw new InvalidTransactionException("Account ID is required");
            }

            if (request.getTransactionType() == null) {
                throw new InvalidTransactionException("Transaction type is required");
            }

            if (request.getAmount() <= 0) {
                throw new InvalidTransactionException("Amount must be greater than zero");
            }

        }

        private Integer generateUniqueTransactionId() {
            Random random = new Random();
            Integer transactionId;
            int attempts = 0;
            int maxAttempts = 10;

            do {
                // To Generate a random 8-digits transaction ID
                transactionId = 10000000 + random.nextInt(90000000);
                attempts++;

                if (attempts >= maxAttempts) {
                    throw new RuntimeException("Unable to generate unique transaction ID after " + maxAttempts + " attempts");
                }
            } while (transactionRepository.existsByTransactionId(transactionId));

            return transactionId;
        }
    }
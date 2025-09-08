package org.example.service.serviceInterface;

import org.example.dto.CreateTransactionResponse;
import org.example.dto.request.CreateTransactionRequest;

public interface TransactionInterface {
CreateTransactionResponse createTransaction (CreateTransactionRequest createTransactionRequest );

}

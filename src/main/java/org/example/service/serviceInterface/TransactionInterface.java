package org.example.service.serviceInterface;


import org.example.dto.request.CreateTransactionRequest;
import org.example.dto.request.GetTransactionRequest;
import org.example.dto.response.CreateAddressResponse;
import org.example.dto.response.CreateTransactionResponse;
import org.example.dto.response.GetTransactionResponse;

import java.util.List;

public interface TransactionInterface {
    CreateTransactionResponse createTransaction (CreateTransactionRequest createTransactionRequest);
    GetTransactionResponse getTransactionById (GetTransactionRequest getTransactionRequest);
    GetTransactionResponse getTransactionByTransactionId (GetTransactionRequest getTransactionRequest);
    List<GetTransactionResponse> getTransactionsByAccountId (GetTransactionRequest getTransactionRequest);
    List<GetTransactionResponse> getTransactionsByTransactionIdAndType (GetTransactionRequest getTransactionRequest);
    List<GetTransactionResponse> getTransactionsByAccountIdAndStatus (GetTransactionRequest getTransactionRequest);

}

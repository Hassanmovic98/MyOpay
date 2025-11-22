package org.example.service.serviceImplementation;

import org.example.dto.request.CreateTransactionRequest;
import org.example.dto.request.GetTransactionRequest;
import org.example.dto.response.CreateAddressResponse;
import org.example.dto.response.GetTransactionResponse;
import org.example.service.serviceInterface.TransactionInterface;

import java.util.List;

public class TransactionImplementation implements TransactionInterface {


    @Override
    public CreateAddressResponse createTransaction(CreateTransactionRequest createTransactionRequest) {
        return null;
    }

    @Override
    public GetTransactionResponse getTransactionById(GetTransactionRequest getTransactionRequest) {
        return null;
    }

    @Override
    public GetTransactionResponse getTransactionByTransactionId(GetTransactionRequest getTransactionRequest) {
        return null;
    }

    @Override
    public List<GetTransactionResponse> getTransactionsByAccountId(GetTransactionRequest getTransactionRequest) {
        return List.of();
    }

    @Override
    public List<GetTransactionResponse> getTransactionsByTransactionIdAndType(GetTransactionRequest getTransactionRequest) {
        return List.of();
    }

    @Override
    public List<GetTransactionResponse> getTransactionsByAccountIdAndStatus(GetTransactionRequest getTransactionRequest) {
        return List.of();
    }
}

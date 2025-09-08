package org.example.service.serviceInterface;

import org.example.dto.request.CreateAccountRequest;
import org.example.dto.request.GetAccountRequest;
import org.example.dto.request.UpdateAccountRequest;
import org.example.dto.response.CreateAccountResponse;
import org.example.dto.response.GetAccountResponse;
import org.example.dto.response.UpdateAccountResponse;

import java.util.List;

public interface AccountInterface {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);
    UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest);
    GetAccountResponse getAccountByAccountId(GetAccountRequest getAccountRequest);
    GetAccountResponse getAccountByFirstName(GetAccountRequest getAccountRequest);
    GetAccountResponse getAccountByLastName(GetAccountRequest getAccountRequest);
    List<GetAccountResponse> getAccountsByFirstAndLastName(GetAccountRequest getAccountRequest);
    GetAccountResponse getAccountByEmailAddress(GetAccountRequest getAccountRequest);

}

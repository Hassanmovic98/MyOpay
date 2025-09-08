package org.example.service.serviceImplementation;

import lombok.AllArgsConstructor;
import org.example.data.model.Account;
import org.example.data.repository.AccountRepository;
import org.example.dto.request.CreateAccountRequest;
import org.example.dto.request.GetAccountRequest;
import org.example.dto.request.UpdateAccountRequest;
import org.example.dto.response.CreateAccountResponse;
import org.example.dto.response.GetAccountResponse;
import org.example.dto.response.UpdateAccountResponse;
import org.example.service.serviceInterface.AccountInterface;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public  class AccountImplementation implements AccountInterface {

    private final AccountRepository accountRepository;



    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        Account account = new Account();
        account.setFirstName(createAccountRequest.getFirstName());
        account.setLastName(createAccountRequest.getLastName());
        account.setEmailAddress(createAccountRequest.getEmailAddress());
        account.setPhoneNumber(String.valueOf(createAccountRequest.getPhoneNumber()));
        accountRepository.save(account);

        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setAccountNumber(account.getAccountNumber());
        createAccountResponse.setFirstName(account.getFirstName());
        createAccountResponse.setLastName(account.getLastName());
        createAccountResponse.setEmail(account.getEmailAddress());
        return createAccountResponse;


    }

    @Override
    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) {
        Account account = new Account();
        account.setFirstName(updateAccountRequest.getFirstName());
        account.setLastName(updateAccountRequest.getLastName());
        accountRepository.save(account);

        updateAccountRequest.setFirstName(account.getFirstName());
        updateAccountRequest.setLastName(account.getLastName());
        UpdateAccountResponse updateAccountResponse = new UpdateAccountResponse();
        updateAccountResponse.setAccountNumber(account.getAccountNumber());
        return updateAccountResponse;
    }

    @Override
    public GetAccountResponse getAccountByAccountId(GetAccountRequest getAccountRequest) {
        Account account = new Account();
        account.setA
        return null;
    }

    @Override
    public GetAccountResponse getAccountByFirstName(GetAccountRequest getAccountRequest) {
        return null;
    }

    @Override
    public GetAccountResponse getAccountByLastName(GetAccountRequest getAccountRequest) {
        return null;
    }

    @Override
    public List<GetAccountResponse> getAccountsByFirstAndLastName(GetAccountRequest getAccountRequest) {
        return List.of();
    }

    @Override
    public GetAccountResponse getAccountByEmailAddress(GetAccountRequest getAccountRequest) {
        return null;
    }


    }


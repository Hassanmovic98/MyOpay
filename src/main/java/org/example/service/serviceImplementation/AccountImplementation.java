package org.example.service.serviceImplementation;


import lombok.AllArgsConstructor;
import org.example.Mapper.AccountMapper;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountImplementation implements AccountInterface {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        if (accountRepository.findByEmailAddress(createAccountRequest.getEmailAddress()).isPresent()) {
            throw new RuntimeException("Account with this email already exists");
        }

        Account account = new Account();
        account.setFirstName(createAccountRequest.getFirstName());
        account.setLastName(createAccountRequest.getLastName());
        account.setEmailAddress(createAccountRequest.getEmailAddress());
        account.setAge(createAccountRequest.getAge());
        account.setPhoneNumber(createAccountRequest.getPhoneNumber());
        account.setAccountNumber(generateAccountNumber());

        Account savedAccount = accountRepository.save(account);

        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setId(savedAccount.getId());
        createAccountResponse.setAccountNumber(savedAccount.getAccountNumber());
        createAccountResponse.setFirstName(savedAccount.getFirstName());
        createAccountResponse.setLastName(savedAccount.getLastName());
        createAccountResponse.setEmailAddress(savedAccount.getEmailAddress());
        createAccountResponse.setAge(savedAccount.getAge());
        createAccountResponse.setPhoneNumber(savedAccount.getPhoneNumber());
        createAccountResponse.setMessage("Your Account is Created Successfully");

        return createAccountResponse;
    }

    @Override
    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) {
        Account account = accountRepository.findById(updateAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + updateAccountRequest.getAccountId()));

        if (updateAccountRequest.getFirstName() != null) {
            account.setFirstName(updateAccountRequest.getFirstName());
        }
        if (updateAccountRequest.getLastName() != null) {
            account.setLastName(updateAccountRequest.getLastName());
        }
        if (updateAccountRequest.getEmailAddress() != null) {
            account.setEmailAddress(updateAccountRequest.getEmailAddress());
        }
        if (updateAccountRequest.getPhoneNumber() != null) {
            account.setPhoneNumber(updateAccountRequest.getPhoneNumber());
        }

        Account updatedAccount = accountRepository.save(account);

        UpdateAccountResponse updateAccountResponse = new UpdateAccountResponse();
        updateAccountResponse.setFirstName(updatedAccount.getFirstName());
        updateAccountResponse.setLastName(updatedAccount.getLastName());
        updateAccountResponse.setEmailAddress(updatedAccount.getEmailAddress());
        updateAccountResponse.setMessage("Your Account is Updated Successfully");

        return updateAccountResponse;
    }

    @Override
    public GetAccountResponse getAccountByAccountId(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findById(getAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + getAccountRequest.getAccountId()));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public GetAccountResponse getAccountByFirstName(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findByFirstName(getAccountRequest.getFirstName())
                .orElseThrow(() -> new RuntimeException("Account not found with first name: " + getAccountRequest.getFirstName()));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public GetAccountResponse getAccountByLastName(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findByLastName(getAccountRequest.getLastName())
                .orElseThrow(() -> new RuntimeException("Account not found with last name: " + getAccountRequest.getLastName()));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public List<GetAccountResponse> getAccountsByFirstAndLastName(GetAccountRequest getAccountRequest) {
        List<Account> accounts = accountRepository.findByFirstNameAndLastName(
                getAccountRequest.getFirstName(),
                getAccountRequest.getLastName()
        );

        if (accounts.isEmpty()) {
            throw new RuntimeException("No accounts found with name: " +
                    getAccountRequest.getFirstName() + " " + getAccountRequest.getLastName());
        }

        return accounts.stream()
                .map(accountMapper::mapToGetAccountResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetAccountResponse getAccountByEmailAddress(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findByEmailAddress(getAccountRequest.getEmailAddress())
                .orElseThrow(() -> new RuntimeException("Account not found with email: " + getAccountRequest.getEmailAddress()));

        return accountMapper.mapToGetAccountResponse(account);
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }


}
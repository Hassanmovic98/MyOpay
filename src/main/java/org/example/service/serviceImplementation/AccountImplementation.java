package org.example.service.serviceImplementation;

import lombok.AllArgsConstructor;
import org.example.Mapper.AccountMapper;
import org.example.Constants.ResponseMessages;
import org.example.data.model.Account;
import org.example.data.model.AccountStatus;
import org.example.data.repository.AccountRepository;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.service.serviceInterface.AccountInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountImplementation implements AccountInterface {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        if (accountRepository.findByEmailAddress(createAccountRequest.getEmailAddress()).isPresent()) {
            throw new RuntimeException(ResponseMessages.Account.ALREADY_EXISTS);
        }

        Account account = new Account();
        account.setFirstName(createAccountRequest.getFirstName());
        account.setLastName(createAccountRequest.getLastName());
        account.setEmailAddress(createAccountRequest.getEmailAddress());
        account.setAge(createAccountRequest.getAge());
        account.setPhoneNumber(createAccountRequest.getPhoneNumber());
        account.setGender(createAccountRequest.getGender());
        account.setAccountNumber(generateAccountNumber());

        Account savedAccount = accountRepository.save(account);

        return accountMapper.mapToCreateAccountResponse(savedAccount);
    }

    @Override
    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest) {
        Account account = accountRepository.findById(updateAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

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

        return accountMapper.mapToUpdateAccountResponse(updatedAccount);
    }

    @Override
    public GetAccountResponse getAccountByAccountId(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findById(getAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public GetAccountResponse getAccountByFirstName(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findByFirstName(getAccountRequest.getFirstName())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public GetAccountResponse getAccountByLastName(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findByLastName(getAccountRequest.getLastName())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public List<GetAccountResponse> getAccountsByFirstAndLastName(GetAccountRequest getAccountRequest) {
        List<Account> accounts = accountRepository.findByFirstNameAndLastName(
                getAccountRequest.getFirstName(),
                getAccountRequest.getLastName()
        );

        if (accounts.isEmpty()) {
            throw new RuntimeException(ResponseMessages.Account.NOT_FOUND);
        }

        return accountMapper.mapToGetAccountResponseList(accounts);
    }

    @Override
    public GetAccountResponse getAccountByEmailAddress(GetAccountRequest getAccountRequest) {
        Account account = accountRepository.findByEmailAddress(getAccountRequest.getEmailAddress())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

        return accountMapper.mapToGetAccountResponse(account);
    }

    @Override
    public DeactivateAccountResponse deactivateAccount(DeactivateAccountRequest deactivateAccountRequest) {
        Account account = accountRepository.findById(deactivateAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

        if (account.getStatus() == AccountStatus.INACTIVE) {
            throw new RuntimeException("Account is already deactivated");
        }

        account.setStatus(AccountStatus.INACTIVE);
        account.setDeactivatedAt(LocalDateTime.now());
        account.setDeactivationReason(deactivateAccountRequest.getReason());

        Account deactivatedAccount = accountRepository.save(account);

        return accountMapper.mapToDeactivateAccountResponse(deactivatedAccount);
    }

    @Override
    public ActivateAccountResponse activateAccount(ActivateAccountRequest activateAccountRequest) {
        Account account = accountRepository.findById(activateAccountRequest.getAccountNumber())
                .orElseThrow(() -> new RuntimeException(ResponseMessages.Account.NOT_FOUND));

        if (account.getStatus() == AccountStatus.ACTIVE) {
            throw new RuntimeException("Account is already active");
        }

        account.setStatus(AccountStatus.ACTIVE);
        account.setDeactivatedAt(null);
        account.setDeactivationReason(null);

        Account activatedAccount = accountRepository.save(account);

        return accountMapper.mapToActivateAccountResponse(activatedAccount);
    }


    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

}
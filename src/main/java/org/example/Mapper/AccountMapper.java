package org.example.Mapper;

import lombok.RequiredArgsConstructor;
import org.example.Constants.ResponseMessages;
import org.example.data.model.Account;
import org.example.dto.response.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final ModelMapper modelMapper;

    public GetAccountResponse mapToGetAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        GetAccountResponse response = modelMapper.map(account, GetAccountResponse.class);
        response.setMessage(ResponseMessages.Account.RETRIEVED);
        return response;
    }

    public List<GetAccountResponse> mapToGetAccountResponseList(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return List.of();
        }
        return accounts.stream()
                .map(this::mapToGetAccountResponse)
                .collect(Collectors.toList());
    }

    public CreateAccountResponse mapToCreateAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        CreateAccountResponse response = modelMapper.map(account, CreateAccountResponse.class);
        response.setMessage(ResponseMessages.Account.CREATED);
        return response;
    }

    public UpdateAccountResponse mapToUpdateAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        UpdateAccountResponse response = modelMapper.map(account, UpdateAccountResponse.class);
        response.setMessage(ResponseMessages.Account.UPDATED);
        return response;
    }


    public DeactivateAccountResponse mapToDeactivateAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        DeactivateAccountResponse response = modelMapper.map(account, DeactivateAccountResponse.class);
        response.setStatus(account.getStatus().toString());
        response.setMessage(ResponseMessages.Account.DEACTIVATED);
        return response;
    }

    public ActivateAccountResponse mapToActivateAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        ActivateAccountResponse response = modelMapper.map(account, ActivateAccountResponse.class);
        response.setStatus(account.getStatus().toString());
        response.setMessage(ResponseMessages.Account.ACTIVATED);
        return response;
    }
}
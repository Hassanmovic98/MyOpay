package org.example.Mapper;





import lombok.RequiredArgsConstructor;
import org.example.Constants.ResponseMessages;
import org.example.data.model.Account;
import org.example.dto.response.CreateAccountResponse;
import org.example.dto.response.GetAccountResponse;
import org.example.dto.response.UpdateAccountResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final ModelMapper modelMapper;

    public GetAccountResponse toGetAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        GetAccountResponse response = modelMapper.map(account, GetAccountResponse.class);
        response.setMessage(ResponseMessages.Account.RETRIEVED);
        return response;
    }

    public List<GetAccountResponse> toGetAccountResponseList(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return List.of();
        }
        return accounts.stream()
                .map(this::toGetAccountResponse)
                .collect(Collectors.toList());
    }

    public CreateAccountResponse toCreateAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        CreateAccountResponse response = modelMapper.map(account, CreateAccountResponse.class);
        response.setMessage(ResponseMessages.Account.CREATED);
        return response;
    }

    public UpdateAccountResponse toUpdateAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        UpdateAccountResponse response = modelMapper.map(account, UpdateAccountResponse.class);
        response.setMessage(ResponseMessages.Account.UPDATED);
        return response;
    }

    public UpdateAccountResponse toUpdateAccountResponse(Account account, String customMessage) {
        if (account == null) {
            return null;
        }
        UpdateAccountResponse response = modelMapper.map(account, UpdateAccountResponse.class);
        response.setMessage(customMessage);
        return response;
    }
}



package org.example.Mapper;

import org.example.data.model.Account;
import org.example.dto.response.GetAccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public GetAccountResponse mapToGetAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        GetAccountResponse response = new GetAccountResponse();
        response.setAccountNumber(account.getAccountNumber());
        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setEmailAddress(account.getEmailAddress());

        return response;


    }
}

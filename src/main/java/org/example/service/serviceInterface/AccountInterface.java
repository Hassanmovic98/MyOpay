package org.example.service.serviceInterface;

import org.example.dto.request.*;
import org.example.dto.response.*;

import java.util.List;

public interface AccountInterface {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);
    UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest);
    GetAccountResponse getAccountByAccountId(GetAccountRequest getAccountRequest);
    GetAccountResponse getAccountByFirstName(GetAccountRequest getAccountRequest);
    GetAccountResponse getAccountByLastName(GetAccountRequest getAccountRequest);
    List<GetAccountResponse> getAccountsByFirstAndLastName(GetAccountRequest getAccountRequest);
    GetAccountResponse getAccountByEmailAddress(GetAccountRequest getAccountRequest);
    DeactivateAccountResponse deactivateAccount(DeactivateAccountRequest deactivateAccountRequest);


    ActivateAccountResponse activateAccount(ActivateAccountRequest activateAccountRequest);

}

package org.example.Controller;

import lombok.AllArgsConstructor;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.service.serviceImplementation.AccountImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/MyOpay")
@AllArgsConstructor

public class AccountController {

    private AccountImplementation accountImplementation;


    @PostMapping("/createAza")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        CreateAccountResponse createAccountResponse =  accountImplementation.createAccount(createAccountRequest);
        return ResponseEntity.ok(createAccountResponse);
    }
    @PostMapping("/updateAccount")
    public ResponseEntity<UpdateAccountResponse> updateAccount(@RequestBody UpdateAccountRequest updateAccountRequest){
        UpdateAccountResponse updateAccountResponse =  accountImplementation.updateAccount(updateAccountRequest);
        return ResponseEntity.ok(updateAccountResponse);
    }

    @GetMapping("/getAccountById")
    public ResponseEntity<GetAccountResponse> getAccountById(@RequestParam String accountId){
        GetAccountRequest getAccountRequest = new GetAccountRequest();
        getAccountRequest.setAccountId(accountId);
        GetAccountResponse getAccountResponse = accountImplementation.getAccountByAccountId(getAccountRequest);
        return ResponseEntity.ok(getAccountResponse);
    }
    @GetMapping("/getAccountByFirstName")
    public ResponseEntity<GetAccountResponse> getAccountFirstName(@RequestParam ("firstName")String firstName){
        GetAccountRequest getAccountRequest = new GetAccountRequest();
        getAccountRequest.setFirstName(firstName);
        GetAccountResponse getAccountResponse = accountImplementation.getAccountByFirstName(getAccountRequest);
        return ResponseEntity.ok(getAccountResponse);
    }

    @GetMapping("/getAccountByLastName")
    public ResponseEntity<GetAccountResponse> getAccountByLastName(@RequestParam ("lastName")String lastName){
        GetAccountRequest getAccountRequest = new GetAccountRequest();
        getAccountRequest.setLastName(lastName);
        GetAccountResponse getAccountResponse = accountImplementation.getAccountByLastName(getAccountRequest);
        return ResponseEntity.ok(getAccountResponse);


    }
    @GetMapping("/getAccountByFirstNameAndLastName")
    public ResponseEntity<List<GetAccountResponse>> getAccountByFirstNameAndLastName(
            @RequestParam ("firstName")String firstName,
            @RequestParam ("lastName") String lastName){

        GetAccountRequest getAccountRequest = new GetAccountRequest();
        getAccountRequest.setFirstName(firstName);
        getAccountRequest.setLastName(lastName);
        List<GetAccountResponse> getAccountResponse = accountImplementation.getAccountsByFirstAndLastName(getAccountRequest);
        return ResponseEntity.ok(getAccountResponse);

    }
    @GetMapping
    public ResponseEntity<GetAccountResponse> getAccountByEmailAddress (@RequestParam("email") String email){
        GetAccountRequest getAccountRequest = new GetAccountRequest();
        getAccountRequest.setEmailAddress(email);
        GetAccountResponse getAccountResponse = accountImplementation.getAccountByEmailAddress(getAccountRequest);
        return ResponseEntity.ok(getAccountResponse);
    }
    @PostMapping
    public ResponseEntity<DeactivateAccountResponse> deactivateAccount(@RequestBody DeactivateAccountRequest deactivateAccountRequest){
        DeactivateAccountResponse deactivateAccountResponse =  accountImplementation.deactivateAccount(deactivateAccountRequest);
        return ResponseEntity.ok(deactivateAccountResponse);
    }
    @PostMapping
    public ResponseEntity<ActivateAccountResponse> activateAccount(@RequestBody ActivateAccountRequest activateAccountRequest){
        ActivateAccountResponse activateAccountResponse =  accountImplementation.activateAccount(activateAccountRequest);
        return ResponseEntity.ok(activateAccountResponse);
    }

}

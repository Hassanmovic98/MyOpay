package org.example.Controller;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.request.CreateTransactionRequest;
import org.example.dto.request.GetTransactionRequest;
import org.example.dto.response.CreateTransactionResponse;
import org.example.dto.response.GetTransactionResponse;
import org.example.service.serviceInterface.TransactionInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionInterface transactionService;

    @PostMapping("/createTransaction")
    public ResponseEntity<CreateTransactionResponse> createTransaction(
            @RequestBody CreateTransactionRequest request) {
        log.info("POST /api/create Transaction - Creating new transaction");
        CreateTransactionResponse response = transactionService.createTransaction(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getTransactionById{id}")
    public ResponseEntity<GetTransactionResponse> getTransactionById(@PathVariable String id) {
        log.info("GET /api/get Transaction /{} - Fetching transaction by ID", id);
        GetTransactionRequest request = new GetTransactionRequest();
        request.setId(id);
        GetTransactionResponse response = transactionService.getTransactionById(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTransactionByTransaction-id/{transactionId}")
    public ResponseEntity<GetTransactionResponse> getTransactionByTransactionId(
            @PathVariable Integer transactionId) {
        log.info("GET /api/getTransactionByTransactionId/{} - Fetching by business transaction ID", transactionId);
        GetTransactionRequest request = new GetTransactionRequest();
        request.setTransactionId(transactionId);
        GetTransactionResponse response = transactionService.getTransactionByTransactionId(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTransactionByAccountId/{accountId}")
    public ResponseEntity<List<GetTransactionResponse>> getTransactionsByAccountId(
            @PathVariable String accountId) {
        log.info("GET /api/v1/transactions/account/{} - Fetching all transactions for account", accountId);
        GetTransactionRequest request = new GetTransactionRequest();
        request.setAccountId(accountId);
        List<GetTransactionResponse> response = transactionService.getTransactionsByAccountId(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search Transactions")
    public ResponseEntity<List<GetTransactionResponse>> searchTransactions(
            @RequestParam(required = false) Integer transactionId,
            @RequestParam(required = false) String transactionType,
            @RequestParam(required = false) String accountId,
            @RequestParam(required = false) String status) {

        GetTransactionRequest request = new GetTransactionRequest();


        if (transactionId != null && transactionType != null) {
            log.info("GET /api/transactions/search - Searching by transaction ID and type");
            request.setTransactionId(transactionId);
            request.setTransactionType(org.example.data.model.TransactionType.valueOf(transactionType));
            List<GetTransactionResponse> response = transactionService.getTransactionsByTransactionIdAndType(request);
            return ResponseEntity.ok(response);
        }


        if (accountId != null && status != null) {
            log.info("GET /api/transactions/search - Searching by account ID and status");
            request.setAccountId(accountId);
            request.setTransactionStatus(org.example.data.model.TransactionStatus.valueOf(status));
            List<GetTransactionResponse> response = transactionService.getTransactionsByAccountIdAndStatus(request);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest().build();
    }
}
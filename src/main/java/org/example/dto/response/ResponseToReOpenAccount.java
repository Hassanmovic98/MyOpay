package org.example.dto.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ResponseToReOpenAccount {
    private String requestId;
    private String accountNumber;
    private String status;
    private String message;
    private String requestedAt;
    private String reviewDeadline;
}

package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RejectReOpenResponse {
    private String requestId;
    private String accountNumber;
    private String status;
    private String message;
    private String rejectedBy;
    private String rejectedAt;
    private String reason;
}

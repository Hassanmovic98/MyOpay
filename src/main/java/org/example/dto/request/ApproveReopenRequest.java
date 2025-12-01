package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApproveReopenRequest {

    private String requestId;
    private String accountNumber;
    private String status;
    private String message;
    private String approvedBy;
    private String approvedAt;
}

package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApproveReOpenResponse {
    private String requestId;
    private String accountNumber;
    private String status;
    private String message;
    private String approvedBy;
    private String approvedAt;

}

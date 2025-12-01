package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectReOpenRequest {
    private String requestId;
    private String adminId;
    private String rejectionReason;

}

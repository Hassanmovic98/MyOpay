package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CloseAccountRequest {
    private String accountNumber;
    private String accountType;
    private String reason;
}

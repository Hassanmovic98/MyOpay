package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeactivateAccountRequest {
    private String accountId;
    private String reason;
}

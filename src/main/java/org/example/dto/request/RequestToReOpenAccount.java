package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestToReOpenAccount {
    private String accountNumber;
    private String reason;
}

package org.example.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReOpenRequest {
    @Id
    private String id;
    private String accountNumber;
    private String reason;
    private ReOpenRequestStatus status;


    private LocalDateTime requestedAt;
    private LocalDateTime reviewDeadline;
    private LocalDateTime reviewedAt;

    private String reviewedBy;
    private String reviewNotes;
}

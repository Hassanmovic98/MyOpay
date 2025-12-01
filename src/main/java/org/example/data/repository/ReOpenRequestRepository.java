package org.example.data.repository;

import org.example.data.model.ReOpenRequest;
import org.example.data.model.ReOpenRequestStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReOpenRequestRepository {

    List<ReOpenRequest> findByStatus(ReOpenRequestStatus status);

    List<ReOpenRequest> findByAccountNumberAndStatus(String accountNumber, ReOpenRequestStatus status);

    List<ReOpenRequest> findByAccountNumberOrderByRequestedAtDesc(String accountNumber);
}

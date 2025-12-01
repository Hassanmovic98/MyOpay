package org.example.data.repository;

import org.example.data.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByEmailAddress(String emailAddress);

    Optional<Account> findByFirstName(String firstName);

    Optional<Account> findByLastName(String lastName);

    List<Account> findByFirstNameAndLastName(String firstName, String lastName);

    Optional <Account> findByAccountNumber(String accountNumber);


}

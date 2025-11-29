package org.example.data.repository;



import org.example.data.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;


public interface AddressRepository extends MongoRepository<Address, String> {


    Optional<Address> findByAccountId(String accountId);

    List<Address> findByCity(String city);


    List<Address> findByState(String state);


    List<Address> findByCountry(String country);


    List<Address> findByCityAndState(String city, String state);


    List<Address> findByStreet(String street);


    boolean existsByAccountId(String accountId);
}
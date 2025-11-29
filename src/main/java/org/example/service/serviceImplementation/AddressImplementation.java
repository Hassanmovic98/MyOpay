package org.example.service.serviceImplementation;

import lombok.AllArgsConstructor;
import org.example.data.model.Address;
import org.example.data.repository.AddressRepository;
import org.example.dto.request.CreateAddressRequest;
import org.example.dto.request.GetAddressRequest;
import org.example.dto.request.UpdateAddressRequest;
import org.example.dto.response.CreateAddressResponse;
import org.example.dto.response.GetAddressResponse;
import org.example.dto.response.UpdateAddressResponse;
import org.example.service.serviceInterface.AddressInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;




@Service
@AllArgsConstructor
public class AddressImplementation implements AddressInterface {


    private final AddressRepository addressRepository;


    @Override
    public CreateAddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setState(createAddressRequest.getState());
        address.setCountry(createAddressRequest.getCountry());
        address.setStreet(createAddressRequest.getStreet());
        address.setHouseNo(createAddressRequest.getHouseNo());
        addressRepository.save(address);

        CreateAddressResponse createAddressResponse = new CreateAddressResponse();
        createAddressResponse.setId(address.getId());
        createAddressResponse.setCity(createAddressRequest.getCity());
        createAddressResponse.setState(createAddressRequest.getState());
        createAddressResponse.setCountry(createAddressRequest.getCountry());
        createAddressResponse.setStreet(createAddressRequest.getStreet());
        createAddressResponse.setHouseNo(createAddressRequest.getHouseNo());
        return createAddressResponse;

    }

    @Override
    public UpdateAddressResponse updateAddress(UpdateAddressRequest updateAddressRequest) {
        Address address = findAddressById(updateAddressRequest.getId());
        address.setCity(updateAddressRequest.getCity());
        address.setState(updateAddressRequest.getState());
        address.setCountry(updateAddressRequest.getCountry());
        address.setStreet(updateAddressRequest.getStreet());
        address.setHouseNo(updateAddressRequest.getHouseNo());
        addressRepository.save(address);
        UpdateAddressResponse updateAddressResponse = new UpdateAddressResponse();
        updateAddressResponse.setId(address.getId());
        updateAddressResponse.setCity(updateAddressRequest.getCity());
        updateAddressResponse.setState(updateAddressRequest.getState());
        updateAddressResponse.setCountry(updateAddressRequest.getCountry());
        updateAddressResponse.setStreet(updateAddressRequest.getStreet());
        updateAddressResponse.setHouseNo(updateAddressRequest.getHouseNo());
        return updateAddressResponse;
    }

    private Address findAddressById(String id) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if (foundAddress.isPresent()) {
            return foundAddress.get();
        }
        return null;
    }

    @Override
    public GetAddressResponse getAddressByAddressId(GetAddressRequest getAddressRequest) {
        Address address = findAddressById(getAddressRequest.getId());
        if (address != null) {
            return getGetAddressResponse(address);
        }
        return null;
    }

    @Override
    public GetAddressResponse getAddressByAccountId(GetAddressRequest getAddressRequest) {
        Optional<Address> foundAddress = addressRepository.findByAccountId(getAddressRequest.getAccountId());
        if (foundAddress.isPresent()) {
            return getGetAddressResponse(foundAddress.get());
        }
        return null;

    }

    private GetAddressResponse getGetAddressResponse(Address address) {
        GetAddressResponse getAddressResponse = new GetAddressResponse();
        getAddressResponse.setId(address.getId());
        getAddressResponse.setCity(address.getCity());
        getAddressResponse.setState(address.getState());
        getAddressResponse.setCountry(address.getCountry());
        getAddressResponse.setStreet(address.getStreet());
        getAddressResponse.setHouseNo(address.getHouseNo());
        return getAddressResponse;
    }
}



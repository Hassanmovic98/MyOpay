package org.example.Mapper;

import org.example.data.model.Address;
import org.example.dto.response.CreateAddressResponse;
import org.example.dto.response.GetAddressResponse;
import org.example.dto.response.UpdateAddressResponse;
import org.springframework.stereotype.Component;


@Component
public class AddressMapper {
    public GetAddressResponse mapToGetAddressResponse(Address address) {
        if (address == null) {
            return null;
        }

        GetAddressResponse response = new GetAddressResponse();
        response.setId(address.getId());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setStreet(address.getStreet());
        response.setHouseNo(address.getHouseNo());

        return response;
    }
    public CreateAddressResponse mapToCreateAddressResponse(Address address) {
        if (address == null) {
            return null;
        }

        CreateAddressResponse response = new CreateAddressResponse();
        response.setId(address.getId());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setStreet(address.getStreet());
        response.setHouseNo(address.getHouseNo());
        response.setMessage("Address created successfully");
        return response;
    }

    public UpdateAddressResponse mapToUpdateAddressResponse(Address address) {
        if (address == null) {
            return null;
        }

        UpdateAddressResponse response = new UpdateAddressResponse();
        response.setId(address.getId());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setStreet(address.getStreet());
        response.setHouseNo(address.getHouseNo());
        response.setMessage("Address updated successfully");

        return response;
    }
}

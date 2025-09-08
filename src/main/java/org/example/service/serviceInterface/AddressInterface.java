package org.example.service.serviceInterface;

import org.example.dto.request.GetAddressRequest;
import org.example.dto.request.CreateAddressRequest;
import org.example.dto.request.UpdateAddressRequest;
import org.example.dto.response.CreateAddressResponse;
import org.example.dto.response.GetAddressResponse;
import org.example.dto.response.UpdateAddressResponse;


public interface AddressInterface {
    CreateAddressResponse createAddress(CreateAddressRequest createAddressRequest);
    UpdateAddressResponse updateAddress(UpdateAddressRequest updateAddressRequest);
    GetAddressResponse getAddressByAddressId(GetAddressRequest getAddressRequest);
    GetAddressResponse getAddressByAccountId(GetAddressRequest getAddressRequest);
}

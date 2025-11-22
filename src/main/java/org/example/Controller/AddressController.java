package org.example.Controller;



import lombok.AllArgsConstructor;
import org.example.dto.request.*;
import org.example.dto.response.CreateAddressResponse;
import org.example.dto.response.GetAddressResponse;
import org.example.dto.response.UpdateAddressResponse;
import org.example.service.serviceImplementation.AddressImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class AddressController {
    private final AddressImplementation addressImplementation;

    @PostMapping("/createAddress")
    public ResponseEntity<CreateAddressResponse> createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        CreateAddressResponse response = addressImplementation.createAddress(createAddressRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<UpdateAddressResponse> updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest) {
        UpdateAddressResponse response = addressImplementation.updateAddress(updateAddressRequest);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getAddressById")
    public ResponseEntity<GetAddressResponse> getAddressByAddressId(@RequestParam ("Id")String id) {
        GetAddressRequest request = new GetAddressRequest();
        request.setId(id);
        GetAddressResponse response = addressImplementation.getAddressByAddressId(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/getAddressByAccountId")
    public ResponseEntity<GetAddressResponse> getAddressByAccountId(@RequestParam ("AccountId")String accountId) {
        GetAddressRequest request = new GetAddressRequest();
        request.setAccountId(accountId);
        GetAddressResponse response = addressImplementation.getAddressByAccountId(request);
        return ResponseEntity.ok(response);
    }


}

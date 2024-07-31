package org.example.buysourcecode.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.dto.address.AddressOfUserRequest;
import org.example.buysourcecode.dto.address.AddressResponse;
import org.example.buysourcecode.exception.NotFoundException;
import org.example.buysourcecode.map.AddressMapper;
import org.example.buysourcecode.model.Address;
import org.example.buysourcecode.model.User;
import org.example.buysourcecode.service.AddressService;
import org.example.buysourcecode.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final UserService userService;
    private final AddressMapper addressMapper;

//    @PostMapping("/list")
//    public ResponseEntity<List<AddressResponse>> getListByUser(@RequestBody @Valid AddressOfUserRequest request) {
//
//        User user = userService.findUserById(request.getUserId());
//        if(user == null) {throw new NotFoundException(String.format("User with id %s not found", request.getUserId()));}
//
//        List<AddressResponse> addressResponses = new ArrayList<>();
//
//        List<Address> addresses = addressService.findAddressAllByUser(user);
//
//        addresses.forEach(item->{
//            addressResponses.add(addressMapper.toAddressResponse(item));
//        });
//
//        return ResponseEntity.ok(addressResponses);
//    }

//    @PostMapping("/create")
//    public ResponseEntity<Address> createAddress(@RequestBody @Valid AddressOfUserRequest request) {
//
//    }

}

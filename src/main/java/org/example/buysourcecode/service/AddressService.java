package org.example.buysourcecode.service;

import org.example.buysourcecode.model.Address;
import org.example.buysourcecode.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<Address> findAddressAllByUser(User user);
    Address findAddressById(Long id);
    Address createAddress(Address address);
    Address updateAddress(Address address);
    Address deleteAddress(Address address);

}

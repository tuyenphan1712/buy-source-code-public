package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.Address;
import org.example.buysourcecode.model.Status;
import org.example.buysourcecode.model.User;
import org.example.buysourcecode.repository.AddressRepository;
import org.example.buysourcecode.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAddressAllByUser(User user) {
        return addressRepository.findAddressAllByUser(user);
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findAddressById(id);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address deleteAddress(Address address) {
        address.setStatus(Status.DELETED);
        return addressRepository.save(address);
    }
}

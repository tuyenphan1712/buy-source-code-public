package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.Address;
import org.example.buysourcecode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select ad from Address ad where ad.status != 'DELETED' and ad.user = :user")
    List<Address> findAddressAllByUser(@Param("user") User user);

    @Query(value = "select ad from Address ad where ad.id = :id and ad.status != 'DELETED'")
    Address findAddressById(@Param("id") Long id);

}

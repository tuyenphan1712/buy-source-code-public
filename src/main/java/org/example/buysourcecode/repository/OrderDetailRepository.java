package org.example.buysourcecode.repository;

import jdk.jfr.Registered;
import org.example.buysourcecode.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}

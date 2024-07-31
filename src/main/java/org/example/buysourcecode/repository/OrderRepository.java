package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(value = "select max(o.id) from Order o")
    String getMaxId();

    @Query(value = "select o from Order o")
    List<Order> getAllOrders();

    @Query(value = "select o from Order o where o.id = :id")
    Order getOrderById(@Param("id") String id);

    @Query(value = "select o from Order o where o.customer = :id")
    Order getOrderByCustomerId(@Param("id") String id);

}

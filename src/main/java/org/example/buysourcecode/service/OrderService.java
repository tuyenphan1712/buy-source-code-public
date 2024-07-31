package org.example.buysourcecode.service;

import org.example.buysourcecode.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    String getMaxId();
    List<Order> getAllOrders();
    Order getOrderById(String id);
    Order getOrderByUserId(String userId);
    String generateOrderId(String id);
    Order createOrder(Order order);
    Order updateOrder(Order order);
}

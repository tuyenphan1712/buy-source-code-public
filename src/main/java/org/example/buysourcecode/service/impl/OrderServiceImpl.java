package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.Order;
import org.example.buysourcecode.repository.OrderRepository;
import org.example.buysourcecode.service.OrderService;
import org.example.buysourcecode.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService  {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String getMaxId() {
        String id = orderRepository.getMaxId();
        if (id == null) {
            return "ORDER" + DateTimeUtil.toDateString(LocalDate.now()) + "0000";
        }
        return id;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public Order getOrderByUserId(String userId) {
        return orderRepository.getOrderByCustomerId(userId);
    }

    @Override
    public String generateOrderId(String id) {
        String prefix = id.substring(0, 11);  // id: ORDER2406220001 type: ORDERyyMMdd000x
        String numberString = id.substring(11);

        int number = Integer.parseInt(numberString)+1;
        String newNumberStr = String.format("%04d", number);
        return prefix + newNumberStr;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

}

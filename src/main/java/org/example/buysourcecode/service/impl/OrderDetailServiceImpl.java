package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.OrderDetail;
import org.example.buysourcecode.repository.OrderDetailRepository;
import org.example.buysourcecode.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository repo;

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return repo.save(orderDetail);
    }
}

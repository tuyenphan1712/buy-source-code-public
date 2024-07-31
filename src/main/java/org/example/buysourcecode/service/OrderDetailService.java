package org.example.buysourcecode.service;

import org.example.buysourcecode.model.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);
}

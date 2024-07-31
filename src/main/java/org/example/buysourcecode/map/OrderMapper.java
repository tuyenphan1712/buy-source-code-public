package org.example.buysourcecode.map;

import org.example.buysourcecode.dto.order.OrderResponse;
import org.example.buysourcecode.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderResponse toResponse(Order order);

//    Order toOrder(OrderRequest request);

}

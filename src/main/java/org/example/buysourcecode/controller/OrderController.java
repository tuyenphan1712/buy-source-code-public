package org.example.buysourcecode.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.dto.order.CreateOrderRequest;
import org.example.buysourcecode.dto.order.OrderResponse;
import org.example.buysourcecode.exception.NotFoundException;
import org.example.buysourcecode.map.OrderMapper;
import org.example.buysourcecode.model.Order;
import org.example.buysourcecode.model.OrderDetail;
import org.example.buysourcecode.model.Product;
import org.example.buysourcecode.model.User;
import org.example.buysourcecode.service.OrderDetailService;
import org.example.buysourcecode.service.OrderService;
import org.example.buysourcecode.service.ProductService;
import org.example.buysourcecode.service.UserService;
import org.example.buysourcecode.util.jsoncocnverter.JsonConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserService userService;
    private final ProductService productService;
    private final JsonConverter jsonConverter;
    private final OrderDetailService orderDetailService;

    @GetMapping("/list")
    public ResponseEntity<List<Order>> allOrder() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable(value = "id") String id) {
        Order order = orderService.getOrderById(id);
        if(order == null) {
            throw new NotFoundException(String.format("Order with id: %s not found", id));
        }
        return ResponseEntity.ok(orderMapper.toResponse(order));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest request) {

        User user = userService.findUserById(request.getUserId());
        if(user == null) { throw new NotFoundException(String.format("User with id: %s not found", request.getUserId())); }

        Order order = Order.builder()
                .id(orderService.generateOrderId(orderService.getMaxId()))
                .customer(user)
                .build();

        List<OrderDetail> orderDetails = new ArrayList<>();

        request.getOrderDetails().forEach(item-> {
            Product product = productService.getProductById(item.getProductId());
            if (product == null) {throw new NotFoundException(String.format("Product with id: %s not found", item.getProductId())); }
            OrderDetail orderDetail = OrderDetail.builder()
                    .order(order)
                    .product(product)
                    .productJson(jsonConverter.toJson(product))
                    .build();
            orderDetails.add(orderDetail);
        });

        order.setOrderDetails(orderDetails);

        orderService.createOrder(order);

        return ResponseEntity.ok(orderMapper.toResponse(order));

    }

}

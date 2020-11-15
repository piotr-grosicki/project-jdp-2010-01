package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/orders")
public class OrderController {
    @Autowired
    private OrderDbService orderDbService;
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders () {

        return orderMapper.mapToOrderDtoList(orderDbService.getAllOrders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {

        orderDbService.saveOrder(orderMapper.mapToOrder(orderDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {

        return orderMapper.mapToOrderDto(orderDbService.getOrderById(orderId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {

        return orderMapper.mapToOrderDto(orderDbService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        orderDbService.deleteOrder(orderId);
    }
}

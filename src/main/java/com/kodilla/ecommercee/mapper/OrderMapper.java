package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserMapper userMapper;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getOrderDate(),
                userMapper.mapUserDtoToUser(orderDto.getUserDto()),
                productMapper.mapToProductList(orderDto.getProductDtoList()));
    }
    public OrderDto mapToOrderDto(final Order order){
        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                userMapper.mapUserToUserDto(order.getUser()),
                productMapper.mapToProductDtoList(order.getProductList()));
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> ordersList) {
        return ordersList.stream()
                .map(o -> new OrderDto(
                        o.getId(),
                        o.getOrderDate(),
                        userMapper.mapUserToUserDto(o.getUser()),
                        productMapper.mapToProductDtoList(o.getProductList())))
                .collect(Collectors.toList());
    }
}

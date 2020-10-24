package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/orders")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders () {

        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getProduct(@RequestParam Long orderId) {
        return new OrderDto(1L,1L, 2020,2,2);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder() {
        return new OrderDto(1L,2L,2020,1,1);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {

    }


}

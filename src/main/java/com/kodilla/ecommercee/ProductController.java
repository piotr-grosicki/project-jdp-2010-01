package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) {
        return new ProductDto(1L, "Product test",new Group());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "Product test - update",new Group());
    }
}

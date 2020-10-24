package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getProductName());
    }

    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(product.getId(), product.getProductName());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(l -> new ProductDto(l.getId(), l.getProductName()))
                .collect(Collectors.toList());
    }
}

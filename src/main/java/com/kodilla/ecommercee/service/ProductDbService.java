package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDbService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    public Product getProduct(Long productId) {
        return productDao.findById(productId).orElse(null);
    }

    public Product saveProduct (Product product) {
        return productDao.save(product);
    }

    public void deleteProduct(Long productId) {

    }
}

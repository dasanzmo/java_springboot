package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void delete(Long id) {
        Product productFind = this.productRepository.findById(id).orElseThrow();

        this.productRepository.delete(productFind);
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        this.productRepository.findById(id).orElseThrow();

        product.setId(id);
        return this.productRepository.save(product);
    }
    
}

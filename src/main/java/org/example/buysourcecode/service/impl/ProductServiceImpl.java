package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.Product;
import org.example.buysourcecode.model.ProductStatus;
import org.example.buysourcecode.repository.ProductRepository;
import org.example.buysourcecode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getListProducts() {
        return productRepository.findAllProduct();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product getProductBySlug(String slug) {
        return productRepository.findProductBySlug(slug);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Product product) {
        product.setStatus(ProductStatus.DELETED);
        return productRepository.save(product);
    }
}

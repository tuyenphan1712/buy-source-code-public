package org.example.buysourcecode.service;

import org.example.buysourcecode.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getListProducts();
    public Product getProductById(String id);
    public Product getProductBySlug(String slug);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Product product);

}

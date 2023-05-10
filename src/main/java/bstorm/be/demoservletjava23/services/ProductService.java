package bstorm.be.demoservletjava23.services;

import bstorm.be.demoservletjava23.domain.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getMany();
    Product add(Product product);
    boolean delete(Integer id);
    boolean update(Integer id, Product product);
}


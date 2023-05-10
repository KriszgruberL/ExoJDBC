package bstorm.be.demoservletjava23.services;

import bstorm.be.demoservletjava23.domain.entities.Product;
import bstorm.be.demoservletjava23.repositories.ProductRepository;
import bstorm.be.demoservletjava23.repositories.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository = new ProductRepositoryImpl();

    public ProductServiceImpl() {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getMany() {
        return productRepository.getMany();
    }

    @Override
    public Product add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(Integer id, Product product) {
        return productRepository.update(id, product);
    }
}

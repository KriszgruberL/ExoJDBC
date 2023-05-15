package bstorm.be.demoservletjava23.services;

import bstorm.be.demoservletjava23.domain.entities.Product;
import bstorm.be.demoservletjava23.repositories.ProductRepository;
import bstorm.be.demoservletjava23.repositories.ProductRepositoryImpl;
import bstorm.be.demoservletjava23.repositories.TypeRepository;
import bstorm.be.demoservletjava23.repositories.TypeRepositoryImpl;
import bstorm.be.demoservletjava23.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository = new ProductRepositoryImpl();
    TypeRepository typeRepository = new TypeRepositoryImpl();

    @Override
    public List<Product> getMany() {
        return productRepository.getMany();
    }

    @Override
    public Product add(Product product) {
        try {
            Connection conn = DatabaseConnectionManager.openConnection();
            conn.setAutoCommit(false);
            if(product.getTypeName() != null){
                int id = typeRepository.add(product.getTypeName()).getTypeId();
                product.setTypeId(id);
            }
            Product newProduct =  productRepository.add(product);
            DatabaseConnectionManager.closeConnection();
            conn.commit();

            return newProduct;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


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

package bstorm.be.demoservletjava23.repositories;

import bstorm.be.demoservletjava23.domain.entities.Product;

public interface ProductRepository extends BaseRepository<Product> {

    Product findByName(String search);

}

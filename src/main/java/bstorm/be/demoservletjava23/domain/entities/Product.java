package bstorm.be.demoservletjava23.domain.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

        private Integer id;

        private String nameProduct;
        private String description;
        private String type;
        private Integer quantity;

    public Product(String nameProduct, String description, String type, Integer quantity) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.type = type;
        this.quantity = quantity;

    }
}

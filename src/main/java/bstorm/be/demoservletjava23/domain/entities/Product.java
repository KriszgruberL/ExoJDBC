package bstorm.be.demoservletjava23.domain.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

        private Integer id;

        private String nameProduct;
        private String description;
        private Integer quantity;

        private Integer typeId;
        private Type typeName;

    public Product(String nameProduct, String description, Integer quantity, Integer typeId) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantity = quantity;
        this.typeId = typeId;
    }

    public Product(String nameProduct, String description, Integer quantity, Type typeName) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantity = quantity;
        this.typeName = typeName;
    }
}

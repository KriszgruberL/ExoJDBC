package bstorm.be.demoservletjava23.domain.forms;

import bstorm.be.demoservletjava23.domain.entities.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForm {

    private String nameProduct;
    private String description;
    private String type;
    private Integer quantity;


    public Product toEntity() {

        return Product.builder()
                .nameProduct(this.getNameProduct())
                .description(this.getDescription())
                .type(this.getType())
                .quantity(this.getQuantity())
                .build();
    }
}

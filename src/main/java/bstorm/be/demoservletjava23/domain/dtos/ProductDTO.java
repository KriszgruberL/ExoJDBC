package bstorm.be.demoservletjava23.domain.dtos;

import bstorm.be.demoservletjava23.domain.entities.Product;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String nameProduct;
    private String description;
    private String type;
    private Integer quantity;



    public ProductDTO(String nameProduct, String type, Integer quantity) {
        this.nameProduct = nameProduct;
        this.type = type;
        this.quantity = quantity;
    }

    public static ProductDTO fromEntity(Product product){

        String description;

        if (product.getDescription().length() < 20){
            description = product.getDescription();
        } else {
            description = product.getDescription().substring(0,20) + "...";
        }

        return ProductDTO.builder()
                .id(product.getId())
                .nameProduct(product.getNameProduct())
                .description(product.getDescription())
                .type(product.getType())
                .build();
    }
}


package bstorm.be.demoservletjava23.domain.forms;

import bstorm.be.demoservletjava23.domain.entities.Product;
import bstorm.be.demoservletjava23.domain.entities.Type;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForm {

    private String nameProduct;
    private String description;
    private Integer quantity;
    private TypeForm typeForm;

    private Integer typeId;
    private String typeName;

    public ProductForm(String nameProduct, String description, Integer quantity, Integer typeId) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantity = quantity;
        this.typeId = typeId;
    }

    public ProductForm(String nameProduct, String description, Integer quantity, TypeForm typeForm) {
        this.nameProduct = nameProduct;
        this.description = description;
        this.quantity = quantity;
        this.typeForm = typeForm;
    }


    public Product toEntity() {
        Type type = getTypeForm() == null ? null : getTypeForm().toEntity();

        return Product.builder()
                .nameProduct(getNameProduct())
                .description(getDescription())
                .quantity(getQuantity())
                .typeId(getTypeId())
                .typeName(type)
                .build();
    }
}

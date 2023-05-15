package bstorm.be.demoservletjava23.domain.forms;

import bstorm.be.demoservletjava23.domain.entities.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeForm {

    private String typeName;

    public Type toEntity(){
        return Type.builder()
                .typeName(getTypeName())
                .build();
    }

}

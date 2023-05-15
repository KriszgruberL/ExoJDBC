package bstorm.be.demoservletjava23.services;

import bstorm.be.demoservletjava23.domain.entities.Type;
import bstorm.be.demoservletjava23.repositories.TypeRepository;
import bstorm.be.demoservletjava23.repositories.TypeRepositoryImpl;

import java.util.List;

public class TypeServiceImpl  implements TypeService{

    TypeRepository typeRepository;

    public TypeServiceImpl() {
        this.typeRepository = new TypeRepositoryImpl();
    }

    @Override
    public List<Type> getMany() {
        return typeRepository.getMany();
    }
}

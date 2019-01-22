package ru.itpark.mcdonalds.service;

import org.springframework.stereotype.Service;
import ru.itpark.mcdonalds.entity.ProductEntity;
import ru.itpark.mcdonalds.exception.ProductNotFoundException;
import ru.itpark.mcdonalds.repository.ProductRepository;


import java.util.List;


@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> getAll()  {
        return repository.getAll();
    }

    public ProductEntity getById(int id) {
        return repository.getById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public ProductEntity getByIdOrEmpty(int id) {
        return repository.getById(id)
                .orElse(new ProductEntity());
    }

    public ProductEntity getByName(String name){
        return repository.getByName(name)
                .orElseThrow(ProductNotFoundException::new);
    }
//    public List<ProductEntity> findByName(String name){
//        return repository.findAll()
//                .stream()
//                .map(ProductEntity::getName)
//                .map(String::toLowerCase)
//                .filter(o -> o.equals(name))
//                .collect(Collectors.toList());
//    }
}

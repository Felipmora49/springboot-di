package com.felipmora47.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.felipmora47.springboot.di.app.springboot_di.models.Product;

@Component
public class ProductRepositoryImpl implements IProductRepository {


    private  List<Product> data;

    public ProductRepositoryImpl() {

        this.data = Arrays.asList(
            new Product(1L,"Memoria Corsair", 100000L),
            new Product(2L,"Disco Duro 1TB", 200000L),
            new Product(3L,"Teclado Logitech", 50000L),
            new Product(4L,"Mouse Logitech", 40000L),
            new Product(5L,"Monitor 24", 300000L)
            );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById (Long id){
    
        //return data.stream().filter(p-> p.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(p-> p.getId().equals(id)).findFirst().orElse(null);
    }
}

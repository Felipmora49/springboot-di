package com.felipmora47.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.felipmora47.springboot.di.app.springboot_di.models.Product;
import com.felipmora47.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice()  * 1.25d;

            // Para que no ocurra inmutabilidad en el objeto original
            /* Product newProd = new Product(p.getId(),p.getName(),priceImp.longValue()); */

            //Otra forma de hacer para que no ocurra inmutabilidad en el objeto original
            Product newProd = (Product)p.clone();
            newProd.setPrice(priceTax.longValue());

            return newProd;

        }).collect(Collectors.toList());
    }

    public Product findById (Long id){
        return repository.findById(id);
    }
}

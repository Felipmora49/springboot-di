package com.felipmora47.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.felipmora47.springboot.di.app.springboot_di.models.Product;
import com.felipmora47.springboot.di.app.springboot_di.repositories.IProductRepository;
//import com.felipmora47.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

@Component
public class ProductServiceImpl implements IProductService {

    //Instancia de la clase ProductRepositoryImpl
   /*  private ProductRepositoryImpl repository = new ProductRepositoryImpl(); */

    //Inyección de dependencias de la clase ProductRepositoryImpl
    /* @Autowired
    private ProductRepositoryImpl repository; */

    //Inyección de dependencias de la interfaz IProductRepository
    @Autowired
    private IProductRepository repository; 

    @Override
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

    @Override
    public Product findById (Long id){
        return repository.findById(id);
    }
}
 
package com.newtonic.SpringShop.models.product;

import com.newtonic.SpringShop.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@RestController
@RequestMapping("/api")
public class ProductsController {

    ProductRepository productRepository;

    ProductsController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> all(){
        return this.productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id){
        return this.productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Cannot find product with id::"+id));
    }

    @PostMapping("/products")
    Product save(@RequestBody Product product){
        return this.productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    Product update(@PathVariable Long id, @RequestBody Product product){
        return this.productRepository.findById(id)
                .map(product1 -> {
                    product1.setCategories(product.getCategories());
                    product1.setName(product.getName());
                    product1.setCost(product.getCost());
                    product1.setDescription(product.getDescription());
                    product1.setThumbnail(product.getThumbnail());
                    product1.setImages(product.getImages());

                    return this.productRepository.save(product1);
                })
                .orElseGet(()->{
                    product.setId(id);
                    return this.productRepository.save(product);
                });
    }

}

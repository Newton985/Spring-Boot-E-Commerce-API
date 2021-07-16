package com.newtonic.SpringShop.models.product.categories;

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
public class CategoryController {

    ProductCategoryRepository productCategoryRepository;

    CategoryController(ProductCategoryRepository productCategoryRepository){
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping("/categories")
    List<ProductCategory> all(){
     return this.productCategoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    ProductCategory one(@PathVariable Long id){
        return this.productCategoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Cannot Find category with Id"+id));
    }

    @PostMapping("/categories")
    ProductCategory save(@RequestBody ProductCategory productCategory){
        return this.productCategoryRepository.save(productCategory);
    }

    @PutMapping("/categories/{id}")
    ProductCategory update(@PathVariable Long id, @RequestBody ProductCategory productCategory){
        return this.productCategoryRepository.findById(id)
                .map(productCategory1 -> {
                    productCategory1.setProducts( productCategory.getProducts());
                    productCategory1.setDescription(productCategory.getDescription());
                    productCategory1.setName(productCategory.getName());

                    return this.productCategoryRepository.save(productCategory1);
                })
                .orElseGet(()->{
                    productCategory.id = id;
                    return this.productCategoryRepository.save(productCategory);
                });
    }

    @DeleteMapping("/categories/{id}")
    void delete(@PathVariable Long id){
        this.productCategoryRepository.deleteById(id);
    }
}

package com.newtonic.SpringShop.models.product.categories;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.newtonic.SpringShop.models.product.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    Long id;

    private String name;

    private String description;

    @JsonIdentityInfo(  generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany( mappedBy = "categories")
    List<Product> products;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

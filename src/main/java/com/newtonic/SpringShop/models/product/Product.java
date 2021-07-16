package com.newtonic.SpringShop.models.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.newtonic.SpringShop.models.Cart.Cart;
import com.newtonic.SpringShop.models.Cart.CartProduct;
import com.newtonic.SpringShop.models.product.categories.ProductCategory;

import javax.persistence.*;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String cost;

    private String description;

    private String measurementScale;

    private String thumbnail;

    @ElementCollection
    private List<String> images;


    @JsonIdentityInfo(  generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany()
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<ProductCategory> categories;

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

    public String getCost() {
        return this.cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasurementScale() {
        return this.measurementScale;
    }

    public void setMeasurementScale(String measurementScale) {
        this.measurementScale = measurementScale;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<ProductCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

}

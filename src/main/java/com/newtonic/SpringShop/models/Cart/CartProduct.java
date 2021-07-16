package com.newtonic.SpringShop.models.Cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.newtonic.SpringShop.models.product.Product;

import javax.persistence.*;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@Entity
public class CartProduct{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = Product.class )
    private Product product;

    @JsonBackReference
    @ManyToOne()
    private Cart cart;

    private int quantity;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    
}

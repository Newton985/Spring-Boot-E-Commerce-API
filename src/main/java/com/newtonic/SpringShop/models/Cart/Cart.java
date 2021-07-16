package com.newtonic.SpringShop.models.Cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.newtonic.SpringShop.models.user.User;
import javax.persistence.*;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartProduct> products;

    @JsonBackReference
    @ManyToOne()
    private User user;

    private int status = 1;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartProduct> getProducts() {
        return this.products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


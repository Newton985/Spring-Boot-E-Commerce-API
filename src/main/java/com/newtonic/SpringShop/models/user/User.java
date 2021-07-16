package com.newtonic.SpringShop.models.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.newtonic.SpringShop.models.Cart.Cart;

import javax.persistence.*;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String password;

    private String role;

    @JsonManagedReference
    @OneToMany(cascade = { CascadeType.ALL}, mappedBy = "user")
    private List<Cart> carts;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Cart> getCarts() {
        return carts;
    }
}

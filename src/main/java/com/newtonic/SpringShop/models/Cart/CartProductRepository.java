package com.newtonic.SpringShop.models.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
}

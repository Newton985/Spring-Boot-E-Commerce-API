package com.newtonic.SpringShop.models.Cart;

import com.newtonic.SpringShop.models.user.User;

import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

public interface CustomCartRepository {
    List<Cart> findByUserAndStatus(User user, int status);
}

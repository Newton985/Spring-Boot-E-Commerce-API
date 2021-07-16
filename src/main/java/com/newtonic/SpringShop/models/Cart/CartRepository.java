package com.newtonic.SpringShop.models.Cart;

import com.newtonic.SpringShop.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

public interface CartRepository extends JpaRepository<Cart, Long> , CustomCartRepository{
     @Transactional
    void deleteByUser (User user);

     @Transactional
    List<Cart> findByUser(User user);

}

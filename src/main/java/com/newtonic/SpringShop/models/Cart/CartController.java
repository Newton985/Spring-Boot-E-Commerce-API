package com.newtonic.SpringShop.models.Cart;

import com.newtonic.SpringShop.exceptions.NotFoundException;
import com.newtonic.SpringShop.models.user.User;
import com.newtonic.SpringShop.models.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@RestController
@RequestMapping("/api")
public class CartController {
    CartRepository cartRepository;
    UserRepository userRepository;

    public CartController(CartRepository cartRepository, UserRepository userRepository){
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/cart/{id}")
    Cart one(@PathVariable Long id){
        return this.cartRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(("Cannot find Cart with Id ::"+id)));
    }

    @GetMapping("/users/carts/{id}/{status}")
    List<Cart> userCarts(@PathVariable Long id, @PathVariable int status){
        User user = this.userRepository.findById(id).orElseThrow(()->new NotFoundException("No user with Id"+id));
        return  cartRepository.findByUserAndStatus(user, status);
    }

    @PostMapping("/cart")
    Cart save(@RequestBody Cart cart){
     return  this.cartRepository.save(cart);

    }

    @PutMapping("/cart/{id}")
    Cart update(@PathVariable Long id, @RequestBody Cart cart){
        return this.cartRepository.findById(id)
                .map(cart1 -> {
                    cart1.setProducts(cart.getProducts());
                    return this.cartRepository.save(cart);
                }).orElseGet(()->{
                    cart.setId(id);
                    return this.cartRepository.save(cart);
                });
    }

        @DeleteMapping("/cart/{id}")
        void delete(@PathVariable Long id){
           cartRepository.deleteById(id);
        }

}

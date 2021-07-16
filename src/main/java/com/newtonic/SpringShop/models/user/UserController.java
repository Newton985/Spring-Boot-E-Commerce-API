package com.newtonic.SpringShop.models.user;

import com.newtonic.SpringShop.exceptions.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO: write you class description here
 *
 * @author
 */

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;


    public  UserController(UserRepository userRepository){
        this.userRepository =  userRepository;
    }


    @GetMapping("/users")
    List<User> all(){
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could Not Find User With Id :: "+id));
    }

    @PostMapping("/users")
    User save(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    User update(@PathVariable Long id, @RequestBody User user){
        return this.userRepository.findById(id)
                .map(user1 -> {
                    user1.setEmail(user.getEmail());
                    user1.setFullName(user.getFullName());
                    user1.setPhoneNumber(user.getPhoneNumber());
                    user1.setPassword(user.getPassword());
                    user1.setRole(user.getRole());
                    return this.userRepository.save(user1);
                }).orElseGet(()->{
                    user.setId(id);
                    return this.userRepository.save(user);
                });
    }

    @PutMapping("/users")
    User update(@RequestBody User user){
        return this.userRepository.findById(user.getId())
                .map(user1 -> {
                    user1.setEmail(user.getEmail());
                    user1.setFullName(user.getFullName());
                    user1.setPhoneNumber(user.getPhoneNumber());
                    user1.setPassword(user.getPassword());
                    user1.setRole(user.getRole());
                    return this.userRepository.save(user1);
                }).orElseThrow(()-> new NotFoundException("Cannot Find User With Id::"+user.getId()));
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Long id){
        this.userRepository.deleteById(id);
    }


}

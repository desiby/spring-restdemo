/*
 * Created by Desire Bah Bioh
 * copyright 2017
 * Rest Controller class to handle query transactions
 */


package com.example.restdemo.controller;

import com.example.restdemo.Repositories.UserJpaRepository;
import com.example.restdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    /**
     * get a list of all user
     * @return a list of user
     */
    @GetMapping("/all")
    public List<User> findAll(){
        return userJpaRepository.findAll();
    }

    /**
     * find a user by name
     * @param name name of user
     * @return the user object
     */
    @GetMapping("/{name}")
    public User findByName(@PathVariable String name){
        return userJpaRepository.findByName(name);
    }

    /**
     * create a new user
     * @param user a user object
     * @return the user object
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        userJpaRepository.save(user);
        return userJpaRepository.findByName(user.getName());
    }

    /**
     * update user by id
     * @param id user id
     * @param aUser a user object
     * @return User user object
     * @throws Exception in case id doesn't exist
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User aUser) throws Exception {
            User user = userJpaRepository.findOne(id);
            user.setName(aUser.getName());
            userJpaRepository.save(user);
            return userJpaRepository.findOne(id);
    }

    /**
     * delete a user by id
     * @param id user id
     * @throws Exception in case id doesn't exist
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws  Exception{
        userJpaRepository.delete(id);
    }

}

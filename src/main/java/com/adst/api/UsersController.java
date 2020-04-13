package com.adst.api;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de usuarios.
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUsers(@RequestParam("name") String firstname) {
        System.out.println("first name " + firstname);
        User user = new User();
        user.set_id(new ObjectId());
        user.setUsername(firstname);
        List<User> users = new ArrayList<>();
        users.add(user);
        System.out.println("El ObjectId : " + user.get_id().toHexString());
        return users;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(code= HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        System.out.println("User: " + user.toString());
        user.set_id(ObjectId.get());
        repository.save(user);
        return user;
    }
}

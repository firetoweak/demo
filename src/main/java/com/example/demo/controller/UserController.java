package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @GetMapping(value = "/")
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>(users.values());
        return userList;
    }

    @PostMapping(value = "/")
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        User user1 = users.get(id);
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        users.put(id,user1);
        return "success!";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success!";
    }
}

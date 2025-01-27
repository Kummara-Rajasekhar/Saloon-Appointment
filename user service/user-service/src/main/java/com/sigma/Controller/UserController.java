package com.sigma.Controller;

import com.sigma.Exception.UserException;
import com.sigma.Model.User;
import com.sigma.Repository.Userrepository;
import com.sigma.Service.UserService;
import com.sigma.Service.imp.UserServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;


    @PostMapping("/api/usrs/")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }


    @PostMapping("/api/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) throws Exception {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user ,@PathVariable Long id) throws Exception {
        User user1 = userService.updateUser(id,user);
        return new ResponseEntity<>(user1,HttpStatus.OK);


    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUserByid(@PathVariable Long id) throws Exception {
            userService.deleteUser(id);
            return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
    }


}

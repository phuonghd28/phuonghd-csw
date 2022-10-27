package com.example.crudapi.controllers;

import com.example.crudapi.entities.SpringUsersEntity;
import com.example.crudapi.services.SpringUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SpringUserController {
    @Autowired
    SpringUserService springUserService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<List<SpringUsersEntity>> findAllUser() {
        List<SpringUsersEntity> listUser = springUserService.findAll();
        if(listUser.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<SpringUsersEntity> saveNewUser(@RequestBody SpringUsersEntity u) {
        springUserService.saveUser(u);
        return new ResponseEntity<SpringUsersEntity>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<SpringUsersEntity> getUser(@PathVariable(value = "id") Integer id) {
        SpringUsersEntity user = springUserService.findById(id);
        return new ResponseEntity<SpringUsersEntity>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SpringUsersEntity> updateUser(
            @PathVariable(value="id") Integer id,
            @RequestBody SpringUsersEntity u) {
        SpringUsersEntity oldUser = springUserService.findById(id);
        oldUser.setEmail(u.getEmail());
        oldUser.setName(u.getName());
        oldUser.setPhone(u.getPhone());
        springUserService.saveUser(oldUser);
        return new ResponseEntity<SpringUsersEntity>(oldUser, HttpStatus.OK);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SpringUsersEntity> deleteUser(@PathVariable(value = "id") Integer id) {
        springUserService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

package com.example.crudapi.services;

import com.example.crudapi.entities.SpringUsersEntity;

import java.util.List;

public interface SpringUserService {
    public void saveUser(SpringUsersEntity u);
    public void deleteUser(Integer id);
    public SpringUsersEntity findById(Integer id);
    public List<SpringUsersEntity> findAll();
    public List<SpringUsersEntity> findAllByName(String name);
}

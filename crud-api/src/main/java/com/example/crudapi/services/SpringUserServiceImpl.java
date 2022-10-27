package com.example.crudapi.services;

import com.example.crudapi.entities.SpringUsersEntity;
import com.example.crudapi.repositories.SpringUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpringUserServiceImpl implements SpringUserService{
    @Autowired
    SpringUserRepository springUserRepository;

    @Override
    public void saveUser(SpringUsersEntity u) {
        springUserRepository.save(u);
    }

    @Override
    public void deleteUser(Integer id) {
        springUserRepository.deleteById(id);
    }

    @Override
    public SpringUsersEntity findById(Integer id) {
        Optional<SpringUsersEntity> springUsers = springUserRepository.findById(id);
        SpringUsersEntity springUser = springUsers.get();
        return springUser;
    }

    @Override
    public List<SpringUsersEntity> findAll() {
        return springUserRepository.findAll();
    }

    @Override
    public List<SpringUsersEntity> findAllByName(String name) {
        return springUserRepository.findAllByName(name);
    }
}

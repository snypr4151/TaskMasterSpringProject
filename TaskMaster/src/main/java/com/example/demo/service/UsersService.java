package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersEntity saveOrUpdateUser(UsersEntity user) {
        return usersRepository.save(user);
    }
    
    public UsersEntity findByUsernameAndPassword(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    public UsersEntity findById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }
    
    
    public String getBadgeClassByPosition(String rutbesi) {
        if ("TakimLideri".equals(rutbesi)) {
            return "badge-danger";
        } else if ("Mühendis".equals(rutbesi)) {
            return "badge-warning";
        } else if ("Stajer".equals(rutbesi)) {
            return "badge-info";
        }
        return "badge-secondary";
    }

}
package com.app.financial_platform.service;

import com.app.financial_platform.model.User;
import com.app.financial_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Erro: Esse e-mail já existe");
        }

        return userRepository.save(user);
    }
}

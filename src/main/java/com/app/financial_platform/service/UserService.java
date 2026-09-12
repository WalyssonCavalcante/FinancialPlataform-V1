package com.app.financial_platform.service;

import com.app.financial_platform.dto.UserRequestDTO;
import com.app.financial_platform.model.User;
import com.app.financial_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDTO dto){
        if (userRepository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("Erro: Esse e-mail já existe");
        }

        User newUser = new User();
        newUser.setName(dto.name());
        newUser.setEmail(dto.email());

        return userRepository.save(newUser);
    }
}

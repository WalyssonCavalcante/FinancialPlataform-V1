package com.app.financial_platform.service;

import com.app.financial_platform.dto.LoginRequestDTO;
import com.app.financial_platform.dto.UserRequestDTO;
import com.app.financial_platform.dto.UserResponseDTO;
import com.app.financial_platform.model.User;
import com.app.financial_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        newUser.setPassword(dto.password());

        return userRepository.save(newUser);
    }

    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user))
                .toList();
    }

    public UserResponseDTO login(LoginRequestDTO dto){
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new IllegalArgumentException("Erro: E-mail não encontrado"));

        if (!user.getPassword().equals(dto.password())){
            throw new IllegalArgumentException("Erro: Senha incorreta");
        }

        return new UserResponseDTO(user);
    }
}

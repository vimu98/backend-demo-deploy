package com.example.backend.service.impl;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.repo.UserRepo;
import com.example.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ModelMapper modelMapper;

    public void register(UserDTO dto) {
        User user = modelMapper.map(dto, User.class);
        user.setPassword(encoder.encode(dto.getPassword()));
        userRepo.save(user);
    }

    public boolean validate(UserDTO dto) {
        Optional<User> user = userRepo.findByUsername(dto.getUsername());
        return user.isPresent() && encoder.matches(dto.getPassword(), user.get().getPassword());
    }
}

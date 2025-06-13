package com.example.backend.service;

import com.example.backend.dto.UserDTO;


public interface UserService {
    void register(UserDTO userDTO);
    boolean validate(UserDTO userDTO);
}

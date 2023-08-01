/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.app.service;

import com.mygame.app.dto.request.user.RequestUserDto;
import com.mygame.app.model.User;
import com.mygame.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public User add(RequestUserDto dto) {
        User u = modelMapper.map(dto, User.class);
        return userRepository.save(u);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }
}

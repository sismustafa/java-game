/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.app.service;

import com.mygame.app.dto.request.characters.RequestCharactersDto;
import com.mygame.app.dto.request.characters.UpdateCharacterDto;
import com.mygame.app.repository.CharactersRepository;
import com.mygame.app.model.Characters;
import com.mygame.app.model.User;
import com.mygame.app.repository.CharactersRepository;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
@AllArgsConstructor
public class CharactersService {

    private final CharactersRepository charactersRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public Characters add(RequestCharactersDto dto) {
        Characters c = new Characters();
        c.setName(dto.getName());
        c.setHealth(dto.getHealth());
        c.setPower(dto.getPower());
        c.setPoint(dto.getPoint());
        User u = userService.getUser(dto.getUserId());
        c.setUser(u);
        return charactersRepository.save(c);
    }

    public Characters getCharacter(Long id) {
        return charactersRepository.findById(id).get();
    }

    public Characters saveGame(UpdateCharacterDto dto) {
        Characters cha = charactersRepository.findById(dto.getId()).get();
        cha.setPoint(dto.getPoint());
        return charactersRepository.save(cha);
    }

}

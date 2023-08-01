/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.app.controller;

import com.mygame.app.dto.request.characters.RequestCharactersDto;
import com.mygame.app.dto.request.characters.UpdateCharacterDto;
import com.mygame.app.service.CharactersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("v1/character")
@AllArgsConstructor
public class CharactersController {

    private final CharactersService charactersService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody RequestCharactersDto dto) {
        return new ResponseEntity<>(charactersService.add(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCharacter(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(charactersService.getCharacter(id), HttpStatus.OK);
    }

    @PostMapping("savegame")
    public ResponseEntity<?> saveGame(@RequestBody UpdateCharacterDto dto) {
        return new ResponseEntity<>(charactersService.saveGame(dto), HttpStatus.ACCEPTED);
    }

}

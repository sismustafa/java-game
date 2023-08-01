/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mygame.app.model.Characters;

/**
 *
 * @author Asus
 */

@Repository
public interface CharactersRepository extends JpaRepository<Characters, Long>{
    
}

package org.example.controllers;

import org.example.services.MythicalPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EntityRestController {
    private final MythicalPersonService mythicalPersonService;

    public EntityRestController(MythicalPersonService mythicalPersonService) {
        this.mythicalPersonService = mythicalPersonService;
    }

    //TODO http://localhost:8080/save_mythical_person
    @PostMapping("/save_mythical_person")
    public ResponseEntity.BodyBuilder save(@RequestBody Map<String, Object> map) {
        try {
            mythicalPersonService.addMythicalPerson(map);
            return ResponseEntity.status(HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}

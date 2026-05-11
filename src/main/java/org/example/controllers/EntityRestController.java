package org.example.controllers;

import org.example.dto.MythicalPersonDto;
import org.example.model.MythicalPerson;
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

    /*
    TODO Запрос в Postman:
        {
            "name" : "Океанская Посейдониха Зевсовна",
            "age" : 1000000,
            "isgod" : true,
            "superpower" : "Делать и пить водичку",
            "mythicalanimal" : {
                "name" : "Водная псинка",
                "age" : 123,
                "color" : "Красный",
                "gender" : "Женский"
             }
         }
     */
//    //TODO http://localhost:8081/save_mythical_person
//    @PostMapping("/save_mythical_person")
//    public ResponseEntity.BodyBuilder save(@RequestBody Map<String, Object> map) {
//        try {
//            mythicalPersonService.addMythicalPerson(map);
//            return ResponseEntity.status(HttpStatus.OK);
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/save_mythical_person")
    public ResponseEntity<MythicalPersonDto> save(@RequestBody Map<String, Object> map) {
        try {
            MythicalPersonDto mythicalPersonDto = mythicalPersonService.addMythicalPerson(map);
            return ResponseEntity.status(HttpStatus.CREATED).body(mythicalPersonDto);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}

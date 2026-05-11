package org.example.controllers;

import org.example.dto.MythicalPersonFullDto;
import org.example.dto.MythicalPersonResponseUserDto;
import org.example.services.MythicalPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
//    TODO http://localhost:8081/save_mythical_person
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
    public ResponseEntity<MythicalPersonFullDto> save(@RequestBody Map<String, Object> map) {
        try {
            MythicalPersonFullDto mythicalPersonFullDto = mythicalPersonService.addMythicalPerson(map);
            return ResponseEntity.status(HttpStatus.CREATED).body(mythicalPersonFullDto);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    //TODO http://localhost:8081/get_information_about_all_person
    @GetMapping("/get_information_about_all_person")
    public List<MythicalPersonResponseUserDto> getInformationAboutAllPerson() {
        List<MythicalPersonResponseUserDto> mythicalPersonResponseUserDto = mythicalPersonService.getInformationAboutAllPerson();
        return mythicalPersonResponseUserDto;
    }
}

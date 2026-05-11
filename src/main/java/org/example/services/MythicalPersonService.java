package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.MythicalAnimalFullDto;
import org.example.dto.MythicalPersonFullDto;
import org.example.dto.MythicalPersonResponseUserDto;
import org.example.model.MythicalPerson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MythicalPersonService {
    private List<MythicalPerson> mythicalPersonList = new ArrayList<>();

//    public void addMythicalPerson(Map<String, Object> map) throws Exception {
//        /*
//        TODO
//         Для возможности преобразования
//         из map как текста в mythicalPerson(объект java)
//         */
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        //TODO Преобразование мифическую персону как Map в текст
//        String mapPersonToText = objectMapper.writeValueAsString(map);
//
//        //TODO Само преобразование из map как текста в mythicalPerson(объект java)
//        MythicalPerson mythicalPerson = objectMapper.readValue(mapPersonToText, MythicalPerson.class);
//        mythicalPersonList.add(mythicalPerson);
//        System.out.println(mythicalPerson + " добавлен");
//    }

    public MythicalPersonFullDto addMythicalPerson(Map<String, Object> map) throws Exception {
        /*
        TODO
         Для возможности преобразования
         из map как текста в mythicalPerson(объект java)
         */
        ObjectMapper objectMapper = new ObjectMapper();

        //TODO Преобразование мифическую персону как Map в текст
        String mapPersonToText = objectMapper.writeValueAsString(map);

        //TODO Само преобразование из map как текста в mythicalPerson(объект java)
        MythicalPerson mythicalPerson = objectMapper.readValue(mapPersonToText, MythicalPerson.class);
        mythicalPersonList.add(mythicalPerson);
        System.out.println(mythicalPerson + " добавлен");
        return mapperPersonFromObjectToFullDto(mythicalPerson);
    }

    public MythicalPersonFullDto mapperPersonFromObjectToFullDto(MythicalPerson mythicalPerson) {
        MythicalPersonFullDto mythicalPersonFullDto = new MythicalPersonFullDto();
        mythicalPersonFullDto.setName(mythicalPerson.getName());
        mythicalPersonFullDto.setAge(mythicalPerson.getAge());
        mythicalPersonFullDto.setIsgod(mythicalPerson.isIsgod());
        mythicalPersonFullDto.setSuperpower(mythicalPerson.getSuperpower());

        MythicalAnimalFullDto mythicalAnimalFullDto =
                new MythicalAnimalFullDto();
        mythicalAnimalFullDto.setName(mythicalPerson.getMythicalanimal().getName());
        mythicalAnimalFullDto.setAge(mythicalPerson.getMythicalanimal().getAge());
        mythicalAnimalFullDto.setColor(mythicalPerson.getMythicalanimal().getColor());
        mythicalAnimalFullDto.setGender(mythicalPerson.getMythicalanimal().getGender());
        mythicalPersonFullDto.setMythicalanimal(mythicalAnimalFullDto);
        return mythicalPersonFullDto;
    }

    public MythicalPersonResponseUserDto mapperPersonFromObjectToResponseUserDto(MythicalPerson mythicalPerson) {
        MythicalPersonResponseUserDto mythicalPersonResponseUserDto = new MythicalPersonResponseUserDto();
        mythicalPersonResponseUserDto.setName(mythicalPerson.getName());
        mythicalPersonResponseUserDto.setAge(mythicalPerson.getAge());
        mythicalPersonResponseUserDto.setIsgod(mythicalPerson.isIsgod());
        mythicalPersonResponseUserDto.setSuperpower(mythicalPerson.getSuperpower());

        MythicalAnimalFullDto mythicalAnimalFullDto =
                new MythicalAnimalFullDto();
        mythicalAnimalFullDto.setName(mythicalPerson.getMythicalanimal().getName());
        mythicalAnimalFullDto.setAge(mythicalPerson.getMythicalanimal().getAge());
        mythicalAnimalFullDto.setColor(mythicalPerson.getMythicalanimal().getColor());
        mythicalAnimalFullDto.setGender(mythicalPerson.getMythicalanimal().getGender());
        return mythicalPersonResponseUserDto;
    }

    public List<MythicalPersonResponseUserDto> getInformationAboutAllPerson() {
        List<MythicalPersonResponseUserDto> mythicalPersonResponseUserDtoList = mythicalPersonList
                .stream()
                .map(person -> mapperPersonFromObjectToResponseUserDto(person))
                .collect(Collectors.toList());
        return mythicalPersonResponseUserDtoList;
    }
}

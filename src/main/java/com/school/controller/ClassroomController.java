package com.school.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.school.dto.ClassroomDTO;
import com.school.model.Classroom;
import com.school.service.ClassroomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * ClassroomController
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{roomName}")
    public ClassroomDTO getClassroomByRoomName(@PathVariable("roomName") String roomName) {
        Classroom classroom = classroomService.findByRoomName(roomName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("No room found with name %s", roomName)));
        // TODO internationalize
        return modelMapper.map(classroom, ClassroomDTO.class);
    }

    @PostMapping("/save")
    public ClassroomDTO saveClassroom(@RequestBody ClassroomDTO classroomData) {
        return modelMapper.map(
                classroomService.save(modelMapper.map(classroomData, Classroom.class)),
                ClassroomDTO.class);
    }

    @PostMapping("/saveandredirect")
    public String saveClassroomAndRedirect(@RequestBody ClassroomDTO classroomData) {
        Classroom classroom =
                classroomService.save(modelMapper.map(classroomData, Classroom.class));
        return String.format("redirect:/classroom/%s", classroom.getRoomName());
    }

}

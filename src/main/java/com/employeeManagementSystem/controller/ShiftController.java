package com.employeeManagementSystem.controller;

import com.employeeManagementSystem.model.Shift;
import com.employeeManagementSystem.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class ShiftController {

    @Autowired
    private ShiftRepository shiftRepository;

    //get all shifts
    @GetMapping("/shifts")
    public List<Shift> getAllShifts(){
        return  shiftRepository.findAll();
    }
    
    //create new shift rest api
    @PostMapping("/shifts")
    public Shift createShift(@RequestBody Shift shift){
        return shiftRepository.save(shift);
    }
}

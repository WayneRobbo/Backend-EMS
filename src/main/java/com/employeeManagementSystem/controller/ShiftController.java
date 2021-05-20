package com.employeeManagementSystem.controller;

import com.employeeManagementSystem.exception.ResourceNotFoundException;
import com.employeeManagementSystem.model.Shift;
import com.employeeManagementSystem.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //get shift by id
    @GetMapping("/shifts/{id}")
    public ResponseEntity<Shift> getShiftById(@PathVariable Long id){
        Shift shift = shiftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found with id:" + id));
        return ResponseEntity.ok(shift);
    }
}

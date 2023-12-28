package com.personalFinanceTracker.controller;


import com.personalFinanceTracker.model.Type;
import com.personalFinanceTracker.service.InterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/types")
public class TypeController {
    
    @Autowired
    InterType typeService;

    @GetMapping("")
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> geTypeById(@PathVariable Long id) {
        Optional<Type> optType = typeService.getTypeById(id);

        if (optType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optType.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Type createType(@RequestBody Type type) {
        return typeService.createType(type);
    }

    @PutMapping("/{id}/edit")
    public Type editType(@PathVariable Long id, @RequestBody Type type) {
        return typeService.updateType(type);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteType(@PathVariable Long id, @RequestBody Type type) {
        if (id != type.getId()) {
            return new ResponseEntity<>(
                    "Request Error: id on the the path not equal to the one on the Request Body !",
                    HttpStatus.OK);
        }

        typeService.deleteType(type);
        return new ResponseEntity<>("Type Deleted !", HttpStatus.OK);
    }
}

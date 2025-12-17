package com.amank.Real_Estate_Rental_.API.controller;

import com.amank.Real_Estate_Rental_.API.entity.Property;
import com.amank.Real_Estate_Rental_.API.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    private final PropertyService service;

    public PropertyController(PropertyService service){
        this.service = service;
    }

    @PostMapping
    public Property addProperty(@Valid @RequestBody Property property){
        return service.saveProperty(property);
    }

    @GetMapping
    public List<Property> getAllProperties(){
        return service.getAllProperties();
    }

    @GetMapping("/search")
    public List<Property> searchByLocation(@RequestParam String location){
        return service.getPropertiesByLocation(location);
    }

    @GetMapping("/filter")
    public List<Property> filterProperties(
            @RequestParam String location,
            @RequestParam Double min,
            @RequestParam Double max) {

        return service.filterProperties(location, min, max);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = service.getPropertyById(id);
        if (property != null) {
            return ResponseEntity.ok(property);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        Property updatedProperty = service.updateProperty(id, property);
        if (updatedProperty != null) {
            return ResponseEntity.ok(updatedProperty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        boolean isDeleted = service.deleteProperty(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


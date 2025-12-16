package com.amank.Real_Estate_Rental_.API.controller;

import com.amank.Real_Estate_Rental_.API.entity.Property;
import com.amank.Real_Estate_Rental_.API.service.PropertyService;
import jakarta.validation.Valid;
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
}


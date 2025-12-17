package com.amank.Real_Estate_Rental_.API.service;

import com.amank.Real_Estate_Rental_.API.entity.Property;
import com.amank.Real_Estate_Rental_.API.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository repository;

    public PropertyService(PropertyRepository repository){
        this.repository = repository;
    }

    public Property saveProperty(Property property){
        return repository.save(property);
    }

    public List<Property> getAllProperties(){
        return repository.findAll();
    }

    public List<Property> getPropertiesByLocation(String location){
        return repository.findByLocation(location);
    }

    public List<Property> filterProperties(String location, Double minPrice, Double maxPrice) {
        return repository.findByLocationContainingAndPriceBetween(location, minPrice, maxPrice);
    }

    public Property getPropertyById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Property updateProperty(Long id, Property newDetails) {
        Property existingProperty = repository.findById(id).orElse(null);

        if (existingProperty != null) {
            existingProperty.setTitle(newDetails.getTitle());
            existingProperty.setPrice(newDetails.getPrice());
            existingProperty.setLocation(newDetails.getLocation());
            existingProperty.setType(newDetails.getType());
            existingProperty.setOwnerContact(newDetails.getOwnerContact());

            return repository.save(existingProperty);
        }
        return null;
    }

    public boolean deleteProperty(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

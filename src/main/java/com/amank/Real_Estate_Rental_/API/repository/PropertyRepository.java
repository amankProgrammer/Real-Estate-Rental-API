package com.amank.Real_Estate_Rental_.API.repository;

import com.amank.Real_Estate_Rental_.API.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByLocation(String location);

    List<Property> findByLocationContainingAndPriceBetween(String location, Double minPrice, Double maxPrice);
}

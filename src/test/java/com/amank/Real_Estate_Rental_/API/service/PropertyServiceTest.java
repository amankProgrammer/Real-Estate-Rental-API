package com.amank.Real_Estate_Rental_.API.service;


import com.amank.Real_Estate_Rental_.API.entity.Property;
import com.amank.Real_Estate_Rental_.API.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Enables Mockito
public class PropertyServiceTest {

    @Mock
    private PropertyRepository repository; // Creates a "fake" repository

    @InjectMocks
    private PropertyService service; // Inject the "fake" repo into the real service

    @Test
    public void testSaveProperty() {
        // 1. Arrange: Create the data we expect
        Property property = new Property();
        property.setTitle("Test Villa");
        property.setPrice(50000.0);
        property.setLocation("Whitefield");

        // The "Mock": Tell Java "When repository.save() is called, return this property"
        // We do NOT actually touch the database.
        when(repository.save(property)).thenReturn(property);

        // 2. Act: Call the actual service method
        Property savedProperty = service.saveProperty(property);

        // 3. Assert: Check if the result is what we expected
        assertEquals("Test Villa", savedProperty.getTitle());
        assertEquals(50000.0, savedProperty.getPrice());
    }
}
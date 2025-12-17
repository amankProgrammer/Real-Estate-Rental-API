package com.amank.Real_Estate_Rental_.API.config;

import com.amank.Real_Estate_Rental_.API.entity.Property;
import com.amank.Real_Estate_Rental_.API.repository.PropertyRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    private final PropertyRepository repository;
    private final Faker faker;

    public DataLoader(PropertyRepository repository) {
        this.repository = repository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {
            System.out.println("🌱 Seeding database with realistic data...");

            // Generate 50 fake properties randomly
            for (int i = 0; i < 50; i++) {
                Property property = new Property();


                String location = faker.address().cityName();
                String[] bengaluruAreas = {"Indiranagar", "Whitefield", "Koramangala", "HSR Layout", "Jayanagar", "Electronic City", "Marathahalli"};
                String area = bengaluruAreas[new Random().nextInt(bengaluruAreas.length)];

                property.setTitle(faker.options().option("Luxury 2BHK", "Cozy 1BHK", "Spacious 3BHK", "Premium Villa") + " in " + area);
                property.setLocation(area);
                property.setType(faker.options().option("RENT", "SELL"));


                double price = 10000 + (new Random().nextDouble() * 90000);
                property.setPrice((double) Math.round(price)); // Round to whole number


                property.setOwnerContact(String.valueOf(faker.number().numberBetween(9000000000L, 9999999999L)));

                repository.save(property);
            }
            System.out.println(" Database populated with 50 properties!");
        }
    }
}
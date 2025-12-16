package com.amank.Real_Estate_Rental_.API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Data;

@Entity
@Data
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Type cannot be null")
    private String type;

    @Min(value=1, message = "Price must be greater than zero")
    private Double price;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    @Column(name = "owner_contact")
    private String ownerContact;
}

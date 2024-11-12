package com.microclimate.platform.si729pc2u201717523.microclimate.interfaces.rest;

import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects.Continent;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects.EmailAddress;

/**
 * Assembler for converting CreateMicroclimateResource to Microclimate entity.
 */
public class CreateMicroclimateFromResourceAssembler {

    /**
     * Converts a CreateMicroclimateResource to a Microclimate entity.
     *
     * @param resource the resource containing microclimate data
     * @return a Microclimate entity created from the resource
     * @throws IllegalArgumentException if the resource data is invalid
     */
    public static Microclimate toEntity(CreateMicroclimateResource resource) {
        validateResource(resource);

        return new Microclimate(
                resource.climateId(),
                new EmailAddress(resource.registerEmailAddress()),
                resource.climatePlace(),
                resource.climateCountry(),
                Continent.fromValue(resource.climateContinent()), // Convertir el índice a Continent
                resource.temperature(),
                resource.climateDateAt()
        );
    }

    /**
     * Validates the CreateMicroclimateResource data.
     *
     * @param resource the resource to validate
     * @throws IllegalArgumentException if any validation fails
     */
    private static void validateResource(CreateMicroclimateResource resource) {
        if (resource.climateId() == null || resource.climateId() <= 0) {
            throw new IllegalArgumentException("Climate ID must be a positive number");
        }
        if (resource.registerEmailAddress() == null || resource.registerEmailAddress().isBlank()) {
            throw new IllegalArgumentException("Owner email address cannot be blank");
        }
        if (resource.climatePlace() == null || resource.climatePlace().isBlank()) {
            throw new IllegalArgumentException("Climate place cannot be blank");
        }
        if (resource.climateCountry() == null || resource.climateCountry().isBlank()) {
            throw new IllegalArgumentException("Climate country cannot be blank");
        }
        if (resource.climateContinent() < 1 || resource.climateContinent() > Continent.values().length) {
            throw new IllegalArgumentException("Invalid climate continent");
        }
        if (resource.temperature() == null || resource.temperature() <= 0) {
            throw new IllegalArgumentException("Temperature must be a positive number");
        }
        if (resource.climateDateAt() == null) {
            throw new IllegalArgumentException("Climate date cannot be null");
        }
    }
}

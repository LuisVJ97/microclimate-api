package com.microclimate.platform.si729pc2u201717523.microclimate.infrastructure.persistence.jpa.repositories;

import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing microclimate data.
 */
@Repository
public interface MicroclimateRepository extends JpaRepository<Microclimate, Long> {

    /**
     * Checks if a microclimate exists with the specified climate ID, place, country, and continent.
     *
     * @param climateId      The unique identifier of the climate.
     * @param climatePlace   The place where the microclimate is located.
     * @param climateCountry The country where the microclimate is located.
     * @param climateContinent The continent of the microclimate.
     * @return true if a microclimate with the specified parameters exists, false otherwise.
     */
    boolean existsByClimateIdAndClimatePlaceAndClimateCountryAndClimateContinent(
            Long climateId, String climatePlace, String climateCountry, Continent climateContinent);
}

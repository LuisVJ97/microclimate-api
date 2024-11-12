package com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects;

/**
 * Represents the ID of a climate as a value object.
 */
public record ClimateId(Long id) {

    /// <summary>
    /// Initializes a new instance of the ClimateId class.
    /// </summary>
    /// <param name="id">The unique identifier for the climate. Must be a positive number.</param>
    public ClimateId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Climate ID must be a positive number");
        }
    }
}

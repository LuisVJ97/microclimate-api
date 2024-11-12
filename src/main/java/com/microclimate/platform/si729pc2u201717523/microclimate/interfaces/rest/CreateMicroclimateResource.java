package com.microclimate.platform.si729pc2u201717523.microclimate.interfaces.rest;

import java.util.Date;

/**
 * Resource for creating a new microclimate.
 */
public record CreateMicroclimateResource(
        /// <summary>
        /// The unique identifier for the climate.
        /// </summary>
        Long climateId,

        /// <summary>
        /// The email address of the person registering the microclimate.
        /// </summary>
        String registerEmailAddress,

        /// <summary>
        /// The place where the microclimate is measured.
        /// </summary>
        String climatePlace,

        /// <summary>
        /// The country where the microclimate is located.
        /// </summary>
        String climateCountry,

        /// <summary>
        /// The index of the continent where the microclimate is located.
        /// </summary>
        int climateContinent,

        /// <summary>
        /// The temperature of the microclimate.
        /// </summary>
        Long temperature,

        /// <summary>
        /// The date and time when the climate data was recorded.
        /// </summary>
        Date climateDateAt
) {
}

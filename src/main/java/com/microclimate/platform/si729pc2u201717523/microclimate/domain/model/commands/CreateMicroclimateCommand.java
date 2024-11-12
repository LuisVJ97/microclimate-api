package com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.commands;

import java.util.Date;

/// <summary>
/// Command for creating a new microclimate.
/// </summary>
public record CreateMicroclimateCommand(
        /// <summary>
        /// Gets the unique identifier for the climate.
        /// </summary>
        Long climateId,

        /// <summary>
        /// Gets the email address of the person registering the microclimate.
        /// </summary>
        String registerEmailAddress,

        /// <summary>
        /// Gets the place where the microclimate is measured.
        /// </summary>
        String climatePlace,

        /// <summary>
        /// Gets the country where the microclimate is located.
        /// </summary>
        String climateCountry,

        /// <summary>
        /// Gets the index of the continent where the microclimate is located.
        /// </summary>
        int climateContinent,

        /// <summary>
        /// Gets the temperature of the microclimate.
        /// </summary>
        Long temperature,

        /// <summary>
        /// Gets the date and time when the climate data was recorded.
        /// </summary>
        Date climateDateAt
) {
}

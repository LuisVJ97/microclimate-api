package com.microclimate.platform.si729pc2u201717523.microclimate.domain.services;

import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.commands.CreateMicroclimateCommand;

import java.util.Optional;

/// <summary>
/// Interface for handling commands related to microclimates.
/// </summary>
public interface MicroclimateCommandService {

    /// <summary>
    /// Handles the creation of a new microclimate based on the provided command.
    /// </summary>
    /// <param name="command">The command containing data to create a new microclimate.</param>
    /// <returns>The unique identifier of the created microclimate.</returns>
    Long handle(CreateMicroclimateCommand command);

    /// <summary>
    /// Finds a microclimate by its unique identifier.
    /// </summary>
    /// <param name="id">The unique identifier of the microclimate to find.</param>
    /// <returns>An Optional containing the found microclimate, or an empty Optional if not found.</returns>
    Optional<Microclimate> findById(Long id);
}
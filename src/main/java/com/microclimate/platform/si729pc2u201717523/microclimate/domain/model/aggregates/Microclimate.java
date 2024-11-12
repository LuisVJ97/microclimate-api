package com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.aggregates;

import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.commands.CreateMicroclimateCommand;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects.Continent;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects.EmailAddress;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
/// <summary>
/// Represents a microclimate with various attributes including climate ID, location, and temperature.
/// </summary>
public class Microclimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /// <summary>
    /// Gets or sets the unique identifier for the microclimate.
    /// </summary>
    private Long id;

    /// <summary>
    /// Gets or sets the unique identifier for the climate.
    /// </summary>
    private Long climateId;

    /// <summary>
    /// Gets or sets the email address of the person registering the microclimate.
    /// </summary>
    private EmailAddress registerEmailAddress;

    /// <summary>
    /// Gets or sets the place where the microclimate is measured.
    /// </summary>
    private String climatePlace;

    /// <summary>
    /// Gets or sets the country where the microclimate is located.
    /// </summary>
    private String climateCountry;

    @Enumerated(EnumType.STRING)
    /// <summary>
    /// Gets or sets the continent of the microclimate.
    /// </summary>
    private Continent climateContinent;

    /// <summary>
    /// Gets or sets the temperature of the microclimate.
    /// </summary>
    private Long temperature;

    @Temporal(TemporalType.TIMESTAMP)
    /// <summary>
    /// Gets or sets the date and time when the climate data was recorded.
    /// </summary>
    private Date climateDateAt;

    public Microclimate() {}

    // Constructor that accepts CreateMicroclimateCommand
    /// <summary>
    /// Initializes a new instance of the Microclimate class using the specified command.
    /// </summary>
    /// <param name="command">The command containing data to initialize the microclimate.</param>
    public Microclimate(CreateMicroclimateCommand command) {
        this.climateId = command.climateId(); // Assign climateId from command
        this.registerEmailAddress = new EmailAddress(command.registerEmailAddress());
        this.climatePlace = command.climatePlace();
        this.climateCountry = command.climateCountry();
        this.climateContinent = Continent.fromValue(command.climateContinent()); // Convert index to Continent
        this.temperature = command.temperature();
        this.climateDateAt = command.climateDateAt(); // Assign date from command
    }

    // Constructor that accepts individual parameters (optional)
    /// <summary>
    /// Initializes a new instance of the Microclimate class with specified parameters.
    /// </summary>
    public Microclimate(Long climateId, EmailAddress registerEmailAddress, String climatePlace,
                        String climateCountry, Continent climateContinent, Long temperature,
                        Date climateDateAt) {
        this.climateId = climateId;
        this.registerEmailAddress = registerEmailAddress;
        this.climatePlace = climatePlace;
        this.climateCountry = climateCountry;
        this.climateContinent = climateContinent;
        this.temperature = temperature;
        this.climateDateAt = climateDateAt;
    }
}

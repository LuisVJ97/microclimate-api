package com.microclimate.platform.si729pc2u201717523.microclimate.application.internal;

import com.microclimate.platform.si729pc2u201717523.microclimate.domain.exceptions.DuplicateMicroclimateException;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.commands.CreateMicroclimateCommand;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.valueobjects.Continent;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.services.MicroclimateCommandService;
import com.microclimate.platform.si729pc2u201717523.microclimate.infrastructure.persistence.jpa.repositories.MicroclimateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MicroclimateCommandServiceImpl implements MicroclimateCommandService {

    private final MicroclimateRepository microclimateRepository;

    public MicroclimateCommandServiceImpl(MicroclimateRepository microclimateRepository) {
        this.microclimateRepository = microclimateRepository;
    }

    @Override
    public Long handle(CreateMicroclimateCommand command) {
        Continent climateContinent = Continent.fromValue(command.climateContinent()); // Convierte el índice a Continent

        if (microclimateRepository.existsByClimateIdAndClimatePlaceAndClimateCountryAndClimateContinent(
                command.climateId(),
                command.climatePlace(),
                command.climateCountry(),
                climateContinent)) {
            throw new DuplicateMicroclimateException("Microclimate with ID %s already exists in place %s".formatted(command.climateId(), command.climatePlace()));
        }

        var microclimate = new Microclimate(command);

        try {
            microclimateRepository.save(microclimate);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving microclimate: %s".formatted(e.getMessage()));
        }

        return microclimate.getId();
    }

    @Override
    public Optional<Microclimate> findById(Long id) {
        return microclimateRepository.findById(id);
    }
}
package com.microclimate.platform.si729pc2u201717523.microclimate.interfaces.rest;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.si729pc2u201717523.microclimate.domain.model.commands.CreateMicroclimateCommand;
import com.microclimate.platform.si729pc2u201717523.microclimate.application.internal.MicroclimateCommandServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for handling microclimate-related requests.
 */
@RestController
@RequestMapping("/api/v1/microclimates")
@Tag(name = "Microclimates", description = "Available Microclimate Endpoints")
public class MicroclimateController {

    private final MicroclimateCommandServiceImpl microclimateCommandService;

    /**
     * Initializes a new instance of the MicroclimateController class.
     *
     * @param microclimateCommandService The service for handling microclimate commands.
     */
    public MicroclimateController(MicroclimateCommandServiceImpl microclimateCommandService) {
        this.microclimateCommandService = microclimateCommandService;
    }

    /**
     * Creates a new microclimate based on the provided resource.
     *
     * @param resource The resource containing data for creating a new microclimate.
     * @return A response entity containing the created microclimate and the HTTP status.
     */
    @PostMapping
    @Operation(summary = "Create a new microclimate", description = "Creates a new microclimate.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Microclimate created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Duplicate microclimate entry")
    })
    public ResponseEntity<Microclimate> addMicroclimate(@RequestBody CreateMicroclimateResource resource) {
        CreateMicroclimateFromResourceAssembler assembler = new CreateMicroclimateFromResourceAssembler();

        CreateMicroclimateCommand command = new CreateMicroclimateCommand(
                resource.climateId(),
                resource.registerEmailAddress(),
                resource.climatePlace(),
                resource.climateCountry(),
                resource.climateContinent(),
                resource.temperature(),
                resource.climateDateAt()
        );

        Long microclimateId = microclimateCommandService.handle(command);

        Microclimate savedMicroclimate = microclimateCommandService.findById(microclimateId)
                .orElseThrow(() -> new IllegalArgumentException("Microclimate not found after creation"));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMicroclimate);
    }
}

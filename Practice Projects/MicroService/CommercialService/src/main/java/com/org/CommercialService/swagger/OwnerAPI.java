package com.org.CommercialService.swagger;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

import com.org.CommercialService.DTO.Request.OwnerRequestDTO;
import com.org.CommercialService.DTO.Response.OwnerResponseDTO;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Owner", description = "APIs Specific to Owner will be available")
public interface OwnerAPI {
	
	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	
	@Operation(
    		operationId = "registerOwner",
    		summary = "Resgister Owner",
    		description = "API to register a new owner in the system",
    		tags = {"Owner"},
    		responses = {
					@ApiResponse(responseCode = "200", description = "Owner registered successfully",content = {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = OwnerResponseDTO.class)
							)
					}),
					@ApiResponse(responseCode = "400", description = "Invalid input data"),
					@ApiResponse(responseCode = "409", description = "Owner already exists")
			}
    		)
	@PostMapping(
			value = "/register",
			produces = {"application/json"}
			)
	default ResponseEntity<OwnerResponseDTO> registerOwner(
			@Parameter(
					name= "ownerRequestDTO", 
					description = "Owner registration details", 
					required = true
					)
			@RequestBody OwnerRequestDTO ownerRequestDTO) {
		getRequest().ifPresent(request -> {
			
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	@Operation(
			operationId = "getOwnerById",
			summary = "Get Owner by ID",
			description = "API to retrieve owner details by their ID",
			tags = {"Owner"},
			responses = {
					@ApiResponse(responseCode = "200", description = "Owner details retrieved successfully",content = {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = OwnerResponseDTO.class)
							)
					}),
					@ApiResponse(responseCode = "404", description = "Owner not found")
			}
	)
	@GetMapping(
			value = "/{ownerId}",
			produces = {"application/json"}
	)
	default ResponseEntity<?> getOwnerById(
			@Parameter(
					name= "ownerId", 
					description = "ID of the owner to retrieve", 
					required = true
					)
			@PathVariable("ownerId") Integer ownerId
			){
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}

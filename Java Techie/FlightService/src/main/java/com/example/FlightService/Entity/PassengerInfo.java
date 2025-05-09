package com.example.FlightService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PASSENGER_INFO")
@Component
public class PassengerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;
    @NotNull(message = "Username cannot be empty")
    private String name;

    @Email(message = "Invalid Email id")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number")
    private String mobile;

    @NotNull(message = "Invalid gender id")
    private String gender;

    private String source;
    private String destination;
    private Double fare;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate travelDate;
    private String pickUptime;
    private String arrivalTime;
}

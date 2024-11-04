package capstone1.Backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SUARecordBySecDto {
    private String SUAId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    private double accPressure;
    private double brakePressure;
    private double speed;
    private double rpm;
    private double coolantTemperature;
    private double intakeTemperature;
    private double intakePressure;
    private double engineLoad;
    private double mileage;
    private double drivingTime;
    private double averageSpeed;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime idleTime;
    private double instantaneousFuelEfficiency;
    private double instantaneousConsumption;
}

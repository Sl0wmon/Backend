package capstone1.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumableDto {
    private String carId;
    private double mileage;
    private double engineOilMileage;
    private LocalDate engineOilLast;
    private double brakeMileage;
    private LocalDate brakeLast;
    private double clutchMileage;
    private LocalDate clutchLast;
    private double steeringMileage;
    private LocalDate steeringLast;
    private double coolantMileage;
    private LocalDate coolantLast;
    private double fuelFilterMileage;
    private LocalDate fuelFilterLast;
    private double heaterFilterMileage;
    private LocalDate heaterFilterLast;
    private double conditionerFilterMileage;
    private LocalDate conditionerFilterLast;
    private double brakeLiningMileage;
    private LocalDate brakeLiningLast;
    private double brakePadFrontMileage;
    private LocalDate brakePadFrontLast;
    private double brakePadBackMileage;
    private LocalDate brakePadBackLast;
    private double wheelAlignmentMileage;
    private LocalDate wheelAlignmentLast;
    private double ignitionPlugMileage;
    private LocalDate ignitionPlugLast;
    private double batteryMileage;
    private LocalDate batteryLast;
    private double outerBeltMileage;
    private LocalDate outerBeltLast;
    private double timingBeltMileage;
    private LocalDate timingBeltLast;
}

package capstone1.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Consumable")
public class Consumable {
    @Id
    @Column(name = "car_id", nullable = false)
    private String carId;
    @Column(name = "mileage", nullable = false)
    private double mileage;
    @Column(name = "engineOil_mileage")
    private double engineOilMileage;
    @Column(name = "engineOil_last")
    private LocalDate engineOilLast;
    @Column(name = "missionOil_mileage")
    private double missionOilMileage;
    @Column(name = "missionOil_last")
    private LocalDate missionOilLast;
    @Column(name = "brake_mileage")
    private double brakeMileage;
    @Column(name = "brake_last")
    private LocalDate brakeLast;
    @Column(name = "clutch_mileage")
    private double clutchMileage;
    @Column(name = "clutch_last")
    private LocalDate clutchLast;
    @Column(name = "steering_mileage")
    private double steeringMileage;
    @Column(name = "steering_last")
    private LocalDate steeringLast;
    @Column(name = "coolant_mileage")
    private double coolantMileage;
    @Column(name = "coolant_last")
    private LocalDate coolantLast;
    @Column(name = "fuelFilter_mileage")
    private double fuelFilterMileage;
    @Column(name = "fuelFilter_last")
    private LocalDate fuelFilterLast;
    @Column(name = "heaterFilter_mileage")
    private double heaterFilterMileage;
    @Column(name = "heaterFilter_last")
    private LocalDate heaterFilterLast;
    @Column(name = "conditionerFilter_mileage")
    private double conditionerFilterMileage;
    @Column(name = "conditionerFilter_last")
    private LocalDate conditionerFilterLast;
    @Column(name = "brakeLining_mileage")
    private double brakeLiningMileage;
    @Column(name = "brakeLining_last")
    private LocalDate brakeLiningLast;
    @Column(name = "brakePad_front_mileage")
    private double brakePadFrontMileage;
    @Column(name = "brakePad_front_last")
    private LocalDate brakePadFrontLast;
    @Column(name = "brakePad_back_mileage")
    private double brakePadBackMileage;
    @Column(name = "brakePad_back_last")
    private LocalDate brakePadBackLast;
    @Column(name = "wheelAlignment_mileage")
    private double wheelAlignmentMileage;
    @Column(name = "wheelAlignment_last")
    private LocalDate wheelAlignmentLast;
    @Column(name = "ignitionPlug_mileage")
    private double ignitionPlugMileage;
    @Column(name = "ignitionPlug_last")
    private LocalDate ignitionPlugLast;
    @Column(name = "battery_mileage")
    private double batteryMileage;
    @Column(name = "battery_last")
    private LocalDate batteryLast;
    @Column(name = "outerBelt_mileage")
    private double outerBeltMileage;
    @Column(name = "outerBelt_last")
    private LocalDate outerBeltLast;
    @Column(name = "timingBelt_mileage")
    private double timingBeltMileage;
    @Column(name = "timingBelt_last")
    private LocalDate timingBeltLast;
}

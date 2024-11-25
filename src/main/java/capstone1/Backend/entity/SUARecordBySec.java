package capstone1.Backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUARecordBySec")
public class SUARecordBySec {
    @Id
    @Column(name = "timeStamp")
    private LocalDateTime timestamp;
    @Column(name = "SUAId")
    private String SUAId;
    @Column(name = "accPressure")
    private double accPressure;
    @Column(name = "brakePressure")
    private double brakePressure;
    @Column(name = "speed")
    private double speed;
    @Column(name = "rpm")
    private double rpm;
    @Column(name = "coolantTemperature")
    private double coolantTemperature;
    @Column(name = "intakeTemperature")
    private double intakeTemperature;
    @Column(name = "intakePressure")
    private double intakePressure;
    @Column(name = "engineLoad")
    private double engineLoad;
    @Column(name = "mileage")
    private double mileage;
    @Column(name = "drivingTime")
    private LocalTime drivingTime;
    @Column(name = "averageSpeed")
    private double averageSpeed;
    @Column(name = "idleTime")
    private LocalTime idleTime;
    @Column(name = "instantaneousFuelEfficieny")
    private double instantaneousFuelEfficiency;
    @Column(name = "instantaneousConsumption")
    private double instantaneousConsumption;
}

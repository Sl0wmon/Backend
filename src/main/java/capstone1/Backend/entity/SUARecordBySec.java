package capstone1.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private LocalDateTime timestamp;
    @Column(name = "SUAId", nullable = false)
    private String SUAId;
    @Column(name = "accPressure", nullable = false)
    private double accPressure;
    @Column(name = "brakePressure", nullable = false)
    private double brakePressure;
    @Column(name = "speed", nullable = false)
    private double speed;
    @Column(name = "rpm", nullable = false)
    private double rpm;
    @Column(name = "coolantTemperature", nullable = false)
    private double coolantTemperature;
    @Column(name = "intakeTemperature", nullable = false)
    private double intakeTemperature;
    @Column(name = "intakePressure", nullable = false)
    private double intakePressure;
    @Column(name = "engineLoad", nullable = false)
    private double engineLoad;
    @Column(name = "mileage", nullable = false)
    private double mileage;
    @Column(name = "drivingTime", nullable = false)
    private double drivingTime;
    @Column(name = "averageSpeed", nullable = false)
    private double averageSpeed;
    @Column(name = "idleTime", nullable = false)
    private LocalTime idleTime;
    @Column(name = "instantaneousFuelEfficieny", nullable = false)
    private double instantaneousFuelEfficiency;
    @Column(name = "instantaneousConsumption", nullable = false)
    private double instantaneousConsumption;
}

package capstone1.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dashboard")
public class Dashboard {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "speed", nullable = false)
    private double speed;
    @Column(name = "rpm", nullable = false)
    private double rpm;
    @Column(name = "coolantTemperature", nullable = false)
    private double coolantTemperature;
    @Column(name = "intakeTemerature", nullable = false)
    private double intakeTemperature;
    @Column(name = "engineLoad", nullable = false)
    private double engineLoad;
    @Column(name = "intakePressure", nullable = false)
    private double intakePressure;
    @Column(name = "mileage", nullable = false)
    private double mileage;
    @Column(name = "drivingTime", nullable = false)
    private LocalTime drivingTime;
    @Column(name = "averageSpeed", nullable = false)
    private double averageSpeed;
    @Column(name = "idleTime", nullable = false)
    private LocalTime idleTime;
    @Column(name = "instantaneousFuelEfficieny", nullable = false)
    private double instantaneousFuelEfficiency;
    @Column(name = "instantaneousConsumption", nullable = false)
    private double instantaneousConsumption;


}

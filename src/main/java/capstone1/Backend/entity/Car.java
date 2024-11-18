package capstone1.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name = "car_id", nullable = false)
    private String carId;
    @Column(name = "user_id", nullable = false)
    private String userId;
    // 제조사
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;
    // 차급
    @Column(name = "size", nullable = false)
    private String size;
    // 모델
    @Column(name = "model", nullable = false)
    private String model;
    // 연료
    @Column(name = "fuel", nullable = false)
    private String fuel;
    // 배기량
    @Column(name = "displacement", nullable = false)
    private String displacement;
    // 연식
    @Column(name = "year", nullable = false)
    private int year;
}

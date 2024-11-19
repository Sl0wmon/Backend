package capstone1.Backend.repository;

import capstone1.Backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findByUserId(String userId);
    List<Car> findByCarId(String carId);
}
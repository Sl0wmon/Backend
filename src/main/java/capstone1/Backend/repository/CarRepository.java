package capstone1.Backend.repository;

import capstone1.Backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findByUserId(String userId);
}
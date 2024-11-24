package capstone1.Backend.repository;

import capstone1.Backend.entity.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumableRepository extends JpaRepository<Consumable, String> {
    public Consumable findByCarId(String carId);
}
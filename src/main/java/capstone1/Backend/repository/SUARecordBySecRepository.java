package capstone1.Backend.repository;

import capstone1.Backend.entity.SUARecordBySec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SUARecordBySecRepository extends JpaRepository<SUARecordBySec, LocalDateTime> {
    List<SUARecordBySec> findBySUAId(String SUAId);
}

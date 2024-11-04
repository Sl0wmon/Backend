package capstone1.Backend.repository;

import capstone1.Backend.entity.SUARecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SUARecordRepository extends JpaRepository<SUARecord, String> {
    List<SUARecord> findByUserId(String userId);
}

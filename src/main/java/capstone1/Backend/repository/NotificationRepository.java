package capstone1.Backend.repository;

import capstone1.Backend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findAllByUserId(String userId);
}

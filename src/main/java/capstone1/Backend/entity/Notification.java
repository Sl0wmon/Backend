package capstone1.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @Column(name = "notification_id", nullable = false)
    private String notificationId;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "notificationTime", nullable = false)
    private LocalDateTime notificationTime;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
}

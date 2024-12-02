package capstone1.Backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUARecord")
public class SUARecord {
    @Id
    private String SUAId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "SUAOnTime", nullable = false)
    private LocalDateTime SUAOnTime;

    @Column(name = "SUAOffTime")
    private LocalDateTime SUAOffTime;
}

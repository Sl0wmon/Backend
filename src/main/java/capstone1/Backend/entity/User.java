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
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "pw", nullable = false)
    private String pw;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
}
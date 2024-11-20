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
@Table(name = "OBD_Diagnostic_Guide")
public class Guide {
    @Id
    @Column(name = "err_id", nullable = false)
    private int errId;
    @Column(name = "errCode", nullable = false)
    private String errCode;
    @Column(name = "errMessage")
    private String errMessage;
    @Column(name = "errSolution")
    private String errSolution;
    @Column(name = "carType", nullable = false)
    private String carType;
}

package capstone1.Backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SUARecordBySecDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    @JsonProperty("SUAId")
    private String SUAId;
    private double accPressure;
    private double brakePressure;
    private double speed;
    private double rpm;
    private double coolantTemperature;
    private double intakeTemperature;
    private double intakePressure;
    private double engineLoad;
}

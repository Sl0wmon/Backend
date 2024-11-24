package capstone1.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddConsumableDto {
    private String carId;
    private String consumableType;
    private double mileage;
    private LocalDate lastChanged;
}

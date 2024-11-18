package capstone1.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String carId;
    private String userId;
    private String manufacturer;
    private String size;
    private String model;
    private String fuel;
    private String displacement;
    private int year;
}

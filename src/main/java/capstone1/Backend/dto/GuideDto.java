package capstone1.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuideDto {
    private int errId;
    private String errCode;
    private String errMessage;
    private String errSolution;
    private String carType;
}

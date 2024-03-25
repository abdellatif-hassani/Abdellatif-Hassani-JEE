package ma.enset.orm_hibernate_spring_data.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor  @NoArgsConstructor @Setter @Getter
public class PatientDTO {
    private Long id;
    @NotEmpty
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    private boolean sick;
    @DecimalMax("100")
    private int score;
}

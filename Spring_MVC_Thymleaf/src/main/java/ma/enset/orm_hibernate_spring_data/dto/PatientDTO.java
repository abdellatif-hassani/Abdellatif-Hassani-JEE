package ma.enset.orm_hibernate_spring_data.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.orm_hibernate_spring_data.entities.RendezVous;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor  @NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private Date birthDay;
    private boolean sick;
    private int score;
}

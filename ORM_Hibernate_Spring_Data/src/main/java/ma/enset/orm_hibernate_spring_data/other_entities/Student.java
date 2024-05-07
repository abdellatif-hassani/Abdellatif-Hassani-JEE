package ma.enset.orm_hibernate_spring_data.other_entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Enabled
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("student")
public class Student extends Person{
    private Double note;
}

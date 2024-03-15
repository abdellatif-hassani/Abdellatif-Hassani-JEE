package ma.enset.orm_hibernate_spring_data.repository;

import ma.enset.orm_hibernate_spring_data.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends IRepository<Patient, Long> {
    List<Patient> findPatientByNameContainsIgnoreCase(String name);
}

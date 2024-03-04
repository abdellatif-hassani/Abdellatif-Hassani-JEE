package ma.enset.orm_hibernate_spring_data.repository;

import ma.enset.orm_hibernate_spring_data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends IRepository<Patient, Long> {
    List<Patient> findPatientByName(String name);
//    @Query("select p from #{#entityName} p where p.name like :x")
//    List<Patient> search(@Param("x") String keyword);
}

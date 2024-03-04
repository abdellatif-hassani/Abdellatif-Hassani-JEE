package ma.enset.orm_hibernate_spring_data.service;

import jakarta.transaction.Transactional;
import ma.enset.orm_hibernate_spring_data.dto.PatientDTO;
import ma.enset.orm_hibernate_spring_data.entities.Patient;
import ma.enset.orm_hibernate_spring_data.mappers.PatientMapper;
import ma.enset.orm_hibernate_spring_data.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PatientService implements IPatientService{
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public void add(PatientDTO patient) {
        patientRepository.save(patientMapper.toPatient(patient));
    }

    //Retrieving all patients
    public List<PatientDTO> getAllPatients() {
        return patientMapper.toPatientDTOs(patientRepository.findAll());
    }
}

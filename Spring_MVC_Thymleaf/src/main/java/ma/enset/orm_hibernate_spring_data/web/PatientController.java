package ma.enset.orm_hibernate_spring_data.web;

import ma.enset.orm_hibernate_spring_data.dto.PatientDTO;
import ma.enset.orm_hibernate_spring_data.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping({"", "/search"})
    public String index(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword){
        List<PatientDTO> patients = patientService.getPatients(keyword);
        model.addAttribute("patients", patients);

        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}

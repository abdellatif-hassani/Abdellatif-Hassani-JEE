package ma.enset.orm_hibernate_spring_data.web;

import ma.enset.orm_hibernate_spring_data.dto.PatientDTO;
import ma.enset.orm_hibernate_spring_data.service.PatientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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
        model.addAttribute("keyword", keyword);
        return "patients";
    }
    //Deleting a patient
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
    //Showing the edit form
    @GetMapping("/editForm")
    public String showEditForm(Model model, @RequestParam(name = "id") Long id){
        PatientDTO patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "editPatient";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "score") int score,
                       @RequestParam(name = "sick", defaultValue = "false") boolean sick,
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "birthDay") Date birthDay){
        System.out.println(sick);
        PatientDTO patientDTO = patientService.editPatient(id, name, score, birthDay, sick);
        System.out.println("test");
        return "redirect:/patients";
    }
}

package ma.enset.orm_hibernate_spring_data.web;

import jakarta.validation.Valid;
import ma.enset.orm_hibernate_spring_data.dto.PatientDTO;
import ma.enset.orm_hibernate_spring_data.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.Date;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping({"", "/search"})
    public String index(Model model,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name = "page", defaultValue = "1") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size){
        Pageable pageable = PageRequest.of(page-1, size);
        Page<PatientDTO> patients = patientService.getPatients(keyword, pageable);
        int currentPage = patients.getNumber()+1;
        long totalItems = patients.getTotalElements();
        int pages = patients.getTotalPages();
        model.addAttribute("patients", patients);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", pages);
        System.out.println("Total pages: "+pages);
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
    public String showEditForm(Model model, @RequestParam(name = "id") Long id,
                               @RequestParam(name = "currentPage") int currentPage){
        PatientDTO patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        model.addAttribute("currentPage", currentPage);
        return "editPatient";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("patientDTO") PatientDTO patient, BindingResult result,
                       @RequestParam(name = "page") int page){
        if (result.hasErrors()) {
                System.out.println("Edit Form Error : "+result.getFieldError().getDefaultMessage());
                 return "editPatient";
        }
        patientService.editPatient(patient);
        return "redirect:/patients?page="+page;
    }

    @GetMapping("/addForm")
    public String showAddForm(){
        return "addPatient";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("patientDTO") PatientDTO patient, BindingResult result){
        if (result.hasErrors()) {
            System.out.println("errop");
            return "patients";
        }
        patientService.add(patient);
        return "redirect:/patients";
    }

    /*@GetMapping("/error")
    public String error(){
        return "error";
    }*/

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}

package main.lab13java.controllers;

import lombok.AllArgsConstructor;
import main.lab13java.dao.ApplicationRepository;
import main.lab13java.entities.Applicant;
import main.lab13java.entities.Application;
import main.lab13java.entities.Specialization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ApplicationController extends Application {
    private ApplicationRepository applicationRepository;

    @GetMapping("/application")
    public String showApplications(Model model, @RequestParam int id){
        List<Application> applications = applicationRepository.findByIdApplicant_IdOrderByIdAsc(id);
        model.addAttribute("applications", applications);
        return "application";
    }

    @GetMapping("/applicants_specialization")
    public String showApplicationsSpecialization(Model model, @RequestParam int id){
        List<Application> applications = applicationRepository.findByIdSpecialization_IdOrderByIdAsc(id);
        model.addAttribute("applications", applications);
        return "applicants_specialization";
    }
    @GetMapping("/delete_application")
    public String deleteApplication(@RequestParam int id){
        applicationRepository.deleteById(id);
        return "redirect:/application?id=1";
    }

    @PostMapping("/add_application")
    public String addApplication(@RequestParam Applicant id_applicant, @RequestParam Specialization id_specialization, @RequestParam String status, @RequestParam int mark){
        Application application = new Application();
        application.setIdApplicant(id_applicant);
        application.setIdSpecialization(id_specialization);
        application.setStatus(status);
        application.setMark(mark);
        applicationRepository.save(application);
        return "redirect:/application?id=1";
    }

    @GetMapping("/edit_application")
    public String editApplicant(@RequestParam int id, Model model){
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if (optionalApplication.isEmpty()){
            return "redirect:/application?id=1";
        }
        else {
            model.addAttribute("applicatione", optionalApplication.get());
            return "edit_application";
        }
    }

    @PostMapping("/update_application")
    public String editApplication(@RequestParam int id, @RequestParam Applicant aidApplicant, @RequestParam Specialization aidSpecialization, @RequestParam String astatus, @RequestParam int amark){
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if (optionalApplication.isPresent()){
            Application a = optionalApplication.get();
            a.setIdApplicant(aidApplicant);
            a.setIdSpecialization(aidSpecialization);
            a.setStatus(astatus);
            a.setMark(amark);
            applicationRepository.save(a);
        }
        return "redirect:/application?id=1";
    }
}

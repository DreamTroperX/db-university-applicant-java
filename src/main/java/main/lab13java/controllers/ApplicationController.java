package main.lab13java.controllers;

import lombok.AllArgsConstructor;
import main.lab13java.dao.ApplicationRepository;
import main.lab13java.entities.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ApplicationController {
    private ApplicationRepository applicationRepository;

    @GetMapping("/application")
    public String showApplications(Model model, @RequestParam int id){
        List<Application> applications = applicationRepository.findByIdApplicant_IdOrderByIdAsc(id);
        model.addAttribute("applications", applications);
        return "application";
    }
    @GetMapping("/delete_application")
    public String deleteApplicant(@RequestParam int id){
        applicationRepository.deleteById(id);
        return "redirect:/application";
    }
    /*@PostMapping("/add_application")
    public String addApplication(Model model, @RequestParam int idSpecialization){}
    Application application = new Application();
    application.set
    return "redirect:/applicantion";*/
}

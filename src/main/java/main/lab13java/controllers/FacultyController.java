package main.lab13java.controllers;


import lombok.AllArgsConstructor;
import main.lab13java.dao.FacultyRepository;
import main.lab13java.entities.Applicant;
import main.lab13java.entities.Faculty;
import main.lab13java.entities.Specialization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FacultyController {
    private FacultyRepository facultyRepository;

    @GetMapping("/information")
    public String showInformation(Model model){
        return "information";
    }
    @GetMapping("/faculties")
    public String showApplicants(Model model){
        List<Faculty> faculties = facultyRepository.findAll();
        model.addAttribute("faculties", faculties);
        return "faculties";
    }
}

package main.lab13java.controllers;

import lombok.AllArgsConstructor;
import main.lab13java.dao.SpecializationRepository;
import main.lab13java.entities.Faculty;
import main.lab13java.entities.Specialization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class SpecializationController {
    private SpecializationRepository specializationRepository;
    @GetMapping("/specializations")
    public String showSpecializations(Model model, @RequestParam int id){
        List<Specialization> specializations = specializationRepository.findByIdFaculty_IdOrderByIdAsc(id);
        model.addAttribute("specializations", specializations);
        return "specializations";
    }
}

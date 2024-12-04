package main.lab13java.controllers;

import lombok.AllArgsConstructor;
import main.lab13java.dao.SpecializationRepository;
import main.lab13java.entities.Faculty;
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
public class SpecializationController {
    private SpecializationRepository specializationRepository;
    @GetMapping("/specializations")
    public String showSpecializations(Model model, @RequestParam int id){
        List<Specialization> specializations = specializationRepository.findByIdFaculty_IdOrderByIdAsc(id);
        model.addAttribute("specializations", specializations);
        return "specializations";
    }

    @GetMapping("/delete_specialization")
    public String deleteSpecialization(@RequestParam int id){
        specializationRepository.deleteById(id);
        return "redirect:/specializations?id=1";
    }

    @PostMapping("/add_specialization")
    public String addSpecialization(@RequestParam Faculty idFaculty, @RequestParam int number, @RequestParam int numberOfStudents, @RequestParam String name, @RequestParam String description){
        Specialization specialization = new Specialization();
        specialization.setIdFaculty(idFaculty);
        specialization.setNumber(number);
        specialization.setNumberOfStudents(numberOfStudents);
        specialization.setDescription(description);
        specialization.setName(name);
        specializationRepository.save(specialization);
        return "redirect:/specializations?id=1";
    }

    @GetMapping("/edit_specialization")
    public String editSpecialization(@RequestParam int id, Model model){
        Optional<Specialization> optionalSpecialization = specializationRepository.findById(id);
        if (optionalSpecialization.isEmpty()){
            return "redirect:/specializations?id=1";
        }
        else {
            model.addAttribute("specialization", optionalSpecialization.get());
            return "edit_specialization";
        }
    }

    @PostMapping("/update_specialization")
    public String editSpecialization(@RequestParam int id, @RequestParam Faculty aidFaculty, @RequestParam int anumber, @RequestParam int anumberOfStudents, @RequestParam String aname, @RequestParam String adescription){
        Optional<Specialization> optionalSpecialization = specializationRepository.findById(id);
        if (optionalSpecialization.isPresent()){
            Specialization a = optionalSpecialization.get();
            a.setIdFaculty(aidFaculty);
            a.setNumber(anumber);
            a.setNumberOfStudents(anumberOfStudents);
            a.setName(aname);
            a.setDescription(adescription);
            specializationRepository.save(a);
        }
        return "redirect:/specializations?id=1";
    }

}

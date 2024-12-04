package main.lab13java.controllers;


import lombok.AllArgsConstructor;
import main.lab13java.dao.FacultyRepository;
import main.lab13java.entities.Faculty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FacultyController {
    private final FacultyRepository facultyRepository;

    @GetMapping("/faculties")
    public String showFaculties(Model model){
        List<Faculty> faculties = facultyRepository.findAll();
        model.addAttribute("faculties", faculties);
        return "faculties";
    }

    @GetMapping("/delete_faculty")
    public String deleteFaculty(@RequestParam int id){
        facultyRepository.deleteById(id);
        return "redirect:/faculties";
    }

    @PostMapping("/add_faculty")
    public String addFaculty(@RequestParam String name, @RequestParam String description, @RequestParam String deanName, @RequestParam int numberOfStudents, @RequestParam int numberOfTeachers){
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setDescription(description);
        faculty.setDeanName(deanName);
        faculty.setNumberOfStudents(numberOfStudents);
        faculty.setNumberOfTeachers(numberOfTeachers);
        facultyRepository.save(faculty);
        return "redirect:/faculties";
    }

    @GetMapping("/edit_faculty")
    public String editFaculty(@RequestParam int id, Model model){
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isEmpty()){
            return "redirect:/faculties";
        }
        else {
            model.addAttribute("faculty", optionalFaculty.get());
            return "edit_faculty";
        }
    }

    @PostMapping("/update_faculty")
    public String editFaculty(@RequestParam int id, @RequestParam String aname, @RequestParam String adescription, @RequestParam String adeanName, @RequestParam int anumberOfStudents, @RequestParam int anumberOfTeachers){
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()){
            Faculty a = optionalFaculty.get();
            a.setName(aname);
            a.setDescription(adescription);
            a.setDeanName(adeanName);
            a.setNumberOfStudents(anumberOfStudents);
            a.setNumberOfTeachers(anumberOfTeachers);
            facultyRepository.save(a);
        }
        return "redirect:/faculties";
    }

}
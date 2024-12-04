package main.lab13java.controllers;

import lombok.AllArgsConstructor;
import main.lab13java.dao.AdmisionExamRepository;
import main.lab13java.entities.AdmisionExam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AdmisionExamController {
    private AdmisionExamRepository admisionExamRepository;

    @GetMapping("/admision_exams")
    public String showAdmisionExams (Model model){
        List<AdmisionExam> admisionExams = admisionExamRepository.findAll();
        model.addAttribute("admisionExams", admisionExams);
        return "admision_exams";
    }

    @PostMapping("/add_admision_exam")
    public String addAdmisionExam(@RequestParam String subject, @RequestParam int passingMark, @RequestParam LocalTime time, @RequestParam String adress, @RequestParam LocalDate date){
        AdmisionExam admisionExam = new AdmisionExam();
        admisionExam.setSubject(subject);
        admisionExam.setPassingMark(passingMark);
        admisionExam.setTime(time);
        admisionExam.setAdress(adress);
        admisionExam.setDate(date);
        admisionExamRepository.save(admisionExam);
        return "redirect:/admision_exams";
    }

    @GetMapping("/delete_admision_exam")
    public String deleteAdmisionExam(@RequestParam int id){
        admisionExamRepository.deleteById(id);
        return "redirect:/admision_exams";
    }

    @GetMapping("/edit_admision_exam")
    public String editAdmisionExam(@RequestParam int id, Model model){
        Optional<AdmisionExam> optionalAdmisionExam = admisionExamRepository.findById(id);
        if (optionalAdmisionExam.isEmpty()){
            return "redirect:/admision_exams";
        }
        else {
            model.addAttribute("admisionExam", optionalAdmisionExam.get());
            return "edit_admision_exam";
        }
    }

    @PostMapping("/update_admision_exam")
    public String editAdmisionExam(@RequestParam int id,@RequestParam String asubject, @RequestParam int apassingMark, @RequestParam LocalTime atime, @RequestParam String aadress, @RequestParam LocalDate adate){
        Optional<AdmisionExam> optionalAdmisionExam = admisionExamRepository.findById(id);
        if (optionalAdmisionExam.isPresent()){
            AdmisionExam a = optionalAdmisionExam.get();
            a.setSubject(asubject);
            a.setPassingMark(apassingMark);
            a.setTime(atime);
            a.setAdress(aadress);
            a.setDate(adate);
            admisionExamRepository.save(a);
        }
        return "redirect:/admision_exams";
    }
}
